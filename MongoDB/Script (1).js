db.people.drop();


// id : 게시판 종류
// title : 글제목
// content : 글 내용
// author : 작성자
// insert
info = db.people.insert( {id:'자유게시판', title:'가입합니다', content:'안녕하세요', author:'호랑이', } );

// insertMany
db.people.insertMany([ 
 {id:'자유게시판', title:'가입합니다2', content:'안녕하세요2', author:'코끼리', },
 {id:'자유게시판', title:'가입합니다3', content:'안녕하세요3', author:'독수리', },
]);

// 호랑이를 못찾을 경우 무시됨
db.people.updateOne({author:'호랑이'},{$set:{comment : '어서오세요'}});-

db.people.updateOne({author:'코끼리'},{$set:{comment : {author:'앵무새', content:'어서오세요'} }});

db.people.updateOne({author:'독수리'},{$set:{comment : [{author:'앵무새', content:'어서오세요'},
    {author:'사자', content:'어서오세요'}
    ] }});


db.people.find({}).toArray();








//db.people.drop();
//
//data = [
//    {name:'호랑이3', age:90, sal:100},
//    {name:'호랑이2', age:20, sal:200},
//    {name:'호랑이3', age:30, sal:300},
//    {name:'호랑이2', age:40, sal:200},
//    {name:'호랑이3', age:50, sal:300}
//];
//
//db.people.insertMany(data);





// ------------------------------------------------------------------------------------------------

// like 예제데이터
//data = [
//    {name : '일길동', age : 99, salary : 100},
//    {name : '이길서', age : 20, salary : 200},
//    {name : '이동남', age : 30, salary : 300},
//    {name : '동길북', age : 40, salary : 200},
//    {name : '삼길동', age : 50, salary : 300}
//]

// like
// 일로 시작하는 모든 것
db.people.find({name : /^일/});

// 동으로 끝나는 모든 것
db.people.find( {name : /동$/} );

// '동'이 포함된 모든 것
db.people.find( {name : /동/} );

// exists
db.people.find( 
    {name : {$exists : true}}    
);

// not
db.people.find( 
    {age:{$gte:50}}    
);

db.people.find( 
    {age:{$not:{$gte:50}}}    
);

// mod (4의 배수)
// 4로 나누었을 때 나머지가 0인 것 [4,0]
// 4로 나누었을 때 나머지가 3인 것 [4,3]
db.people.find({age:{$mod:[4,0]}});

// document안에서 배열을 사용
// 배열 추가
// push는 
// 필드가 존재할 때 => 기존 필드에 데이터 추가 
// 존재하지 않을 때를 구분 => 필드 생성 및 추가
db.people.updateOne( {name:'호랑이2'}, {$push:{item:10000}} );

// 1개 이상의 데이터를 넣고 싶을 경우
db.people.updateOne( {name:'호랑이2'}, {$push:{item:[10000, 20000, 30000]}} );
// 위에 처럼 하면 배열안에 배열이 들어간다

// each를 이용하여 1개 이상의 데이터를 배열로 넣을 수 있다
db.people.updateOne( {name:'호랑이2'}, {$push:{item:{$each:[66,77,88]} }} );

db.people.updateOne( {name:'호랑이2'}, {$push: {item:{$each:[10,20,30]}} });

// 배열을 넣을 위치도 지정할 수 있다
db.people.updateOne( {name:'호랑이2'}, {$push:{item: {$each:[50,60,70,60], $position:2 }} } );

// +1(끝, 맨 앞에 제거), -1(앞, 맨 뒤에 제거)
db.people.updateOne({name:'호랑이2'}, {$pop:{item:-1}});

// 1개의 데이터를 검색해서 삭제 - 중복된 데이터도 모두 삭제
db.people.updateOne({name:'호랑이2'}, {$pull:{item:60}} );

// 1개 이상의 데이터를 검색해서 삭제
db.people.updateOne({name:'호랑이2'}, {$pullAll:{item:[22,50,70]}} );

// addToSet
db.people.updateOne({name:'호랑이2'}, {$addToSet:{item:90}} );
// find로 조회했기 때문에
// 데이터가 갱신되지 않는다
// db.people.find({name:'호랑이2'}, {item:{$slice:[2,6] }});

// slice
// slice < sort가 우선
db.people.updateOne({name : '호랑이2'}, {$push:{item:{$each:[], $slice:3}}});

// 필드 안에 있는 객체에 필드를 기준으로 정렬
db.people.updateOne({name: '호랑이2'}, {$push:{age:{$each:[], $sort:{score:1}} }});




db.people.find( {} );
// 2022.11.29------------------------------------------------------------------------------------------





//// in
//db.people.find(
//    {sal:{$in:[200, 300, 500]}}
//);
//// nin(not in)
//db.people.find(
//    {sal:{$nin:[200, 300]}}
//);









// A and (B or C)
//find(
//    A,
//    $or:[{B}, {C}]
//);




// and : 15 < x < 45
// 호랑이3을 검색하고 나이가 40이상인 문서를 조회하시오.
//db.people.find(
//    {$and:[ {name:'호랑이3'} , {age:{$gt:40}} ]}
//);




