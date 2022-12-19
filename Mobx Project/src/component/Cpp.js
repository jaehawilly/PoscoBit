import React from 'react';
import { Observer } from 'mobx-react';
import Dpp from './Dpp';
import emailStore from '../modules/emailStore';

const Cpp = () => {
    return (<Observer>{() => (
        <div id='container3'>
            <h1>Cpp</h1>
            <p>3번 값 : {emailStore.num}</p>
            <Dpp/>
        </div>
    )}</Observer>)
}

export default Cpp;