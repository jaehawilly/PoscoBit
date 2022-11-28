/*
// ex72-1)
// 1. let : ES6문법이다.

// 2. 템플릿 문자열
let aa = 10;
let bb = 'tiger';
let cc = `무${aa}궁${bb}화`;
console.log(cc);

// 3. 비구조화 할당(객체, 배열)
let obj = {
  name: '호랑이',
  age: 20,
}

let { name, age } = obj;
console.log('ex3', name, age);

function f1({ name, age }) {
  console.log('ex3', name, age);
}
f1(obj);

let ar = [10, 20, 30];
let [cat, dog, tiger] = ar;
console.log(cat, dog, tiger);

function f2([cat, dog, tiger]) {
  console.log(cat, dog, tiger);
}
f2(ar);
*/


/*
// ex72-2)
// 4. 비구조화 할당(리네임)
let obj = {
  a: 10,
  b: 'tiger',
};
let { a: tiger, b: lion } = obj;
// console.log(a, b);
console.log(tiger, lion);


//
let initialState = {
  post: {

  }
};
let payload = {
  data: {
    str: '소나무',
  }
};
let { data: post } = payload;
console.log(data);
console.log(post.str);


// 5. 향상된 객체 리터럴
let a = 10;
let c = 30;
// 상단에 정의된 변수를 객체에 사용하면
// 객체의 속성으로 정의된다.
let obj2 = {
  a,
  b: 20,
  c,
};
console.log(obj2.a, obj2.b, obj2.c);


// 6. 간결한 함수 정의 추가
let obj3 = {
  f1: function () {
    console.log(1);
  },
  f2: () => {
    console.log(1);
  },
  f3() {
    console.log('간결한 함수', 3);
  },
};
obj3.f3();
*/


/*
// e72-3) ES6문법
// 7. 전개 연산(...)
let obj1 = { a: 1, b: 2 };
let obj2 = { c: 3, d: 3 };
let obj3 = { ...obj1, ...obj2 };
console.log(obj3);
let ar = [1, 2, 3];
let br = [2, 3, 4];
let cr = [...ar, ...br];
console.log(cr);


// 8. 클래스 등장
function f1(a, b = 20, c = 10) {
  console.log(a, b, c);
}
f1();
f1(30); // 30 20 10
f1(30, 40); // 30 40 10
f1(30, 40, 50); // 30 40 50
*/


/*
// 10
let obj = {
  a: 10,
  b: 99,
  f: function () {
    return this.a + this.b;
  }
};

// 새로운 키를 만들려고 하는건지
// 기존의 키를 덮으려고 하는건지.

let b = Symbol('b');
obj[b] = 100;
console.log(obj.f());
console.log(obj[b]); //Symbol b
console.log(obj.b);
*/







/*
// ex71)
class Tiger extends Array {
  f1() {
    console.log('f1');
  }
  f2() {
    console.log('f2');
    this.f1();
  }
  f3() {
    let result = this.filter((v, index) => {
      console.log(v, index);
      return this.indexOf(v) === index;
    });

    return result;
  }
  f4() {
    return this.reduce((a, c) => a + c, 0);
  }
  main() {

  }
}
let ar = new Tiger(1, 1, 2, 2, 3, 3, 4);
console.log(ar.length);
ar.f2();
let br = ar.f3();
console.log('br: ', br);
console.log(ar.f4());
*/





/*
// ex70)
class Base {
  constructor(a, b) {
    console.log(a, b);
    this.a = a;
    this.b = b;
    console.log('확인1');
  }
}
class Derived extends Base {
  constructor(a, b, c) {
    super(a, b + c); // 3, 9
    console.log('확인2');
  }
}

// new Derived();
// new Derived(3);
// new Derived(3, 4);
new Derived(3, 3, 5);
*/




/*
// ex69)
class Animal {
  f1() {
    console.log(1);
  }
  f2() {
    console.log(21);
  }
}
class Birds extends Animal {
  f2() {
    console.log(22);
  }
  f3() {
    console.log(3);
  }
}

let obj = new Birds();
obj.f1();
obj.f2();
obj.f3();
*/




// ex68)
// 생성자 함수 기본꼴
// function Person(name) {
//   this.name = name;

// }
// Person.prototype.f1 = function () {
//   console.log(this.name);
// }
// let person = new Person('홍길동');
// person.f1();


// 생성자 함수 안에서 prototype 사용
// function Person(name) {
//   this.name = name;

//   Person.prototype.f1 = function () {
//     console.log(this.name);
//   }
// }
// let person = new Person('홍길동');
// person.f1();



// function f1() {
//   function f2() {
//     console.log(1000);
//   }
//   return f2;
// }
// let f3 = f1();
// f3();

// 위, 아래 두개 똑같은 형태

// function func() {
//   function Person(name) {
//     this.name = name;

//     Person.prototype.f1 = function () {
//       console.log(this.name);
//     }
//   }
//   console.log(typeof Person);
//   return Person;
// }
// let Test = func();
// let ins = new Test('홍길동');
// ins.f1();



// let f3 = function f1() {
//   function f2() {
//     console.log(1000);
//   }
//   return f2;
// };
// f3();

// let test = (function func() {
//   function Person(name) {
//     this.name = name;

//     Person.prototype.f1 = function () {
//       console.log(this.name);
//     }
//   }
//   console.log(typeof Person);
//   return Person;
// })();

// let ins = new Test('홍길동');
// ins.f1();


// ex68-3)
// let Person2 = (function () {
//   function Person(name) {
//     this.name = name;
//     Person.prototype.f1 = function () {
//       console.log(this.name);
//     }
//   }
//   return Person;
// })();
// let ps = new Person2('홍길동');
// ps.f1();


// // ex68-4)
// // JS : 아직까지는
// function Person(name) {

// }

// // React 대세로 사용하는 문법
// class Person {
//   constructor() {
//     console.log(1);
//   }
// }
// let p = new Person();


/*
// ex68-4) React 대세로 사용하는 문법
// 1. 변수
// 2. 생성자
// 3. 함수
class Person {
  // 멤버변수 생성1
  n1 = 10;

  constructor(n3) {
    console.log(1);
    // 멤버변수 생성2
    this.n2 = 20;
    this.n3 = n3;
  }
  f1() {
    console.log(this.n1, this.n2, this.n3);
  }
}

let p = new Person(30);
p.f1();
*/




