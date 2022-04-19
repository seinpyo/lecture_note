
console.log('10초후 타이머를 종료합니다')
//지정된 시간 후 한 번 실행
const timeout = setTimeout( ()=> {console.log('1.5초 후 실행')}, 1500)

//지정된 시간마다 반복 실행
const interval = setInterval(()=> {console.log('2초마다 실행')}, 2000)

//타이머 종료
const timeroff = setTimeout(()=> {
    console.log('타이머를 종료합니다')
    clearTimeout(timeout)
    clearInterval(interval)
}, 10000)
// clearTimeout(timeout)
// clearInterval(interval)

const immediate = setImmediate(()=>{console.log('즉시 실행')})
clearImmediate(immediate)

//node 02_Timer.js