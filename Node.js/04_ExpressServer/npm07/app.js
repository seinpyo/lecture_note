const express = require('express')
const path = require('path')
const app = express()

app.use(express.json())
app.use(express.urlencoded({extended:false}))



app.set('port', process.env.PORT || 3000) 

app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, '/multer.html'))
})

app.listen(app.get('port'), ()=>{
    console.log('the Server is ready in port', app.get('port'))
})