
function add1(x,y) {
    return x+y
}
console.log( 'add1 : ' + add1(10, 20) )

let add2 = function(x,y) {
    return x+y
}
console.log( 'add2 : ' + add2(10, 20) )

function not1(x) {
    return !x
}
console.log('not1 : ' + not1(true))


//#1
const add3 = (x,y) => {
    return x+y
}
console.log( 'add3 : ' + add3(10, 20) )

//#2
const add4 = (x,y) => x+y
console.log( 'add4 : ' + add4(10, 20) )

//#3
const add5 = (x,y) => (x+y)
console.log( 'add5 : ' + add5(10, 20) )

//#4
const not2 = x => !x
console.log( 'not2 : ' + not2(true))



//매개변수, 리턴값
const func1 = () => {
    console.log('func1 매개변수, 리턴 값이 없는 함수')
}

const func2 = (x,y) => {
    console.log(`func2 매개변수(${x}, ${y})가 있고 리턴값이 없는 함수`)
}

const func3 = (x,y) => {
    console.log(`func3 매개변수(${x}, ${y})가 있고 리턴값이 있는 함수`)
    return (x+y)
}

const func4 = () => {
    console.log(`func4 매개변수가 없고 리턴값이 있는 함수`)
    return 100;
}

//매개변수와 상관없이 단순 리턴 값만 있는 함수 ({ }가 없는 함수)
const func5 = (x,y) => x+y

func1()
func2(10, 20)
func3(10, 20)
console.log('func3 리턴 값 : ' + func3(10,20))
console.log('func4 리턴 값 : ' + func4())
console.log('func5 리턴 값 : ' + func5(10, 20))



//node 06_ArrowFunction.js