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
    fs.readdirSync('uploads') //'uploads'폴더가 있으면 불러옴
} catch (err){
    console.error('Create a uploads folder')
    fs.mkdirSync('uploads') //'uploads'폴더가 없으면 생성
}


const upload = multer({
    storage:multer.diskStorage({
        destination(req, file, done) {
            done(null, 'uploads/')
            //null은 현재 파일의 경로와 이름 그대로 사용 한다는 것
        }, 
        filename(req, file, done) {
            const ext = path.extname(file.originalname) //확장자 추출
            done(null, path.basename(file.originalname, ext) + Date.now() + ext)
            //확장자를 뺀 파일이름 + 오늘 날짜(밀리초) + 추출된 확장자로 저장 파일명 변경 
            //업로드 파일명이 같은 경우 cos처럼 처리할 객체가 없으므로 위와 같은 방식으로 파일명 충돌을 방지한다
        }
    }),
    limits:{
        fileSize: 5*1024*1024
    }
})

app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, '/multer.html'))
})

app.post('/upload', upload.single('image'), (req, res) => {
    console.log('req.file : ', req.file)
    console.log('req.body.title : ', req.body.title)
    return res.json({title:req.body.title, filename:req.file.filename})
})


app.listen(app.get('port'), ()=>{
    console.log('the Server is ready in port', app.get('port'))
})