/*
// ex68-5)
class Person {
  n1 = 10;
  static n4 = 40;
  constructor(n3) {
    console.log(1);
    this.n2 = 20;
    this.n3 = n3;
  }
  f1() {
    console.log(this.n1, this.n2, this.n3);
  }
  static f2() {
    console.log('static call', this.n4);
  }
}

let p = new Person(30);
p.f1();
Person.f2();
*/


/*
// ex68-6)
function Person() {
  // 일반 함수
  Person.prototype.f1 = function () {
    console.log(1);
  }
  Person.f2 = function () {
    console.log(2);
  }
}
let p = new Person();
p.f1();
Person.f2(); // static
*/


/*
// ex68-7)
// 리네임이 일어난다.
let Person2 = class Person {

}
// let p1 = new Person();
let p1 = new Person2();
*/


/*
// ex68-8)
class Apple {
  static getArea(w, h) {
    return w * h;
  }
}
console.log(Apple.getArea(3, 4));

class Banana {
  constructor(w, h) {
    this.w = w;
    this.h = h;
  }
  getArea() {
    return this.w * this.h;
  }
}
let p = new Banana(4, 5);
console.log(p.getArea());
*/


/*
// ex68-9)
// set, get을 이용한 필드 생성 방법
// class Person {
//   set num(n) {
//     console.log(1);
//     this.n = n;
//   }
//   get num() {
//     console.log(2);
//     return this.n;
//   }
// }
// let p = new Person();
// p.num = 200;
// console.log(p.num);


class Person {
  constructor(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  get fullName() {
    // return '성 : ' + this.firstName + ' ' + '이름 : ' + this.lastName;
    return `성: ${this.firstName} 이름: ${this.firstName} 입니다`; //`(backquote) 사용
  }
  set fullName(name) {
    [this.firstName, this.lastName] = name.split(' ');
    console.log('result : ', this.firstName, this.lastName);
  }
}
let p = new Person('white', 'tiger');
console.log(10, p.fullName);
p.fullName = 'red rabbit';
console.log(20, p.fullName); // redrabbit

let aa = 10;
let bb = 'tiger';
let cc = `무궁화${aa}꽃이 ${bb}피었습니다.`;
console.log(cc);


// let str = 'red rabbit';
// let result = str.split(' ');
// console.log(result);
*/

/*
// ex68-10)
class Person {
  // #을 붙이면 private변수가 된다.
  #name = 'tiger';
  f1() {
    console.log(1);
    console.log(this.#name);
  }
}

let p = new Person();
console.log(p.name);
p.f1();
*/





/*
// ex67)
let obj1 = {
  a: 10,
  b: '호랑이',
};
console.log(typeof obj1, obj1);

// 객체 >> JSON(string) >> 네트워크 데이터 전송 >> JSON(string) >> 객체

// Serializable
// 객체 >> JSON(string)
let sendData = JSON.stringify(obj1);
console.log(typeof sendData, sendData);

// 네트워크 데이터 전송 >> JSON(string)
let recvData = sendData;

// JSON(string) >> 객체
let obj2 = JSON.parse(recvData);
console.log(typeof obj2, obj2);
*/



/*
// ex66) 수학 함수(Math)
console.log(Math.PI);
console.log(Math.abs(-5));
console.log(Math.ceil(3.14));
console.log(Math.ceil(-3.14));
console.log(Math.floor(3.14));
console.log(Math.floor(-3.14));
console.log(Math.round(3.14));
console.log(Math.round(-3.14));

console.log(Math.max(55, 54, 66, 77)); // 인수 여러개 전달 가능(자바와 다름)
console.log(Math.min(55, 54, 66, 77));

// **
console.log(Math.pow(2, 4));
console.log(Math.sqrt(9));

for (let i = 0; i < 5; i++) {
  // console.log(Math.random());
  // console.log(Math.random() * 10); // 소수
  console.log(Math.floor(Math.random() * 10)); // 정수
}

// 별도 설명
// radian값을 넣어야 한다.(180 : 3.14 = 30(도) : x)
function degreeToRadian(degree) {
  return Math.sin(Math.PI * degree / 180.0);
}
// x = 30(도)에 해당되는 radian 값
console.log(Math.sin(Math.PI * 30.0 / 180.0)); // > 0.49999999999999994 (0.5의 근사값)
console.log(degreeToRadian(30)); // 이렇게 함수로도 나타낼 수 있다.
*/





/*
// ex65) 상속
// function Apple() {
//   this.a = 10;
// }
// function Banana() {
//   this.b = 20;
// }
// Banana.prototype = new Apple();
// Banana.prototype.constructor = Banana;

// const obj = new Banana();
// console.log(obj.a, obj.b);



function Apple() {
  this.query = {
    name: '홍길동',
    age: 20,
  };
}
function Banana() {
  this.request = {
    x: 10,
    y: 20,
  };
}
Banana.prototype = new Apple();
Banana.prototype.constructor = Banana;

const ctx = new Banana();

console.log(ctx.request);
console.log(ctx.query); // 이 코드가 성립이 되면 상속을 의심해봐야 한다.
*/




/*
// ex64)
// step1)
// let obj0 = { name: '호랑이0', n1: 10, n2: 60 };
// let obj1 = { name: '호랑이1', n1: 20, n2: 70 };
// let obj2 = { name: '호랑이2', n1: 30, n2: 80 };
// let obj3 = { name: '호랑이3', n1: 40, n2: 90 };
// let obj4 = { name: '호랑이4', n1: 50, n2: 99 };

// let ar = [];
// ar.push(obj0);
// ar.push(obj1);
// ar.push(obj2);
// ar.push(obj3);
// ar.push(obj4);

// ar.forEach((v, i) => {
//   console.log(v.name, v.n1, v.n2);
// });


// step2)
// function makeInfo(name, n1, n2) {
//   return {
//     name: name,
//     n1: n1,
//     n2: n2,
//   };
// }
// let ar = [];
// ar.push(makeInfo('호랑이0', 10, 60));
// ar.push(makeInfo('호랑이1', 20, 70));
// ar.push(makeInfo('호랑이2', 30, 80));
// ar.push(makeInfo('호랑이3', 40, 90));
// ar.push(makeInfo('호랑이4', 50, 99));


// step3)
// function MakeInfo(name, n1, n2) {
//   this.name = name;
//   this.n1 = n1;
//   this.n2 = n2;
// }

// MakeInfo.prototype.output = function () {
//   console.log(this.name, this.n1, this.n2, this.sum);
// }

// let ar = [];
// ar.push(new MakeInfo('호랑이0', 10, 60));
// ar.push(new MakeInfo('호랑이1', 20, 70));
// ar.push(new MakeInfo('호랑이2', 30, 80));
// ar.push(new MakeInfo('호랑이3', 40, 90));
// ar.push(new MakeInfo('호랑이4', 50, 99));

// ar.forEach((v, i) => {
//   console.log(v.name, v.n1, v.n2);
// });

// ar.forEach((v, i) => {
//   ar[i].sum = v.n1 + v.n2;
// });

// ar.forEach((v, i) => {
//   console.log(v.name, v.n1, v.n2, v.sum);
// });

// for (const key in ar) {
//   ar[key].output();
// }
*/



