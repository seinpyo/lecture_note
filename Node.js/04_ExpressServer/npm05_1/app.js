const express = require('express')
const path = require('path')
const morgan = require('morgan')
const cookieParser = require('cookie-parser')

const app = express()
app.set('port', process.env.PORT || 3000) 

app.use(morgan('dev'))
app.use(cookieParser())
app.use(express.json())
app.use(express.urlencoded({extended:true}))

app.get('/', (req, res) => {
    if(req.cookies.id) {
        res.send(`<h1> Hello ${req.cookies.id} </h1> <br> <a href="/logout">logout</a>`)
    } else {
        res.sendFile(path.join(__dirname, '/index.html'))
    }
})

app.post('/login', (req, res) => {

    const id = req.body.id;
    const pw = req.body.pw;

    const expires = new Date();
    expires.setMinutes(expires.getMinutes() + 1)

    if( id=='scott' && pw=='tiger'){
        res.cookie('id', id, {
            expires: expires,
            httpOnly: true,
            path: '/'
        })
        return res.json({msg:'ok'})
    } else if (id != 'scott'){
        return res.json({msg:'id is not exsist'})
    } else if(pw!='tiger'){
        return res.json({msg:'Wrong password'})
    } else {
        return res.json({msg:'login error. please try again'})
    }
})

app.listen(app.get('port'), ()=>{
    console.log('the Server is ready in port', app.get('port'))
})