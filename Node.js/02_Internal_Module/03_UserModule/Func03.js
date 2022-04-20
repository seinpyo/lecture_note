const {odd, even} = require('./var');
//구조분해 할당으로 변수 초기화 

function checkOddorEven(number){
    if(number % 2) return odd
    else return even
}

module.exports = checkOddorEven