/*
// ex63)
// 객체의 함수 추가
let obj = {};
obj.f1 = function () {
  console.log(1);
}
obj.f1();


// 생성자함수에서 함수추가
function F1() { };
F1.prototype.f1 = function () {
  console.log(2);
}
let ins = new F1();
ins.f1();
*/


/*
// ex62)
// 일반함수
function f1() {
  return {
    a: 10,
    f: function () { },
  };
}
let obj1 = f1();
let obj2 = f1();
console.log(obj1.f === obj2.f);

// 생성자 함수(class)
function F1() {
  this.a = 10;
  this.f = function () { }
}
let ins1 = new F1();
let ins2 = new F1();
// 이러한 단점.
console.log(ins1.f === ins2.f);

// 생성자 함수는 변수만 설정하고, 내부 함수는 밖으로 뺀다.
function F2() {
  this.a = 10;
}
F2.prototype.f = function () { };

let ins3 = new F2();
let ins4 = new F2();
console.log(ins3.f === ins4.f);
*/




/*
// ex61) 생성자함수(클래스) = 인스턴스
// {} : 객체, new : 인스턴스
function Apple() {
  this.s = 'tiger';
  this.n = 10;
  this.f = function () {
    console.log(this.s, this.n);
  }
}
let ins = new Apple();
ins.f();
*/



/*
// EX60)

              문자열    배열    객체
length          o       o        x
forEach         x       o        x
for in          o       o        o
for of          o       o        x
map             x       o        x


let str = 'abcde';
let arr = [10, 20, 30];
let obj = { a: 40, b: 50 };

console.log(str.length);
console.log(arr.length);
console.log(obj.length);

str.forEach((v, i) => {
  console.log(v);
})
arr.forEach((v, i) => {
  console.log(v);
})
obj.forEach((v, i) => {
  console.log(v);
})
*/







/*
// ex59)
// 0번 인덱스가 있는가?
if (0 in [10, 20, 30, 40]) {
  console.log(1);
} else {
  console.log(2);
}
*/




// --------------------reduce 함수 예제--------------------
// special ex) Reduce
/*
// ex1)
const array1 = [1, 2, 3, 4];
const initialValue = 0;
const sumWithInitial = array1.reduce(
  (accumulator, currentValue) => accumulator + currentValue,
  initialValue
);
console.log(sumWithInitial);
*/


/*
// ex2)
var maxCallback = (acc, cur) => Math.max(acc.x, cur.x);
var maxCallback2 = (max, cur) => Math.max(max, cur);

// initialValue 없이 reduce
// [{ x: 22}, {x: 42}].reduce(maxCallback); // 42
// [{ x: 22}         ].reduce(maxCallback); // { x: 22}
// [                 ].reduce(maxCallback); // TypeError

// map/reduce로 개선 - 비었거나 더 큰 배열에서도 동작함
[ { x: 22 }, { x: 42 } ].map( el => el.x ).reduce( maxCallback2, -Infinity );
*/


/*
// ex3) reduce()의 작동 방식
// 1.
let ar = [0, 1, 2, 3, 4].reduce(function (accumulator, currentValue, currentIndex, array) {
  return accumulator + currentValue;
});
console.log(ar);
// 2. 화살표 함수
let br = [0, 1, 2, 3, 4].reduce((prev, curr) => prev + curr);
console.log(br);
// 3. 초기값 제공하는 경우
let cr = [0, 1, 2, 3, 4].reduce(function (accumulator, currentValue, currentIndex, array) {
  return accumulator + currentValue;
}, 10);
console.log(cr);
*/


/*
// ex4-1) 배열의 모든 값 계산
var sum = [0, 1, 2, 3].reduce(function (accumulator, currentValue) {
  return accumulator + currentValue;
}, 0);
console.log("sum : " + sum);
*/


/*
// ex4-2) 배열의 모든 값 계산(화살표 사용)
var total = [0, 1, 2, 3].reduce(
  (accumulator, currentValue) => accumulator + currentValue
  ,0
);
console.log("total : " + total);
*/


/*
// ex5) 객체 배열에서의 값 합산(반드시 초기값을 주어야 한다.)
var initialValue = 0;
var sum = [{ x: 1 }, { x: 2 }, { x: 3 }].reduce(
  (accumulator, currentValue) => accumulator + currentValue.x
  , initialValue
);
console.log("sum : " + sum);
*/


/*
// ex6) 중첩배열 펼치기
var flattened = [[0, 1], [2, 3], [4, 5]].reduce(
  (accumulator, currentValue) => accumulator.concat(currentValue),
  []
);
console.log("flattened : " + flattened);
*/


/*
// ex7) 객체 내의 값 인스턴스 개수 세기
var names = ['Alice', 'Bob', 'Tiff', 'Bruce', 'Alice'];
var countedNames = names.reduce(function (allNames, name) {
  if (name in allNames) {
    allNames[name]++;
  } else {
    allNames[name] = 1;
  }
  return allNames;
}, {});
console.log(countedNames);
*/


/*
// ex8) 속성으로 객체 분류하기
var people = [
  { name: 'Alice', age: 21 },
  { name: 'Max', age: 20 },
  { name: 'Jane', age: 20 }
];
function groupBy(ObjectArray, property) {
  return ObjectArray.reduce(function (acc, obj) {
    var key = obj[property];
    if (!acc[key]) {
      acc[key] = [];
    }
    acc[key].push(obj);
    return acc;
  }, {});
}

var groupedPeople = groupBy(people, 'age');
console.log(groupedPeople);
*/

