const express = require('express')
const fs = require('fs')
const path = require('path')
const multer = require('multer')
const app = express()
app.set('port', process.env.PORT || 3000) 

app.use(express.json())
app.use(express.urlencoded({extended:false}))
app.use('/', express.static(path.join(__dirname, 'uploads')))

try{
    fs.readdirSync('uploads') 
} catch (err){
    console.error('Create a uploads folder')
    fs.mkdirSync('uploads')
}

const upload = multer({
    storage:multer.diskStorage({
        destination(req, file, done) {
            done(null, 'uploads/')
        }, 
        filename(req, file, done) {
            const ext = path.extname(file.originalname) 
            done(null, path.basename(file.originalname, ext) + Date.now() + ext)
        }
    }),
    limits:{
        fileSize: 5*1024*1024
    }
})

app.get('/', (req, res) => {
    
})

app.post('/upload', upload.single('image'), (req, res) => {
    return res.json({
        filename:req.file.filename
    })
})

app.listen(app.get('port'), ()=>{
    console.log('the Server is ready in port', app.get('port'))
})