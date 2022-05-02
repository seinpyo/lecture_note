const fs = require('fs')

fs.readFile('./readMe.txt', (err, data)=>{
    if(err) throw err; //에러 발생시 처리할 내용
    console.log('data : ', data) //16진수로 읽어옴
    console.log('data.toString() : ', data.toString())
})






//node 06_readFile.js