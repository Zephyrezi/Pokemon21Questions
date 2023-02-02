import logo from './logo.svg';
import './App.css';
import React, { useState } from 'react';

function App() {
const [count, setCount] = useState(0);
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
        Hi your kinda cute :)
        </p>
            <p>You clicked {count} times</p>
              <button onClick={() => setCount(count + 1)}>
                Click me
              </button>
      </header>
    </div>
  );
}

export default App;