/*
// ex9) 확장 연산자와 초기값을 이용하여 객체로 이루어진 배열에 담긴 배열 연결하기
var friends = [{
  name: 'Anna',
  books: ['Bible', 'Harry Potter'],
  age: 21
}, {
  name: 'Bob',
  books: ['War and peace', 'Romeo and Juliet'],
  age: 26
}, {
  name: 'Alice',
  books: ['The Lord of the Rings', 'The Shining'],
  age: 18
}];

var allbooks = friends.reduce(function (accumulator, currentValue) {
  return [...accumulator, ...currentValue.books];
}, ['Alphabet']);
console.log(allbooks);
*/


// --------------------reduce 함수 예제--------------------




/*
// ex58) 맵-리듀스(map-reduce)
let ar = [1, 2, 3, 4];
let result = ar.reduce((a, b) => {
    console.log(a, b);
    return a + b;
}, 0);
console.log(result);

console.log('------------------------------');

console.log(
    [1, 2, 3, 4].reduce((a, b) => {
        console.log(a, b);
        return a + b;
    }, 0)
);

console.log('------------------------------');
console.log([1, 2, 3, 4].reduce((a, b) => a + b), 10);
*/



/*
// ex57)
// forEach : 원본 데이터를 하나씩 받아서 사용한다.
// map : 원본 데이터를 받아서 가공하고 리턴한다.
let ar = [1, 30, 39, 29, 10, 13];
let br = ar.filter((v) => {
  return v < 30;
});
console.log(br);
let word = ['tiger', 'rabbit', 'cat', 'dog', 'lion', 'turtle'];
// 4글자 이하인 단어만 뽑자
let result = word.filter((v) => {
  return v.length <= 4;
});
console.log(result);
*/



/*
// ex56) indexOf
let ar = ['tiger', 'lion', 'rabbit', 'dog', 'cat'];
console.log(ar.indexOf('rabbit')); // 2
console.log(ar.indexOf('rait')); // 없어서 -1
console.log(ar.indexOf('rabbit', 3)); // 없어서 -1
console.log(ar.lastIndexOf('rabbit')); // 끝에서부터 찾으니까 2

// every
let br = [1, 30, 39, 29, 10, 13];
let result = br.every((v) => {
  return v < 40;
});
console.log(result); // true(모두 만족하는지 물어볼때 사용)
let cr = [1, 3, 5, 7, 10];

function func(v) {
  return v % 2 === 0;
}
console.log(cr.some(func)); // true(한개만 만족하더라도 true)
*/


/*
// ex55) slice, splice
let ar = [1, 2, 3, 4, 5, 6, 7, 8, 9];
// start, end-1
let br = ar.slice(2, 6); // [ 3, 4, 5, 6 ]
console.log(ar);
console.log(br);

let cr = [10, 20, 30];
// (시작위치, 삭제할 데이터 개수)
cr.splice(1, 0, 4, 5);
console.log(cr);
let dr = [10, 20, 30, 40, 50, 60, 70];
dr.splice(2, 3, 99, 88, 77, 66);
console.log(dr);
*/



/*
// ex53) 배열에서 제공하는 함수
// 원본 데이터가 변경되는지는 항상 확인 필요.
let ar = [80, 21, 10, 15];
console.log(ar);

// 1.
let br = ar.toString();
console.log(typeof br, br);

// 2.
let date = new Date();
console.log(date); // 2022-11-24T05:46:03.203Z
console.log(date.toLocaleString()); // 2022. 11. 24. 오후 2:46:03

let cr = [new Date(), 10, 20];
console.log(cr);

let dr = cr.toLocaleString();
console.log(dr);

// 3. push* : 맨끝 (원본데이터를 건드린다는 표시 *)
let er = [10, 20, 30];
let num = er.push(40);
console.log('er : ', er, num);

// 4. pop* : 맨끝
console.log(er.pop(), er);

// 5. concat
let fr = er.concat(50);
console.log(fr);

let gr = er.concat([60, 70, 80]);
console.log(gr);

let a = [1, 2, 3];
let b = [4, 5, 6];
let c = [...a, ...b];
console.log(c);

// 6. join
let hr = ['tiger', 'lion', 'cat'];
let result = hr.join();
console.log(typeof result, result);
console.log(hr.join('-'));
console.log(hr.join('+'));
console.log(hr.join(''));

// 7. reverse*
let ir = hr.reverse();
console.log(hr);
console.log(ir);

// 8. shift*
let jr = [1, 2, 3];
console.log(jr.shift());
console.log(jr);

// 9. unshift*
jr.unshift(99);
console.log(jr);
jr.unshift(88, 77, 66, 55);
console.log(jr);
*/


/*
// ex54)
// 10. sort
let kr = [80, 21, 10, 15];
kr.sort(); // 잘못된 문장
console.log(kr);

let lr = [52, 273, 103, 32];
// sort함수는 내부데이터를 문자열로 처리한다.
// 그리고 사전순으로 정렬을 한다.
lr.sort();
console.log(lr);

lr.sort((a, b) => { // 52, 273
  // 정렬 기준을 설정한다.
  // if (a > b) {
  //   return +1;
  // } else {
  //   return -1;
  // }
  // return a > b ? +1 : -1;
  return a - b; // 순차정렬
  // return b - a; // 역순 정렬
});
console.log(lr);
// 활용
let mr = [
  { name: '한국', point: 9 },
  { name: '우루과이', point: 3 },
  { name: '독일', point: 6 },
];
mr.sort((aa, bb) => {
  return bb.point - aa.point;
});
mr.forEach((v, i) => {
  console.log(v);
})

let nr = [
  { w: 3, h: 4 }, // 가로길이, 세로길이
  { w: 2, h: 2 }, // 4
  { w: 1, h: 6 }, // 6
];
function sortRect(a, b) {
  return (a.w * a.h) - (b.w * b.h);
}
nr.sort(sortRect);
nr.forEach((v, i) => {
  console.log(v);
})
*/


/*
// ex52)
let ar = [
  { n: '호랑이1', a: 10 },
  { n: '호랑이2', a: 20 },
  { n: '호랑이3', a: 30 }
];
// 1. 기본 출력
console.log(ar);
console.log(123);

// 2. for in
for (const index in ar) {
  let obj = ar[index];
  console.log(index, obj.n, obj.a);
}

// 3. for of
let sum = 0;
for (const v of ar) {
  console.log(v.n, v.a);
  sum += v.a;
}
console.log(sum);

// 4. forEach
ar.forEach((v, i) => {
  console.log(v);
});

// 5. map
let br = ar.map((v, i) => {
  return v.n;
});

console.log(br);
*/




