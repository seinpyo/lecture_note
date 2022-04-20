
const url = require('url')

const {URL} = url
const myURL = new URL('https://www.disneyplus.com/ko-kr/movies/turning-red/4mFPCXJi7N2m')
console.log('new URL() : ', myURL)
console.log('url.format() : ', url.format(myURL))

console.log()
console.log('-------------------------')
const parseUrl = url.parse('https://www.disneyplus.com/ko-kr/movies/turning-red/4mFPCXJi7N2m')
console.log('url.parse() : ', parseUrl)
console.log('url.format() : ', url.format(parseUrl))

console.log('pathname : ', parseUrl.pathname);