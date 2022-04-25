const express = require('express')
const app = express()
app.set('port', process.env.PORT || 3000)

const indexRouter = require('./Routers') 
//경로에 ./router만 써도 index.js가 자동인식 됨
const usersRouter = require('./Routers/users')

app.use('/', indexRouter) 
// http://localhost:3000/ 을 index.js의 '/'에서 요청 받아 사용
// http://localhost:3000/about 은 index.js의 '/about'에서 요청 받아 사용
app.use('/users', usersRouter) 
// inedx.js가 아닌 파일들은 파일명이 붙음
// http://localhost:3000/users/ -> users.js의 '/'에서 요청 받아 사용
// http://localhost:3000/users/search -> users.js의 '/search'에서 요청 받아 사용

app.listen(app.get('port'), ()=>{
    console.log('the Server is ready in port', app.get('port'))
})
