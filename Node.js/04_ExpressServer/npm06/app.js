const express = require('express')
const path = require('path')
const morgan = require('morgan')
const cookieParser = require('cookie-parser')
const session = require('express-session')

const app = express()
app.set('port', process.env.PORT || 3000) 

app.use(morgan('dev'))
app.use(cookieParser())
app.use(express.json())
app.use(express.urlencoded({extended:true}))
app.use(session ({
    resave:false,
    saveUninitialized:false,
    secret: "scott" //세션값의 암호화 코드
}))

app.get('/', (req, res)=> {
    if(req.session.userid){
        res.send(`<h1> Hello ${req.session.userid} </h1> <br> <a href='/logout'> logout </a>`)
    } else {
        res.sendFile(path.join(__dirname, '/index.html'))
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