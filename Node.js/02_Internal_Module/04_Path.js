const path = require('path')

//path를 require하지 않아도 사용가능한 
//경로와 파일 관련 상수 
// console.log('__filename : ', __filename) //현재 파일 이름
// console.log('__dirnane : ', __dirname)  //현재 파일의 경로 
// console.log()

console.log('--------------')
console.log('path.sep : ', path.sep) //폴더 구분 문자
console.log('path.delimiter : ', path.delimiter) 
//환경변수 내에서 서로 다른 경로를 같이 나타낼 때 구분해주는 구분 문자

console.log()
console.log('--------------')

string = __filename
console.log('path.dirname() : ', path.dirname(string)) //파일의 폴더 경로
console.log('path.extname() : ', path.extname(string))//파일의 확장자
console.log('path.basename() : ', path.basename(string)) //파일이름+확장자
console.log('path.basename(extame제외) : ', path.basename(string, path.extname(string))) //확장자를 제외한 파일 이름만 출력

console.log()
console.log('--------------')

console.log('path.parse() : ', path.parse(string))
//파일 경로를 root, dir, base, ext, name으로 분리
console.log()
console.log()


//node 04_Path.js