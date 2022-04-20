
const string = 'abc'
const number = 1
const boolean = true
const obj = {
    outside:{
        inside: {
            key: 'value'
        },
    },
}

console.log('쉼표로 구분해 여러 값을 찍을 수 있습니다.')
console.log(string, number, boolean)
console.log()

console.error('에러 메시지는 console.error에 담습니다.')
console.log()

console.table([{name:'zero', birth:1994}, {name: 'hero', birth: 1988}])
console.log()

console.log('console.dir 객체 내의 또 다른 객체 등을 표현할 때 사용합니다.')
console.dir(obj, {color: true, depth: 2})
console.dir(obj, {color: true, depth: 1})
console.log()

console.log('cosole.time() ~ console.timeEnd() 까지 걸린 시간을 측정합니다')
console.time('시간 측정')
for(let i=0; i<100000; i++) {} 
console.timeEnd('시간 측정') //time과 timeEnd의 문자열은 같아야함
console.log()

function b() {
    console.trace('에러 위치 추적')
} 
function a(){ b() } 

a()

//node 01_Console