// and : 15 < x < 45 이렇게 쓰면 안된다.
// 이렇게 쓰면 조건이 and 가 아니라 덮어씌어진다.(45보다 작은것 모두 나옴)
//db.people.find(
//    {
//        age:{$gt:15}, // 이름을 찾고 and
//        age:{$lt:45}  // 나이가 ...이상
//    }
//);



//호랑이3을 검색하고 나이가 40이상인 문서를 조회하시오.
//db.people.find(
//    {
//        name:'호랑이3',
//        age:{$gt:40}
//    }
//);




//db.people.find({age:{$gt:35}});
//db.people.find({age:{$eq:30}});
////15 < x < 45
//db.people.find(
//    {age:{$gt:15, $lt:45}}, 
//    {_id: false, name:1, age:1}
//);




// 
// == : {$eq:인수}
// != : {$ne:인수}
// >  : {$gt:인수}
// <  : {$lt:인수}
// >= : {$gte:인수}
// <= : {$lte:인수}





//{$min:인수}
//db.people.updateOne(
//    {name:'호랑이2'}, // where
//    {$min:{age:25}}, // 기존 값과 주어진 값 중 최소값으로 변경(기존값이 더 작으면 변경x)
//);




//{$rename:인수}
//db.people.insertMany(data);
//db.people.updateOne(
//    {name:'호랑이2'}, // where
//    {$rename:{age:'newage'}}, // field명 변경
//);




//{$setOnInsert:인수}
// 찾은 경우 : 무시
// 못찾은 경우 : 추가
//db.people.insertMany(data);
//db.people.updateOne(
//    {name:'호랑이4'}, // where
//    {$setOnInsert:{ageage:999}},
//    {upsert: true}
//);





//{$unset:인수}
//db.people.insertMany(data);
//db.people.updateOne(
//    {name:'호랑이2'}, // where
//    {$unset:{age:''}} //field 삭제(호랑이2의 age 삭제)
//);




////{$inc:인수}
//db.people.insertMany(data);
//db.people.updateOne(
//    {name:'호랑이2'}, // where
//    {$inc:{age:1, sal:10}} //age 1 증가, sal 10 증가시킴
//);





//{$set:인수}
//db.people.insertMany(data);
//db.people.updateOne(
//    {name:'호랑이4'}, // where // data가 없을 경우에는 update가 일어나지 않는다.
//    {$set:{age:200}}, // set
//    {upsert:true}    // 디폴트(false) // true면 data가 없을 경우에 data를 추가한다.
//);




//db.people.update(
//    <query>,     //조건
//    <update>,    //함수
//    {upsert:true/false}
//};






//searchFind = db.people.findOne({name:'호랑이2'});
//
//searchFind;
//searchFind.info = {
//    age:searchFind.age, 
//    salary:searchFind.sal
//};
//searchFind;
//
//delete searchFind.age;
//delete searchFind.sal;
//searchFind;
//
//
//db.people.replaceOne({name:'호랑이2'}, searchFind);
//db.people.find({});




//db.people.find({}, {_id:false});


//db.people.insertMany([
//    {name:'호랑이1', age:30, sal:100},
//    {name:'호랑이2', age:40, sal:200},
//    {name:'호랑이3', age:50, sal:300}
//]);
//
//db.people.insertMany(data);
//
//db.people.find({}, {_id:false});
//
//
//
//
//db.people.insertOne({name:'호랑이1', age:10, sal:100});
//db.people.insertOne({name:'호랑이2', age:20, sal:200});
//db.people.insertOne({name:'호랑이3', age:30, sal:300});
//db.people.insertOne({name:'호랑이4', age:10, sal:400});



// db.getCollection("people").find({})

// f6 : 한줄 실행
// f5 : 전체 실행
// f9 : 블록 실행
db.people.insertOne({name : '호랑이4'});
db.people.find({});


// RDBMS : select
// Mongo : updateOne가 주가 된다.


db.people.drop();

// insert
db.people.insertOne({name : '호랑이1', age: 10, salary: 3000});
db.people.insertOne({name : '호랑이2', age: 20, salary: 4000});
db.people.insertOne({name : '호랑이3', age: 30, salary: 5000});
db.people.insertOne({name : '호랑이2', age: 40, salary: 6000});


// update
// 인수는 정수, 문자열, 객체
// {$함수이름: 인수 }
db.people.updateOne( {name: '호랑이1'}, {$set:{ageage:99}} );
db.people.updateMany( {name: '호랑이2'}, {$set:{age:99}} );


// replace : 해당 데이터 전부 날리고 새로운 ageage 필드 추가
db.people.replaceOne(
    {name: '호랑이1'},
    {ageage: 99}
);


// delete
db.people.deleteOne({ name: '호랑이2'});
db.people.deleteMany({ name: '호랑이2'});

// remove
// 빈 객체를 하나는 무조건 넣어줘야함
db.people.remove( {} );


// find
// db.people.find(쿼리(필터)조건, 필드선택, 옵션);
//db.people.find({}, {_id: false, salary: false});
db.people.find( {}, {_id: false} );