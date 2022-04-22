const express = require('express')

const app = express() //서버 객체를 변수에 저장

app.set('port', process.env.PORT || 3000) 
//서버내에 port 변수를 만들어 현재 환경의 포트 || 3000을 저장한다

app.get('/', (req, res) => {
    res.send('<h1>Hello Express Server</h1>')
})

app.listen(app.get('port'), () => {
    console.log('the Server is ready in port ', app.get('port'))
})
