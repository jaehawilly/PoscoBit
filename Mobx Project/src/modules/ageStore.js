import { observable } from 'mobx';

// class AgeStore1 {

//     @observable
//     age = 5
// }


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