/*
// ex51)
let ar = [
  10,
  '호랑이',
  true,
  { a: 10, b: 20 },
  [],
  function () { },
  () => { },
  undefined
];
console.log(ar);
*/





/*
// ex50)
let ar = [10, 21, 30, 41];

let br = ar.map((num) => {
  console.log(num);
  return num * 10;
});
// 원본 데이터를 변경하지 않는다.
// map : 원본 데이터를 가공해서 새로운 데이터를 재생산해내는 목적으로 사용
console.log(ar);
console.log(br);
let cr = ar.map((n) => n * 10);
console.log(cr);

let dr = ar.map((value) => {
  if (value % 2 === 0) {
    return 'even';
  } else {
    return 'odd';
  }
});
console.log(dr);

let er = ar.map(v => v % 2 === 0 ? 'even' : 'odd');
console.log(er);
*/



/*
// ex49)
let ar = [10, 20, 30];

// 1. 기본 출력
console.log(ar);

// 2. for in
for (const index in ar) {
  console.log(index, ar[index]);
}

// 3. for of
for (const v of ar) {
  console.log(v);
}

// 4. ar.forEach(인수전달)
// ar.forEach(function(){});
ar.forEach((value, index) => {
  console.log(index, value);
});
*/



/*
// ex48) 배열
let ar = [10, 20, 30];
console.log(ar, ar.length, typeof ar, Array.isArray(ar));

// 배열 선언 4가지 방법
// 1.
let br = [10, 20, 30];
// 2.
let cr = []; // Array();
console.log(cr);
// 3.
let dr = Array(40, 50, 60);
console.log(dr, dr.length);
// 4. (주의)
let er = Array(10);
console.log(er, er.length);
*/


/*
// ex47) 객체 병합
const obj1 = {
  a: 10,
  b: 20,
  c: 88,
};
const obj2 = {
  c: 10,
  d: 20,
  c: 99,
};
// 방법1)
const obj3 = Object.assign(obj1, obj2);
console.log(obj3);

// 방법2) 전개 연산
const obj4 = { ...obj1, ...obj2 };
console.log(obj4);

//
function func(tiger) {
  console.log(tiger);
}
func({ ...obj1, ...obj2 });
*/

/*
// ex46)
const obj = {
  a: 10,
  b: 20,
};
console.log(obj);
// 생성자함수 == 클래스
console.log(20, Object.keys(obj));

let result = Object.keys(obj);
console.log(Array.isArray(result));

function ff() {
  if (Array.isArray(test)) {
    return [];
  } else {
    return [];
  }
}
let test = ff();
if (Array.isArray(test)) {
} else {
}
console.log(30, Object.keys(obj));
console.log(40, Object.values(obj));
*/

/*
// ex45)
let obj = {
  a: 10,
  b: 20,
  [c]: 30, // c는 외부에 있는 변수이다.
};
console.log(obj.d);

let obj2 = {
  a: 10,
};

obj2.b = 200;
obj2[c] = 300;
console.log(obj2);

// 활용 코드
let obj3 = {};
let nicName = "tiger";
for (let i = 0; i < 5; i++) {
  obj3[nicName + i] = i * 10;
}
console.log(obj3);
*/


/*
// ex44)
function Tiger() {
  this.a = 10;

  this.obj = {
    a: 20,
    f1: function () {
      console.log(this);
      console.log(this.a); // 20
    },
    f2: () => {
      console.log(this);
      console.log(this.a); // 10
      console.log(this.obj.a); // 20
    },
  };
}

let ins = new Tiger();
ins.obj.f1();
console.log("--------------------------------------------");
ins.obj.f2();
*/



/*
// ex43) {} 객체 생성 안의 람다함수안에서는 this가 유효하지 않다.
let obj = {
  a: 10,
  b: 20,
  f1: function () {
    console.log("call1");
    // console.log(a,b);
    console.log(1, this);
    console.log(this.a, this.b);
  },
  f2: () => {
    console.log("call2");
    console.log(2, this);
    console.log(this.a, this.b); // 안 나옴
  },
};
obj.f1();
obj.f2();
*/

/*
// ex42)
const obj = {
    a: 10,
    b: 'tiger',
};
// 1. 비구조화 할당 문법(ES6)
// const {a, b} = obj;
// console.log(1, a, b);

// 2
const {a:aa, b:bb} = obj; //이름 rename
console.log(obj.a, obj.b); //10 tiger
console.log(aa, bb);       //10 tiger
*/

/*
// ex41)
// 속성은 crud가 가능하다.
// 속성은 동적으로 사용할 수 있다.
const obj = {
    a: 10,
    b: 20,
    f1: ()=>{console.log(1);},
};
console.log(obj);

// 추가()
obj.c = 30; // 불안한 요소가 생긴다.(오타)
console.log(2, obj);

// 삭제, 제거
delete(obj.a);
console.log(3, obj);

obj.f2 = ()=>{console.log(2);};
console.log(4, obj);

delete(obj.f1);
console.log(5, obj.f1);
*/

/*
// ex40) with
let obj = {
    s: '호랑이',
    n: 10,
    b: true,
};
console.log(obj);
with(obj) {
    console.log(s, n, b);
}
*/

/*
// ex39)
// {} :
// new : instance
// let a = new class();
let obj = {
    s: '호랑이',
    n: 10,
    b: true,
};
console.log(obj);
// 방법1(범용적)
console.log(obj.s, obj.n, obj.b);
// 방법2(필요에 따라 사용)
let test = 's';
console.log(obj['s'], obj['n'], obj['b']);
console.log(obj[test], obj['n'], obj['b']);

// for in 문장
for(const key in obj) {
    console.log(typeof key);
    console.log(key, obj.key);
}
*/

//          배열     객체
//          []       {}
//          인덱스   key(속성)
// forEach   o          x
// length    o          x

/*
// ex38) eval
let str = '';
str += 'let num = 999;';
str += 'console.log(num);';
console.log(str);
// 문자열이 의미있는 코드로 변환될때 : 인코딩
// 코드가 의미없는 문자열로 변환될때 : 디코딩
eval(str);
console.log(888);
*/

