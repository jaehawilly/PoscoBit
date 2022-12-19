import numberStore from './numberStore';
import ageStore from './ageStore';
import testStore from './testStore';
import emailStore from './emailStore';

const indexStore = () => ({ 
    numberStore,
    ageStore,
    testStore,
    emailStore
});

export default indexStore;