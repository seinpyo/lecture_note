let fs = require('fs')

fs.writeFile('./writeMe2.txt', 'Hello Nice to meet you', (err)=>{ if(err) {throw err}}
)

fs = require('fs').promises

fs.readFile('./writeMe2.txt')
.then((data) => {
    console.log(data.toString())
})
.catch((err) => {
    console.error(err)
})

console.log('fs 모듈을 이용한 파일 입출력')



//09_wirteAndRead.js