let a = 'blue socks and red shoes'
b = a.replace(/blue|white|red/g, 'color')
//console.log('a.replace =>', b)

a = 'park 010-1234-5678, kim 010-9999-8888, lee 010-1111-2222'
//console.log(a.replace(/[-]\d{4}\s/g, '-****'))

a = '네이버 - http://www.naver.com/, 다음 - http://www.daum.net/, 네이트 - http://www.nate.com/'
b = a.replace(/http/g, 'https')
c = a.replace(/\w+(?=:)/g, 'https')
console.log(b)
console.log(c)