// ex37) for - setTimeout()
// for(let i = 0; i < 3; i++) {
//     setTimeout(
//         () => {
//             console.log(i);
//         },
//         1000 * i
//     );
// }
// for(var i = 0; i < 3; i++) {
//     (function(ii){
//         setTimeout(
//             () => {
//                 console.log(ii);
//             },
//             1000 * ii
//         );
//     })(i);
// }
// for(var i = 0; i < 3; i++) {
//     setTimeout(
//         () => {
//             console.log(i);
//         },
//         1000
//     );
// }

// ex36) setInterval - 비동기 함수
// // 1초에 한 번씩 저 람다 함수식을 실행시켜주세요
// let id = setInterval(
//   () => {
//     console.log(1);
//   },
//   1000
// );
// // 6.5초 가 지나면 저 람다 함수식을 실행시켜주세요
// setTimeout( () => {
//     console.log('종료 일보 직전');
//     clearInterval(id);
// }, 6500);
// // 위에 두 함수는 모두 비동기 함수
// console.log(999);

// ex35) setTimeout : 비동기 함수
// console.log(1);
// // setTimeout(함수, number);
// // setTimeout( function() {}, 1);
// // setTimeout : 비동기 함수
// // 비동기 함수 : 실행 순서를 지키지 않는다
// // 동기-비동기는 쓰레드와 관련이 없다
// setTimeout(   // setTimeout이 콜백 함수를 수행하는 주체가 된다
//     () => {
//         console.log(2);
//     }, // 콜백의 사용은 코드 전달이 목적이다
//     3000
// ); // 블로킹이 되지 않은 함수
// console.log(3);
// // 처음부터 동기함수이면 상관없다
// // 서버에 아이디, 패스워드를 넘긴다
// // 동기함수로 바꾸어야 한다
//     // 동기함수
//     //  {
//     // 비동기 함수 : ok, ng 결과값을 받는다
//     // }
// //
// // 밑의 코드는 비동기 함수가 수행이 끝났다는 보장아래에서
// // 아래 코드가 성립한다
// // 만약 ok라면 로그인 처리를 한다

// ex34) 함수의 return
// let f1 = () => console.log('tiger');
// // return 값이 없음으로 undefined
// console.log(4, f1());
// let f4 = () => {
//     { console.log('tiger'); };
// }
// let f2 = () => {
//     //return 100;
// }
// let f3 = () => {
//     return f2();
// }
// console.log(5, f3());
// let f5 = () => {
// }
// let f6 = () => {
// }
// let f7 = () => {
//     return f5;      // 함수를 리턴
//     return f6();    // 함수의 리턴값을 리턴
// }

// ex33) 이중 삼중 =>
// let f1 = (a) => {
//     return (b) => {
//         return a + b;
//     };
// };
// console.log(f1(10)(20));
// // 일반 코드
// let f2 = a => b => a + b;
// console.log(f2(10)(20));
// let f3 = a => b => c => a + b + c;
// console.log(f3(1)(2)(3));
// let f4 = (a) => {
//     return (b) => {
//         return (c) => {
//             return a + b + c;
//         };
//     };
// };
// console.log(f4(4)(5)(6));

// ex32) 다양한 함수식
// // ex)32-1 일반함수
// let f1 = function(a) {
//     return a * 10;
// }
// console.log(f1(1));

// // ex)32-2 람다식
// let f2 = (a) => {
//     return a * 10;
// }
// console.log(f2(2));

// // ex)32-3 람다식 : 람다 함수의 인수전달이 1개일 때 () 생략 가능
// // 생략하는 것이 일반적
// let f3 = a => {
//     return a * 10;
// }
// console.log(f3(3));

// // ex)32-4 람다식 : return으로만 되어 있는 단문장일 때
// // {}와 return 예약어를 생략할 수 있다
// // 단 생략할 때는 둘 다 같이 생략해야 한다 (1. {}, 2. return)
// // 생략하는 것이 일반적
// let f4 = a => a * 10;
// console.log(f4(4));

// // ex)32-5 람다식 : 객체 반환 1
// let f5 = function() {
//     // return 100;
//     // return 'tiger';
//     // return function() {
//     // };
//     // let obj = {
//     //     a : 10,
//     //     b : 20,
//     // };
//     // return obj;
//     return {a:888, b:999};
// }
//     let result = f5();
//     console.log(result.a, result.b);

// // ex)32-6 람다식 : 객체 반환 2
//     // 생략을 하다보니 함수의 스코프인지 객체의 스코프인지 파악할 수 없다
//     // 객체를 return 할 때는 ()로 감싸줘야 한다
//     let f6 = () => ({a:777, b:666,});
//     result = f6();
//     console.log(result.a, result.b);

// ex31) 클로저
// const f1 = function() {
//     let a = 100;
//     console.log(1, a);
//     return function() {
//         console.log(2, a + 10);
//     };
// }; // 이 시점에서 지역변수는 무조건 죽는다
// // 자바스크립트에서 외부에서 지역변수를 사용한다고 판단을 하면
// // 변수의 생명 연장을 시킨다
// // (기간은 지역변수를 사용안한다고 판단할 때)
// // 이것을 클로저 함수라고 부른다
// const f2 = f1();
// f2(); // << 이 부분이 성립하는 것이 이상하다
// f1()();
// // 클로저
// // 외부 함수 보다 중첩 함수가 더 오래 유지되는 경우
// // 중첩함수는 이미 생명 주기가 종료한 외부 함수의 변수를 참조할 수 있다
// // 이러한 중첩함수를 클로저 라고 부른다
// // (출처 : 모던 자바스크립트 Deep Dive)

// ex30) 함수 인수 전달 - 3
// const f1 = function(num, str, callback) {
//     console.log(num + str);
//     callback();
//     return function(n1, n2, callback) {
//         callback();
//         console.log(n1 + n2);
//     }
// }
// // 함수를 인수로 넘겼고
// // 함수를 return으로 받아서
// // return으로 받은 함수에 인수를 넘겨 즉시 실행 함수로 바로 실행시켰다
// f1(10, 'tiger', function() {
//     console.log('call back');
// })(10, 20, function() {
//     console.log('2차 콜백함수');
// });

