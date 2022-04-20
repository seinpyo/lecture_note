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

///////////////////////

console.log('path.format() : ', path.format({
    dir: 'C:\Users\SEIN\git\lecture_note\Node.js',
    name: 'javascript_ex1',
    ext: '.js'
}))
//제공된 파일의 경로와 이름, 확장자를 조합함

console.log('path.nomalize() : ', path.normalize('C:\/Users\SEIN\//\git\lecture_note\Node.js')) 
//파일 경로 오류를 수정

console.log('path.isAbsolue(C:\\) : ', path.isAbsolute('C:\\'))
console.log('path.isAbsolue(./home) : ', path.isAbsolute('./home'))
//파일의 경로가 절대경로인지 상대경로인지 boolean으로 리턴

console.log('path.join() : ', path.join(__dirname, '..', '/sein', '.', '/node_js'))
//입력된 파라미터들을 조합하여 이동 (해당 경로가 존재하지 않더라도 조합된 경로 이름이 결과로 나옴)
// '/'를 상대경로로 취급

console.log('path.resolve() : ', path.resolve(__dirname, '..', '/sein', '.', '/node_js'))
//resolve와 join은 비슷하지만 '/'표시를 절대 경로로 취급
// '/sein'에 의해 C:\sein 이 되었다가 '/node_js'를 만나서
// C:\node_js로 설정됨




//node 04_Path.js