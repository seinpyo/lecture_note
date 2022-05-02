
//파일 입출력을 위한 모듈에 promise를 포함하여 로딩
const fs = require('fs').promises

//파일 읽기를 에러처리를 위한 함수 없이 실행

fs.readFile('./readMe.txt')
.then((data)=>{
    console.log(data.toString())
})
.catch((err)=> {
    console.error(err);
})

console.log('promise로 파일을 읽어왔습니다.')








//node 07_readFilePromise.js