import { Observer } from 'mobx-react';
import React from 'react';
import './App.css'
import Bpp from './component/Bpp';
import Epp from './component/Epp';
import indexStore from './modules/indexStore';

const App = () => {
  const {numberStore, ageStore, testStore, emailStore} = indexStore();
    return (<Observer>{() => (
      <div id='container'>
        <h1>App</h1>
        <p>[state 값]</p>
        <p>1번 값 : {numberStore.num}</p>
        <p>2번 값 : {ageStore.age}</p>
        <p>3번 값 : {emailStore.num}</p>
        <p>문자열 : {testStore.test.code}</p>
      <div id='grid'>
        <Bpp/>
        <Epp/>
      </div>
      </div>)
    }</Observer>);
}

export default App;