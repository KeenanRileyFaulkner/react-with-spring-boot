import logo from './logo.svg';
import React, {useEffect, useState} from "react";
import './App.css';
import axios from 'axios';

const App = () => {
  const [jokes, setJokes] = useState([]);

  let jokesFromServer = [];
  useEffect(() => {
    axios.get('/api/dadjokes')
        .then(res => {
            console.log(res.data._embedded)
          jokesFromServer = [...res.data._embedded.dadJokes];
          setJokes(jokesFromServer);
        })
        .catch(err => console.log(err));
  }, [])

  const jokeTexts = jokes.map(joke => <h3 key={joke._links.self}>{joke.joke}</h3>);
  return (
      <div className="App">
        <header>
          <img src={logo} className="App-logo" alt="logo" />
          {jokeTexts}
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
  );
}

export default App;