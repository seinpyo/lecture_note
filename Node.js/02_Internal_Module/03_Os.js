const os = require('os');
//os 모듈의 기능을 담고 있는 객체를 불러옴

console.log('운영체제 정보 ---------------------')
console.log('os.arch() : ' + os.arch()) //os 설계/운영방식
console.log('os.platform() : ' + os.platform()) //os기반 플랫폼
console.log('os.type() : ' + os.type()) //os 종류
console.log('os.uptime() : ' + os.uptime()) //부팅후 흐른 시간
console.log('os.hostname() : ' + os.hostname()) //컴퓨터 이름
console.log('os.release() : ' + os.release()) //os 버전

console.log('경로-----------------------------------')
console.log('os.homedir() : ', os.homedir()) //홈디렉토리
console.log('os.tmpdir() : ', os.tmpdir()) //임시 디렉토리

console.log('cpu 정보-----------------------------------')
console.log('os.cpus() : ', os.cpus()) //cpu정보
console.log('os.cpus().length : ', os.cpus().length) //cpu 코어 갯수

console.log('메모리 정보 ----------------------')
console.log('os.freemem() : ', os.freemem()); //사용가능한 메모리
console.log('os.totalmem() : ', os.totalmem()); //전체 메모리





//node 03_Os.js