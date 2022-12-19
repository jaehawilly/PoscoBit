import React, { useState } from 'react';
import { Observer } from 'mobx-react';
import NumberStore from '../modules/numberStore';
import testStore from '../modules/testStore';
import Cpp from './Cpp';

const Bpp = () => {
    const [ text, setText ] = useState("");

    const onClickIncrease = () => {
        NumberStore.increaseAction(5);
    }

    const onClickDecrease = () => {
        NumberStore.decreaseAction(5);
    }

    return (<Observer>{() => (
        <div id='container2'>
            <h1>Bpp</h1>
            <p>1번 값 : {NumberStore.num}</p>

            <button onClick={onClickIncrease}>증가</button>
            <button id='button1' onClick={onClickDecrease}>감소</button>

            <p>문자열 : {testStore.test.code}</p>
            
            <input type='text' onChange={(e) => {setText(e.target.value)}}/>
            <button id='button2' onClick={() => {testStore.writeCode(text)}}>전송</button>
            
            <Cpp/>
        </div>
    )}</Observer>)
}

export default Bpp;