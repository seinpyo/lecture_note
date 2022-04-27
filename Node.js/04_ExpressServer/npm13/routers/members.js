const express = require('express')
const Member = require('../models/Member') 
const Board = require('../models/Board')
const Reply = require('../models/Reply')
const router = express.Router();

router.post('/login', async (req, res, next)=>{
    console.log('ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ')
    console.log(req.body.userid, req.body.pwd)
    try{
        const loginUser = await Member.findOne({ 
            //결과가 하나로 예상되기 때문에(pk를 검색하므로) findOne 사용
            where: {userid : req.body.userid}
        });
        console.log('로그인 유저 : ', loginUser)
        if((loginUser!=null) && (loginUser.pwd!=req.body.pwd)) {
            //로그인 성공
            req.session.loginUser = loginUser; //세션에 loginUser저장
        } 
        
        console.log(loginUser)
        res.json(loginUser)
    } catch(err) { console.error(err); next(err); }
})
module.exports = router;