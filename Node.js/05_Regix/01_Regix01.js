// let a = "while some may view this debt forgiveness ass a slap in the face to people who were resposible and paid off their student loans"

// a.match(/a/)
// // /와 / 사이에 찾고자 하는 글자를 추가 

// let b = a.match(/a/) //a변수 안에 string 내용 중 'a'를 검색

// let c = a.match(/th/g) //th를 찾아 출력

// a = 'akljsdbkfablnabb'
// let d = a.match(/ab*/g) //a로 시작하고 그 뒤에 b가 반복되는 글자 검색


// a = 'a'
// b = 'before'
// c = 'dude'
// console.log(a.match(/abc/g))
// console.log(a.match(/[abc]/g))
// console.log(b.match(/[abc]/g))
// console.log(c.match(/[abc]/g))

// a = 'may the force be with you'
// console.log(a.match(/m[abc]/g)) //m으로 시작하고 그 뒤 문자가 a||b||c 

// let a = 'ABCDefhH'
// console.log(a.match(/[a-z]/g))

// a = 'AbcDeFgh1I0'
// console.log(a.match(/[\d]/g))

// a ='Abcd efg'
// console.log(a.match(/[^\s]/g))

// a= '@#$@%!@#{{2'
// console.log(a.match(/[\w]/g))

// let a = 'aab'
// console.log(a.match(/a.b/g))

// a = 'a0b'
// console.log(a.match(/a.b/g))

// a = 'a.b'
// console.log(a.match(/a.b/g))

// a = 'avb'
// console.log(a.match(/a[.]b/g))

// a = 'a.bv'
// console.log(a.match(/a[.]b/g))


// let a = 'caat'
// console.log(a.match(/ca*t/g))

// a = 'caat'
// console.log(a.match(/ca+t/g))

// a = 'ct'
// console.log(a.match(/ca*t/g))

// a = 'ct'
// console.log(a.match(/ca+t/g))


// let a = 'ct'
// console.log('a = ct')
// console.log('{2}', a.match(/ca{2}t/))
// console.log('{2,4}', a.match(/ca{2,4}t/))
// console.log('?', a.match(/ca?t/))
// console.log()

// a = 'caat'
// console.log('a = caat')
// console.log('{2}', a.match(/ca{2}t/))
// console.log('{2,4}', a.match(/ca{2,4}t/))
// console.log('?', a.match(/ca?t/))
// console.log()

// a = 'caaaat'
// console.log('a = caaaat')
// console.log('{2}', a.match(/ca{2}t/))
// console.log('{2,4}', a.match(/ca{2,4}t/))
// console.log('?', a.match(/ca?t/))

let a = ' park chan ho 010-1234-5678 kim min 010-8888-9999 lee 011-123-2222 '
console.log(a.match(/\d{3}-\d{3,4}-\d{4}/g))

a = 'park chan ho park@naver.com Kim min kim@daum.net Lee lee@myhom.com'
console.log(a.match(/\w*@\w*.\w*/g))

//@\d{10}.com


//node 01_Regix01.js