const express = require('express')
const path = require('path')
const nunjucks = require('nunjucks')
const cookieParser = require('cookie-parser')
const session = require('express-session')
const dateFilter = require('nunjucks-date-filter') //넌적스에서 사용할 날짜 양식 필터

//Router Require
const indexRouter = require('./routers')
const membersRouter = require('./routers/members')
const boardsRouter = require('./routers/boards')

const app = express()
app.set('port', process.env.PORT || 3000)

app.use(express.static(path.join(__dirname, 'public'))) //static폴더 지정
app.set('view engine', 'html')
let env = nunjucks.configure('views', { express: app, watch: true })
env.addFilter('date', dateFilter)

app.use(cookieParser())
app.use(session({
    resave: false, saveUninitialized: false, secret: 'shemjs'
}))
app.use(express.json())
app.use(express.urlencoded({extended: false}))

app.use('/', indexRouter)
app.use('/members', membersRouter)
app.use('/boards', boardsRouter)

const {sequelize} = require('./models')
sequelize.sync({force: false})//이미 존재하는 테이블 재생성 false
.then(()=>{console.log('데이터베이스 연결 성공')})
.catch(()=> console.error(err))

//에러처리 미들웨어
app.use((req,res,next) => {
    const error = new Eroor(`${req.method} ${req.url} 라우터가 없습니다`)
    error.status = 404;
    next(error)
})
app.use((err, req, res, next) => {
    res.locals.message = err.message;
    res.locals.error = process.env.NODE_ENV !== 'production' ? err : {};
    res.status(err.status || 500);
    res.render('error');
})

app.get('/', (req, res)=>{
    res.send('<h1> 안녕하세요 </h1>')
})

app.listen(app.get('port'), () => {
    console.log('the Server is ready in port', app.get('port'))
})