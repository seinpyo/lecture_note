const express = require('express')
const User = require('../models/user')
const { isLoggedIn, isNotLoggedIn } = require('./middleware')

const router = express.Router()

router.post('/follow/:id', isLoggedIn, async(req, res, next)=>{
    const loginuser = await User.findOne({
        where: { id: req.user.id }
    })

    if(loginuser){
        await loginuser.addFollowings( parseInt(req.params.id, 10) )
        //as:'Followings'에 따른 메서드가 자동으로 만들어진다(복수,단수 모두 가능) 
        //setFolowing 수정 메서드
        //getFollowing removeFollwings 복수면 [] 사용
        res.send('success')
    } else { res.status(404).send('회원을 찾을 수 없습니다.') }
});

module.exports = router