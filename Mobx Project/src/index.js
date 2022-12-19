// 4
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <App />
);

reportWebVitals();





/*
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App, { reducers } from './App';
import reportWebVitals from './reportWebVitals';
import { createStore } from 'redux';

const store = createStore(reducers);
const root = ReactDOM.createRoot(document.getElementById('root'));
const listener = () => {
  root.render(
    <App store={store} />
  );
};
store.subscribe(listener);
listener();
reportWebVitals();
*/








/*
// 원본
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <App />
);

reportWebVitals();
*/