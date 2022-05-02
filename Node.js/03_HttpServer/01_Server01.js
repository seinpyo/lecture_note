//Node.js에 포함된 기능과 문법을 이용해서 웹호스팅을 할수 있는 서버 구축

const http = require('http')

http.createServer((req, res) => {
    res.write('<h1>Hello World!</h1>')
    res.write('<h2>Welcome to my NodeJS server :) </h2>')
}).listen( 8090, () => {
    console.log('Server is ready in port 8090')
} )
