const { resolve } = require('path');


const condition = false;
const promise1 = new Promise((resolve, reject) => {
    if(condition) resolve('success')
    else reject('fail')
})

async function abcd(){
    try{
        const result = await promise1 
        //reslove에서 전달한 값을 result에 전달
        console.log('condition :' ,condition, '1. ' + result)
    } catch(error) {
        console.error('condition :' ,condition, ' 2. ' + error)
    }
}

abcd()


const promise = new Promise((resolve, reject) => {
    resolve('1st resolve')
})

async function func1() {
    try{
        const result = await promise
        console.log('await :', result)
        return '2nd resolve' //promise 객체 안에서 resolve 호출
    } catch {
        console.error(err)
    }
}

func1()
.then ((result2) => {console.log(result2)})
.catch((error)=> {console.error(error)})


//node 09_anotherPromise.js