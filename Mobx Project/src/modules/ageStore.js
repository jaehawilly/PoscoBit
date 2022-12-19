import { observable } from 'mobx';

const AgeStore = observable({
    // state
    age: 0,

    // action
    increaseAction(age) {
        this.age = this.age + age;
    },
    
    decreaseAction(age) {
        this.age = this.age - age;
    }
});

export default AgeStore;