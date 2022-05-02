const express = require('express')
const path = require('path')
const nunjucks = require('nunjucks')

const app = express()
app.set('port', process.env.PORT || 3000)
app.use(express.json())
app.use(express.urlencoded({extended: false}))

app.set('view engine', 'html') 
nunjucks.configure('views',{
    express: app,
    watch: true
})


app.get('/', (req, res) => {
    res.render('index', {title:'Express'})
})

app.get('/include', (req, res) => {
    res.render('main')
})

app.get('/extends', (req, res) => {
    res.render('extends')
})


app.listen(app.get('port'), () => {
    console.log('the Server is ready in port', app.get('port'))
})