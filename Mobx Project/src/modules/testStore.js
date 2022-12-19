import { observable } from 'mobx';

const testStore = observable({
    // state
    test: {
        code : '문자열입니다.'
    },

    // action
    writeCode(code) {
        this.test.code = code;
    }
});

export default testStore;