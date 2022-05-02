const value = require('./Var')
//현재폴더의 Var 파일 안에 있는 모듈을 require

console.log(value)

//구조분해
const odd = value.odd
const even = value.even

console.log(odd)
console.log(even)