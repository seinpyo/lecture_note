
const http = require('http')
http.createServer((req, res) => {
    console.log(req.url, req.headers.cookie)
    //클라이언트 요청에는 header의 쿠키가 자동으로 동봉됨
    // res.writeHead(200, {
    //     'Set-Cookie' : 'mycookie=test'
    // })
    res.end('<h1>Hello Cookie</h1>')
}).listen(8090, () => {
    console.log('Server is ready in port 8090')
})