// ex29) 함수 인수 전달 - 2
// const f1 = function() {
//     console.log(1);
//     // const f2 = function() {
//     //     console.log(2);
//     // }
//     // return f2;
//     return function() {
//         console.log(3);
//     }
// }
// // 실행 방법1)
// const f3 = f1();
// f3();
// // 실행 방법2) return을 function으로 받았으니 즉시 실행 함수로 바로 실행시킨다
// f1()();

// ex28) 함수 인수 전달 - 1
// let f1 = function(cf) {
//     console.log(1);
//     cf(); // 콜백 함수
// }
// let f2 = function() {
//     console.log(2);
// }
// // 사용 방법1
// f1(f2);
// // 사용 방법2
// f1(function() {
//     console.log(3);
// });
// // 사용 방법3
// f1(() => {
//     console.log(4);
// });

// ex27) 내부 함수
// f1 함수가 다른곳에서는 사용하지 않고
// f2에서만 사용이 될 때 코드를 분리시키는 것은 옳지 않다
// 이 경우에 f1은 f2에 의존 관계를 가지는 함수이고
// 때문에 단독으로 f1이 호출되는 것은 가급적 막는 것이 좋다
// let f2 = function() {
//     console.log('파워 공급을 한다');
//     let f1 = function() {
//         console.log('전기 자동차가 달린다');
//     }
//     f1();
// }
// f2();

// ex26) arguments 가변 인수 전달
// function f1() {
//     console.log('call');
//     console.log(arguments);
//     console.log(typeof arguments);
//     console.log(arguments.length);
//     console.log('----------------------------------------');
//     for (let index in arguments) {
//         console.log(index, arguments[index]);
//     }
// }
// // f1();
// // f1(10);
// // f1(10, 20, 30);
// f1(10, 'tiger', [20, 'lion', true]);

// ex25) 함수의 형태
// function f1() {
//     console.log(1);
// }
// function f2(n) {
//     console.log(n);
// }
// function f3() {
//     return 10;
// }
// function f4(n) {
//     return n*2;
// }
// f1();
// f2(100);
// console.log(f3());
// console.log(f4(100));

// ex24) 첫 글자 대문자 = 생성자 함수 = 클래스
// function Func() {
//     // 멤버 변수 정의
//     this.num = 10;
//     // 멤버 함수 정의 1
//     this.f1 = function() {
//         console.log(1, this.num);
//     };
//     // 멤버 함수 정의 2
//     this.f2 = () => {
//         console.log(2, this.num);
//     };
// }
// let ins = new Func();
// ins.f1();
// ins.f2();
// console.log(3, ins.num);

// ex23) 즉시 실행 함수 활용
// function f1(num) {
//     console.log(1);
//     return 100 * num;
// }
// console.log(f1(2));
// // 즉시 실행 함수
// let result = (function(num) {
//     console.log(1);
//     return 100 * num;
// })(3);
// console.log(result);
// console.log(
//     (function(num, str) {
//         console.log(str);
//         return 100 * num;
//     })(4, 'tiger')
// );

// ex22) 함수 정의 3가지 방법
// // 1. 함수 호이스팅이 발생한다
// f1();
// function f1() {
//     console.log(1);
// }
// //f1();
// // 2. 함수 호이스팅이 발생하지 않는다
// const f2 = function() {
//     console.log(2);
// };
// f2();
// // 함수 람다 형식
// // 3. 함수 호이스팅이 발생하지 않는다
// // const f3 = () => {} // 기본 모양
// const f3 = () => {
//     console.log(3);
// };
// f3();

// ex21) 짧은 if문
// if( true ) {
//     console.log(999);
// }
// // 위의 코드와 동일한 코드
// true && console.log(999);
// let num = 10;
// if(num > 0) {
//     console.log(888);
// }
// num > 0 && console.log(888);
// if(!false) {
//     console.log(1);
// }
// false || console.log(2);
// if (!(num < 0)) {
//     console.log(3);
// }
// // sugar code
// // 가독성이 떨어진다 ?
// num < 0 || console.log(4);
// (num > 0) && console.log(888);
// (num < 0) || console.log(4);

// ex20) ===
// console.log(1, 10 == 10);
// // 값이 같은가?
// console.log(1, 10 == '10');
// // 값과 타입이 같은가?
// console.log(1, 10 === '10');

// ex19) 즉시 실행 함수 - 2
// // Thread.sleep(3000); // blocking
// console.log('시간 지연 시작');
// (function(ms) {
//     let start = new Date().getTime();
//     while(new Date().getTime() < start + ms);
// })(3000);
// // 코드가 중간에 끼어들지 않는다는 전제에서
// console.log('시간 지연 종료');

// ex18) 즉시 실행 함수 - 1
// console.log('start');
// (function() {
//     console.log(100);
// })();
// console.log('end');
// function f2(num) {
//     console.log(num);
// }
// f2(100);
// // 파라미터를 받는 즉시 실행 함수
// (function(n) {
//     console.log(n + 100);
// })(100);

// ex17) 자바스크립트 객체 바로 사용
// let d = new Date();
// console.log(d.getTime());
// let start = new Date().getTime();
// // console.log(start);
// let count = 0;
// for(var i = 0; new Date().getTime() < start + 1000; i++) {
//     count++;
// }
// let end = new Date().getTime();
// console.log(end - start);
// console.log('ex17-1', i);
// console.log('ex17-2', count);
// // 정렬 알고리즘1 (선택 정렬)
// // 정렬 알고리즘1 (버블 정렬)
// // 정렬 알고리즘1 (퀵 정렬)

// ex16) 생성자 함수 - Date();
// // 자바
// // Date date = new Date();
// // js
// let d = new Date();
// console.log(d.getFullYear(), '년');
// console.log(d.getMonth()+1, '월');
// console.log(d.getDate(), '일');
// console.log(d.getDay(), '요일'); // 0(일요일)부터 시작
// console.log(d.getHours(), '시');
// console.log(d.getMinutes(), '분');
// console.log(d.getSeconds(), '초');
// // 당연히 객체 타입인 줄 알았는데
// // 결과가 function
// console.log(typeof Date);
// // 일반 함수
// function f1() {
//     console.log('f1 call');
// }
// f1();
// // 첫글자가 대문자로 출발하는 함수는
// // 생성자 함수라 부르고
// // 생성자 함수는 클래스 문법을 가진다
// function F2() {
//     // 생성자
//     // 멤버 변수
//     // 멤버 함수
// }
// F2();
// let apple = new F2();
// console.log(typeof F2);
// // 결과가 object
// console.log(typeof d);

