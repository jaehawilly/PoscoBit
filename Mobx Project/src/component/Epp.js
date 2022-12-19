import React from 'react';
import { Observer } from 'mobx-react';
import AgeStore from '../modules/ageStore';
import Fpp from './Fpp';

const Epp = () => {

    const onClickIncreaseAge = () => {
      AgeStore.increaseAction(100);
    }

    const onClickDecreaseAge = () => {
        AgeStore.decreaseAction(100);
    }

    return (<Observer>{() => (
        <div id='container2'>
            <h1>Epp</h1>
            <p>2번 값 : {AgeStore.age}</p>

            <button onClick={onClickIncreaseAge}>증가</button>
            <button id='button1' onClick={onClickDecreaseAge}>감소</button>
            <Fpp/>
            
        </div>
    )}</Observer>)
}

export default Epp;