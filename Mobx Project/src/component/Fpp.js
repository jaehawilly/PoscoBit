import React from 'react';
import { Observer } from 'mobx-react';
import Gpp from './Gpp';
import emailStore from '../modules/emailStore';

const Fpp = () => {

    const onClickIncrease = () => {
        emailStore.increaseAction(5000);
    }

    const onClickDecrease = () => {
        emailStore.decreaseAction(5000);
    }

    return (<Observer>{() => (
        <div id ='container3'>
            <h1>Fpp</h1>
            <p>3번 값 : {emailStore.num}</p>

            <button onClick={onClickIncrease}>증가</button>
            <button id='button1' onClick={onClickDecrease}>감소</button>
            <Gpp/>
            
        </div>
    )}</Observer>)
}

export default Fpp;