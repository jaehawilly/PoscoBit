import React from 'react';
import { Observer } from 'mobx-react';
import NumberStore from '../modules/numberStore';
import testStore from '../modules/testStore';

const Gpp = () => {

    return (<Observer>{() => (
        <div id='container4'>
            <h1>Gpp</h1>
            <p>1번 값 : {NumberStore.num}</p>

            <p>문자열 : {testStore.test.code}</p>
            
            
        </div>
    )}</Observer>)
}

export default Gpp;