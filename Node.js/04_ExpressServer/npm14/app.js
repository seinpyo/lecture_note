const express = require('express')
const cookieParser = require('cookie-parser')
const session = require('express-session')
const path = require('path')
const nunjucks = require('nunjucks')
const dotenv = require('dotenv')
const passport = require('passport')

const app = express()
app.set('port', process.env.PORT || 3000)

dotenv.config() //dotenv 설정은 가장 위에 쓸것
const passportConfig = require('./passport')
passportConfig() //패스포트 설정

app.set('view engine', 'html')
nunjucks.configure('views', {express:app, watch:true})
app.use(express.static(path.join(__dirname, '/public')))
app.use('/img', express.static(path.join(__dirname, '/uploads')))
//이미지용 스태틱 폴더

app.use(express.json())
app.use(express.urlencoded({extended:false}))
app.use(cookieParser(process.env.COOKIE_SECRET))
app.use(session({
    resave: false,
    saveUninitialized: false, 
    secret: process.env.COOKIE_SECRET, 
    cookie:{
        httpOnly:true,
        secure:false
    }
}))

app.use(passport.initialize()) //express cookie 보다 아래
app.use(passport.session()) // 세션 쿠키 사용을 위한 설정

const {sequelize} = require("./models")
sequelize.sync({force:false})
.then(()=>{
    console.log('DB 연결 완료')
})
.catch((err) => {
    console.error(err)
})

const postRouter = require('./routers/post')
const pageRouter = require('./routers/page')
const authRouter = require('./routers/auth')
const userRouter = require('./routers/user')

app.use('/', pageRouter)
app.use('/post', postRouter)
app.use('/auth', authRouter)
app.use('/user', userRouter)


// app.get('/', (req, res)=>{
//     res.send('<h1>hello world</h1>')
// })

app.use((req, res, next)=> {
    const error = new Error(`${req.method} ${req.url} 라우터가 없습니다.`)
    error.status = 404
    next(error)
})//해당 요청에 따른 라우터가 없을 때 404

app.use((err, req, res, next)=>{
    res.locals.message = err.message
    res.locals.error = process.env.NODE_ENV !== 'production' ? err : {}
    res.status(err.status||500)
    res.render(err)
})

app.listen(app.get('port'), () => {
    console.log('the Server is ready in port', app.get('port'))
})