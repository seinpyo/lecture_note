const express = require('express')
const path = require('path')
const app = express()

app.set('port', process.env.PORT || 3000) 

app.use((req, res, next)=>{
    console.log('run for every request')
    next()
}) 

app.use('/about', (req, res, next)=> {
    console.log('run for "/about"')
    next()
})

app.get('/about', (req, res) => {
    res.send('<h2>Hello I am the About</h2>')
})

app.use((req,res,next)=>{
    try {
        //console.log(name)
    } catch (error) {
        next(error) //에러처리 미들웨어로 이동하라는 next
        //error 말고 router가 인수이면 다음 미들웨어로 이동하라는 뜻
    }
    next()
})


app.get('/', (req, res) => {
    res.sendFile (path.join(__dirname, '/index.html')) //미들웨어
})

app.get('/abc', (req, res) => {
    res.sendFile (path.join(__dirname, '/index1.html'))
})

app.get('/category/Boots', (req, res)=>{
    res.send('<h2>hello Boots</h2>')
})

app.get('/category/Heels', (req, res)=>{
    res.send('<h2>hello Heels</h2>')
})

app.get('/category/:name', (req, res)=>{
    res.send(`<h2>hello wild Card String ${req.params.name}</h2>`)
})


app.use((req,res,next)=> {
    res.send ('Unusual Access')
})

app.use((err, req, res, next)=>{
    console.error(error)
    res.status(200). send('an error occurred')
})

app.listen(app.get('port'), () => {
    console.log('the Server is ready in port ', app.get('port'))
})
