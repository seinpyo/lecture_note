let a =''
// let a  = 'http://www.naver.com'
// console.log('a.match(/.+:/g) :', a.match(/.+:/g))
// // \n이 아닌 모든 글자가 1회이상 반복 + :로 끝남

// console.log('a.match(/.+(?=:)/g) :',a.match(/.+(?=:)/g))
// // : 을 결과에서 제외함

// a = '<html>\n\
// <head>\n\
//     <title>안녕하세요 반갑습니다</title>\n\
// <body>\n\
//     <div>웹사이트에서 내용을 발췌합니다.</div>\n\
// </body>\n\
// </head>'

// console.log(a.match(/<div>.+<\/div>/g))
// console.log(a.match(/(?<=<div>).+(?=<\/div>)/g))
// //<\/div> 의 \ 는 /가 정규표현식의 끝이 아님을 알려줌

// console.log(a.match(/(?<=<title>).+(?=<\/title>)/g))

// a = "일반 텍스트 파일 : abc.txt, 자동실행파일 : autoexec.bat, 데이터분석파일 : bigdata.at, 더미파일 : gfreag, 알수없는 파일 : korea.bar"
// console.log(a.match(/\S+\.[ab]\w+/g))

// a = '박길동 : park@naver.com, 김하나 : kim@daum.net, 이두울: eedu@myhom.co.kr, 웹사이트 : http://abdfwer.co.kr'
// //1)
// console.log('1)', a.match(/\w+[@]\w+[.]\w+[.]*\w*/g))
// //2)
// console.log('2) ', a.match(/\w+[@]\w+[.]\w{3}/g))
// console.log('2) ', a.match(/\w+[@]\w+[.](com|net)/g))


a = '현재 접속중인 외부 아이피는 121.66.42.195 이며 내부 아이피는 192.168.0.2 입니다.'
console.log('1) ', a.match(/\d+[.]\d+[.]\d+[.]\d+/g))
console.log('1) ', a.match(/\d+[.]\d+[.]\d+[.]\d+/g))