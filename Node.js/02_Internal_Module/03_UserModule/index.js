const { odd, even } = require('./Var')
const checkNumber = require('./Func03')

let number = Math.floor(Math.random()*100 + 1) 
const result = checkNumber(number)
console.log(`${number}는 ${result}`)
