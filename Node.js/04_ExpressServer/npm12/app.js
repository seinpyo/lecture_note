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

const indexRouter = require('./routers')
const usersRouter = require('./routers/users')
const commentsRouter = require('./routers/comments')

app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/comments', commentsRouter);

app.use((req, res, next) => {
    const error = new Error(`${req.method} ${req.url} 라우터가 없습니다.`)
    error.status = 404;
    next(error)
})
app.use((err, req, res, next) => {
    res.locals.message = err.message;
    res.locals.error = process.env.NODE_ENV !== 'production' ? err : {};
    res.status(err.status || 500);
    res.render('error');
})

app.listen(app.get('port'), () => {
    console.log('the Server is ready in port', app.get('port'))
})
