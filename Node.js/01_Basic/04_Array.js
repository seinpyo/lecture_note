
// let array = [273, 'string', true, function(){}, {}, [150, 170]]
// console.log(array[0])
// console.log(array[1])
// console.log(array[2])
// console.log(array[3])
// console.log(array[4])
// console.log(array[5])
// console.log(array)

// let arr = ['a', 'b', 'c']
// console.log('변경전 : ' + arr)

// arr.push('d') //배열 끝에 요소를 추가
// console.log('push 후 : ' + arr)

// arr.unshift('A') //배열의 맨 앞에 요소 추가 
// console.log('unshift 후 : ' + arr)

// arr.splice(2, 0, 'B') //index 2의 위치에 요소 추가
// console.log('splice 후 : ' + arr)
// console.log()

// arr = ['a', 'b', 'c', 'd']
// console.log('arr 초기화 : ' + arr)
// arr.splice(2, 0, 'C', 'D') //index 2 위치에 2개 요소 추가
// console.log('splice 후 : ' + arr)
// console.log()

// let shifted = arr.shift(); //배열의 첫번째 요소 제거 + 제거한 요소를 반환
// console.log('shift 후 : ' + arr)
// console.log('배열의 첫번째 요소를 반환 받은 shifted : ' + shifted)


// console.log()

// arr = ['a','b', 'c', 'd', 'e', 'f']
// console.log('arr 초기화 : ' + arr)

// arr.splice(2,1);
// console.log('index 2부터 1개 요소 제거 후 : ' + arr)

// arr.splice(1,2)
// console.log('index 1부터 2개 요소 제거 후 : ' + arr)

// delete arr[1]; //delete는 값만 삭제하고 자리는 제거하지 않는다
// console.log('delete로 arr[1] 삭제 : ' + arr)

// function student(name, korean, math, english, science) {
//         this.name = name;
//         this.korean = korean;
//         this.math = math;
//         this.english = english;
//         this.science = science;

//         this.getSum = function(){
//             return this.korean+this.math+this.english+this.science
//         }
//         this.getAvg = function(){
//             return this.getSum() / 4;
//         }
//         this.toString= function(){
//             return this.name + '  총점 :' + this.getSum() + ',  평균 : ' + this.getAvg()
//         }
// }

// let students = [];

// students.push(new student('홍길동', 80,90,83,95))
// students.push(new student('홍길서', 56,74,62,68))
// students.push(new student('홍길남', 53,77,52,67))
// students.push(new student('홍길북', 79,98,76,58))
// students.push(new student('이길동', 98,97,98,100))
// students.push(new student('김길서', 81,96,89,88))

// for(let i in students) {
//     console.log(students[i].toString());
// }
// console.log()


let sayNode = function() {
    console.log('Node')
}
let myName = 'NodeJS'

let oldObject = {
    // myName : myName, 
    // key : value => key이름 myName : 변수 myName
    // 위처럼 key와 변수의 이름이 같다면 아래와 같이 작성 가능
    myName,
    sayNode, //변수가 가진 값이 함수여도 동일하게 적용 가능
    SayJS : function(){
        console.log('JS')
    },
    
}

// console.log(oldObject.myName)
// oldObject.sayNode()
// oldObject.SayJS()

// let es = 'ES';
// oldObject[es + '6']  = 'Fantastic';
// //ES6 이라는 멤버변수 생성 => 문자열 연산에 의한 변수 이름을 조합

// // console.log(oldObject.ES6)

// const newObject = {
//     myName,
//     sayJS() {console.log('JS')},
//     sayNode,
//     [es+6] : 'Fantastic'
// }
// // console.log(newObject.myName)
// // newObject.sayNode()
// // newObject.sayJS()
// // console.log(newObject.ES6)

// const sayJ = newObject.sayJS
// sayJ()
// const sayN = newObject.sayNode
// sayN()

// let es6 = newObject.ES6;
// console.log(newObject.ES6)
// console.log(es6)


const candyMachine = {
    status : {
        name: 'node', count: 5
    },
    getCandy() {
        this.status.count--;
        return this.status.count
    }
}
console.log(candyMachine.getCandy())
let count = candyMachine.status.count;

console.log(count)

let arry1 = ['nodejs', {}, 10, true]
let node1 = array1[0]
let obj3 = array1[1]
let bool1 = arry1[3]
console.log(node1, obj3, bool1)

const array2 = ['nodejs', {}, 20, false];
const [node2, obj2, bool2] = array1
console.log(node2, obj2, bool2)





//node 04_Array.js