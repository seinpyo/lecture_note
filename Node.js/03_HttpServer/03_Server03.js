const http = require('http')

http.createServer((req, res)=>{
    res.write('<h1>First sever</h1>')
    res.end('<p>Hello Sever!</p>')
    //res.end 이후에 더 이상 응답 내용이 전달 될 수 없음
}).listen(8081, ()=>{
    console.log('Server is ready in port 8081')
})

http.createServer((req, res)=>{
    res.write('<h1>Second sever</h1>')
    res.end('<p>Hello Sever!</p>')
}).listen(8082, ()=>{
    console.log('Server is ready in port 8082')
})