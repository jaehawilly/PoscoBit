import { Observer } from 'mobx-react';
import AgeStore from '../modules/ageStore';

const Dpp = () => {

    return (<Observer>{() => (
        <div id='container4'>
            <h1>Dpp</h1>
            <p>2번 값 : {AgeStore.age}</p>
            
        </div>
    )}</Observer>)
}

export default Dpp;