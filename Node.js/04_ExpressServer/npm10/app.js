const express = require('express')
const cookieParser = require('cookie-parser')
const session = require('express-session')
const path = require('path')
const dotenv = require('dotenv') //npm i dotenv 필요

dotenv.config(); //비밀키 비공개를 위한 기본 환경 설정

const app = express()
app.set('port', process.env.PORT || 3000)

app.use(express.json())
app.use(express.urlencoded({extended: false}))
app.use(cookieParser(process.env.COOKIE_SECRET))
app.use(session({
    resave: false,
    saveUninitialized: false,
    //secret: 'nodejsdotenv', //저장할 떄 사용하는 암호화키
    secret: process.env.COOKIE_SECRET,
    cookie: {
        httpOnly: true,
        secure: false
    },
    name: 'session-cookie'
}))

app.get('/', (req, res)=> {
    if(req.session.userid){
        res.send(`<h1> Hello ${req.session.userid} </h1> <br> <a href='/logout'> logout </a>`)
    } else {
        res.sendFile(path.join(__dirname, '/login.html'))
    }
})

app.post('/login', (req, res)=>{
    const id = req.body.id;
    const pw = req.body.pw;

    if(id=='scott' && pw=='tiger'){
        req.session.userid = id
        return res.json({msg:'ok'})
    } else if (id != 'scott'){
        return res.json({msg:'id is not exsist'})
    } else if(pw!='tiger'){
        return res.json({msg:'Wrong password'})
    } else {
        return res.json({msg:'login error. please try again'})
    }
})

app.get('/logout', (req, res)=>{
    req.session.destroy(function(){
        req.session
    })
    res.redirect('/')
})

app.listen(app.get('port'), ()=>{
    console.log('the Server is ready in port', app.get('port'))
})