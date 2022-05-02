const express = require('express')
const User = require('../models/user') 
const Comment = require('../models/comment')

const router = express.Router()

router.post('/', async (req, res, next)=>{
    console.log('Comments post '/' access')
    try {
        console.log('/ try access')
        const comment = await Comment.create({
            commenter: req.body.id,
            comment: req.body.comment
        })
        console.log(comment) //test용
        res.json(comment) //test용
    } catch(err) { 
        console.error(err);
        next(err);
    }
})


router.get('/', async (req, res, next)=>{
    try{
        const comments = await Comment.findAll({
            include: { model: User } // user 테이블과 join 
        })
        res.json(comments);
    } catch(err) {
        console.error(err)
        next(err)
    }
})


module.exports = router; 