// ex15) 자바스크립트 비트 표현
// let a = 10;              // 10진법 표기
// let b = 0x10;            // 16진법 표기
// let c = 0o10;            //  8진법 표기
// let d = 0b1111011;       //  2진법 표기
// console.log(a, b, c, d);

// ex14) 자바스크립트 연산식
// // 산술 연산, 관계 연산, 논리 연산 동일
// // ++, -- 동일
// // +=, -=  복합 대입 연산자 동일
// // true(1), false(0)
// // 4대 제어문 동일
// // 삼항 연산 동일
// // 자바와 다르다
// // 몫과 나머지를 구한다
// console.log(17 / 3, 17 % 3);
// console.log(parseInt(17 / 3), 17 % 3);
// // 거듭제곱 동일한 코드
// console.log(Math.pow(2, 3));
// console.log(2 ** 3);
// console.log(2 ** 3 ** 2);
// console.log(2 ** (3 ** 2));

// ex13) 문자열 >> 숫자, 숫자 >> 문자열
// let s = '100';
// let n = 200;
// // 문자열 >> 숫자.
// console.log(Number(s) + 100);
// // 숫자 >> 문자열.
// console.log(String(n) + 100);
// console.log(typeof Number(s));
// console.log(typeof String(n));
// // 문자열을 숫자로 치환할 때 Number가 일반적인데
// // 이것 대신에 parseInt를 사용할 때의 예제
// let n1 = '300원';
// let n2 = '300원';
// console.log(Number(n1)); // NaN
// console.log(parseInt(n2)); // 숫자만 가지고옴
// let n3 = 400;
// let s1 = String(n3);
// let s2 = '' + n3; // sugar code
// console.log('ex13-1)', typeof s1);
// console.log('ex13-2)', typeof s2);
// let s3 = '500';
// let n4 = Number(s3);
// let n5 = +s3; // sugar code
// console.log('ex13-3)', typeof n4);
// console.log('ex13-4)', typeof n5);
// let n6 = +'500';
// console.log('ex13-5)', typeof n6);

// ex12) +=
// let str = '호랑이' + '\n';
// str += '독수리';
// console.log(str);
// // for() { str += '';}

// ex11) const 정의
// const a = 10;
// console.log(a);
// // exception 발생
// // a = 20;
// let b = function() {
//     console.log(1);
// }
// b();
// b = function() {
//     console.log(2);
// }
// b();
// const c = function() {
//     console.log(3);
// }
// c();
// exception 발생
// c = function() {
//     console.log(4);
// }
// c();

// ex10) undefined, null
// let a = undefined;
// let b = null;
// // a는 타입이 정해지지 않았다
// console.log(typeof a);
// // b는 오브젝트 타입
// // 참조(공유)하는 값이 없다
// console.log(typeof b);

// ex9) var, let 지역성
// // 지역성을 유지했다
// {
//     let a = 10
//     console.log(a);
// }
// console.log("**********************************");
// //console.log(a);
// // 지역성을 유지하지 않는다
// {
//     var b = 20;
//     console.log(b);
// }
// console.log(b);
// // a를 유지하지 못한다
// for(let a = 0; a < 5; a++) {
// }
// // a를 유지한다
// for(var a = 0; a < 5; a++) {
// }
// var c = 30;
// {
//     // 이전에 c가 사라졌다
//     var c = 40;
//     console.log('ex9-1', c);
// }
// console.log('ex9-2', c);
// let d = 50;
// {
//     let d = 60;
//     console.log('ex9-3', d);
// }
// console.log('ex9-4', d);

// ex8) 동적 타입 변경
// let a =  100;
// console.log(typeof a, a);
// // 동적 타입 변경 // delete a; a = new('tiger');
// a =  'tiger';
// console.log(typeof a, a);
// let b = 200;
// console.log(typeof b, b);;
// var c = 300;
// console.log(typeof c, c);;
// var c = 'tiger';
// console.log(typeof c, c);;

// ex7) 중첩 객체
// let obj = {
//     a : {
//         b : {
//             c : {
//                 d : {
//                     d : 100
//                 }
//             }
//         }
//     }
// }
// console.log(obj);
// console.log(obj.a.b.c.d);
// console.log('end');

// ex6) javascript 객체
// // JSON 데이터 저장형식과 아주 흡사
// let apple  = {
//     a : 10, // json과 달리 key에 ""생략 가능
//     b : 'tiger',
//     c : true,
//     d : [],
//     e : {}, // 중첩 객체가 가능
//     f : function() {
//         console.log('function call');
//     },
//     g : undefined, // 맨 마지막에 ,로 끝낼 수 있다
//     h : {i:[], j:{}, k:[{}, {}] },
// };
// console.log(apple.a);
// apple.f();

// ex5) 값 타입 (typeof)
// // 값타입에 따른 변수 생성 방법
// let a = 10;
// let b = 'tiger';
// let c = true; // true, false값을 가질 수 있다
// let d = []; // 배열
// // 객체 {} != 클래스로 만들어 지는 객체(인스턴스라고 표현)
// let e = {}; // 객체
// // 함수 생성 방법1
// function apple() {
// }
// // 함수 생성 방법2
// let f = function() {
// };
// // undefined는 어떤 타입으로도 정의되지 않는 타입 (null과 다르다)
// let g = undefined;
// let h = 3.14;
// console.log(typeof a);
// console.log(typeof b);
// console.log(typeof c);
// console.log(typeof d); // object
// console.log(typeof e); // object
// console.log(typeof f); // function
// console.log(typeof g); // undefined
// console.log(typeof h); // number

// ex4) 자바스크립트 타입
// // 현대 타입
// var : 거의 var는 사라지고 let으로 버전업, 특별한 용도로만 사용
// let : 범용 타입
// const : 일반적
// js는 java에 대해서 상당히 약식이다
// var a = 10;
// let b = 20;
// const c = 30; // const는 값을 상수화
// console.log(a, b, c);

// ex3) 버전업으로 인해 설정된 파일이 실행됨
// console.log(100);

// ex2) 디버깅
// console.log(1);
// console.log(2);
// console.log(3);
// console.log(4);
// console.log(5);
// console.log(6);

// ex1) 콘솔 출력
// console.log(100);
// console.log("호랑이");
// console.log('호랑이'); // 일반적으로 자바스크립트에서는 문자열 ''를 권장
