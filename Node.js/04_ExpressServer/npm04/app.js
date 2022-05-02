const express = require('express')
const path = require('path')
//추가 설치 모듈 require-------------------------------------
//각각 요청과 응답에 대한 필요 정보를 보기 위한 모듈 
const morgan = require('morgan')
//쿠키 사용을 간결하게 하기 위한 모듈
const cookieParser = require('cookie-parser')
//세션 사용을 간결하기 위한 모듈
const session = require('express-session')
//요청의 본문을 해석, 구분하는 모듈
const bodyParser = require('body-parser')
//-----------------------------------------------------------
//각각 요청과 응답에 대한 필요 정보를 보기 위한 모듈 

const app = express()
app.set('port', process.env.PORT || 3000) 

//공통 모듈 미들 웨어 설정-----------------------------------
app.use(morgan('dev'))
//실행 결과 예시 : GET / 200 5.316 ms = 165
//mothod 방식, 응답 결과 코드, 요청과 실행에 걸린 시간 등등
//app.use(morgan('combined')) 로 더 자세한 내용을 볼 수도 있다.
app.use(cookieParser())
app.use(express.json()) //body parser json:json 사용하기 위한 모듈
app.use(express.urlencoded({extended:true})) //바디파서 폼데이터 모듈
app.use(session({
    resave:false,
    saveUninitialized:false,
    secret:"sen"
})) //세션 활용을 위한 미들 웨어
//---------------------------------------------------------


app.get('/', (req, res)=>{

    console.log(req.cookies) //쿠키를 모두 읽어와 출력
    console.log(req.cookies.test) //쿠키 중 test만 출력
    res.cookie('test', 'cookietest', {
        httpOnly: true,
        path: '/'
    })
    if(req.cookies.id){
        res.send(`Hello ${req.cookies.id} <br><a href="/logout">logout</a>`)
    }else{
        res.sendFile(path.join(__dirname, '/index.html'))
    } 
})

app.post('/login', (req, res)=>{
    //localhost3000:/login?id=hong -> post라 id=hong이 안보임
    console.log(req.body.name);
    const name = req.body.name; 

    const expires = new Date()
    expires.setMinutes(expires.getMinutes() + 1 )

    res.cookie('id', name, {
        expires: expires,
        httpOnly: true,
        path: '/'
    }) //파라미터를 쿠키에 추가

    res.redirect('/') //'/' 요청으로 이동
}) 

//쿠키를 지우고 '/'로 리다이렉트 
app.get('/logout', (req, res) => {
    res.clearCookie('id', req.cookies.name, {
        httpOnly: true,
        path: '/'
    })

    res.redirect('/')
})


app.listen(app.get('port'), () => {
    console.log('the Server is ready in port ', app.get('port'))
})
