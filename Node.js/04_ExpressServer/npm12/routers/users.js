const express = require('express')
const User = require('../models/user') 
const Comment = require('../models/comment')

const router = express.Router()

router.post('/', async (req, res, next)=>{
    //전달된 값들로 레코드 추가
    try {
        const user = await User.create({
            name: req.body.name,
            age: req.body.age,
            married: req.body.married
        })
        console.log(user) //test용
        res.json(user) //test용
    } catch(err) { 
        console.error(err);
        next(err);
    }
})

router.get('/', async (req, res)=>{
    try{
        const users = await User.findAll({ }) //전부 조회
        res.json(users)
    } catch(err) { console.error(err); next(err); }
})

module.exports = router; 