const express = require('express')
const multer = require('multer')
const path = require('path')
const fs = require('fs')
const {Post, User, Hashtag} = require('../models')
const { isLoggedIn, isNotLoggedIn } = require('./middleware')

const router = express.Router()

try{
    fs.readdirSync('uploads')
} catch(err) {
    console.error('upload폴더 생성')
    fs.mkdirSync('uploads')
}

const upload = multer({
    storage: multer.diskStorage({
        destination(req,file,cb){
            cb(null, 'uploads/')
        },
        filename(req,file,cb){
            const ext = path.extname(file.originalname)
            cb(null, path.basename(file.originalname, ext)+Date.now()+ext)
        }
    }),
    limits: {filesize: 5*1024*1024}
})

router.post('/img', isLoggedIn, upload.single('img'), (req, res, next)=>{
    console.log(`/img/${req.file.filename}`)
    res.json({url: `/img/${req.file.filename}`})
})  //이미지 업로드하고 경로를 return

const upload2 = multer(); //비어있는 multer
router.post('/', isLoggedIn, upload2.none(), async (req,res,next)=>{
    //upload2.none() : 이미지가 다시 업로드 되지 않도록 함
    try { 
        const currentPost = await Post.create({
            content: req.body.content,
            img: req.body.url,
            UserId: req.user.id
        })

        const hashtags = req.body.content.match(/#[^\s#]*/g);
        if( hashtags ) {
            const result = await Promise.all(
                hashtags.map((tag)=>{
                    return Hashtag.findOrCreate({
                        //찾아서 없으면 생성
                        where: {title: tag.slice(1).toLowerCase()}
                        //slice(1) = # 을 제외한 나머지를 소문자로 치환
                    })  
                }),
            )
            await currentPost.addHashtags(result.map((r)=>(r[0])))
            //posthashtags 테이블에 추가
        }

        res.redirect('/')
    } catch(err) {
        console.error(err)
        next(err)
    }
})



module.exports = router