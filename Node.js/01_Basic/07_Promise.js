// let condition = false;

// const pm = new Promise((resolve, reject)=>{
//     if(condition) {
//         resolve('성공')
//     } else {
//         reject('실패')
//     }
// })

// pm  
//     .then ((message) => {
//     console.log(message) //성공(resolve)한 경우 실행
// }) .catch( (error)=>{
//     console.error(error) //실패(reject)한 경우 실행
// }) .finally( ()=>{
//     console.log('무조건 실행') //성공, 실패 중 하나와 함께 반드시 실행
// })


//promise를 사용하지 않을 떄 ( 동기식으로 무언가를 실핼 => 비동기 명령 삽입)
// const printString = (string, callback) => {
//     let k = Math.floor(Math.random()* 10000 +1) //0~9초 사이에 랜덤한 시간 계산
//     setTimeout( ()=> {
//         console.log(string + ' ' +k)
//     }, k)
//     callback() 
// }

// printString('A', ()=>{printString("B", ()=>{})})
//string에 a를 넣고 pringString 실행 + b를 넣고 실행
// a와 b 중 누가 먼저 나올지 모름



//동기 실행

// console.log('작업시작')
// console.log('오래걸리는 작업1')
// const wakeUpTime = Date.now() + 3000; //실행 시간 +3초를 변수에 저장
// while(Date.now() < wakeUpTime) {
//     //현재시간을 wakeUpTime과 비교해 반복실행
// }
// console.log('작업2 : 오래걸리는 작업의 다음 작업')
// console.log('작업1, 작업2 순서에 맞춰 작업 끝')


//비동기 실행
// function longRunningTask() {
//     console.log('작업1 끝')
// } 
// console.log('시작')
// console.log('작업1 : 오래걸리는 작업 시작')
// setTimeout(longRunningTask, 3000)
// console.log('작업2 : 오래 걸리는 작업의 다음 작업 시작')
// console.log('작업2 끝')


// console.log('시작')
// let longRunningTask = new Promise((resolve, reject) =>{
//     console.log('작업 1 시작')
//     setTimeout( () => { console.log('작업1 종료 ') }, 3000 )
//     resolve()
// })

// longRunningTask
//     .then(()=> { console.log("작업2 시작")})
// console.log('작업2 종료')

//리턴 값을 promise로 활용
// const pringString = (string) => {
//     return new Promise((resolve, reject) => {
//         let k = Math.floor(Math.random() * 10000 + 1)
//         console.log('동기 실행 시작')
//         setTimeout(()=>{
//             console.log(string + ' ' + k);
//         }, k)
//         resolve(); //setTimeout의 실행 여부와 관계없이 printString("A").then()으로 이동
//     })
//     console.log(string)
// }

// pringString("A")
//     .then(()=> { console.log('동기 실행 종료')
//     pringString('B')
// })
//     .then( () => { console.log('동기 실행 종료2')} )



// let number = Math.floor(Math.random()*100 + 1) 
// const evenNumber = new Promise((resolve, reject) => {
//     console.log(number + '은/는 ')
//     if(number%2 == 0) {
//         resolve('짝수입니다.');
//     } else {
//         reject('홀수입니다.')
//     }
// })

// evenNumber
//     .then((message)=>{
//         console.log(message)
//     })
//     .catch((error)=>{
//         console.log(error)
//     })


const pm1 = new Promise((resolve, reject) => {
    resolve("first resolve")
})

pm1
    .then((msg1) => { 
        console.log(msg1) 
        return new Promise((resolve, reject)=> {
            resolve('second resolve')
        })
    })

    .then((msg2) => {
        console.log(msg2)
        return new Promise((resolve, reject)=> {
            resolve('third resolve')
        })
    })

    .then((msg3) => {
        console.log(msg3)
    })







//node 07_Promise.js