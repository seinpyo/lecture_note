const express = require('express')
const {Post, User, Hashtag} = require('../models')

const router = express.Router()

router.get('/', async (req, res, next)=>{
    try{
        const posts = await Post.findAll({
            include : { 
                model:User, attribute:['id', 'nicl'],
            },
            order:[['createdAt', 'DESC']],
        })
        res.render('main', {
            title:'Nodegram',   //타이틀
            user:req.user,      //로그인한 유저의 객체
            followerCount:0,    //팔로워 수 
            followingCount:0,   //팔로잉 수
            followerIdList:[],  //팔로워 아이디 리스트 : 배열
            posts      //전체 포스팅 객체
        })
    } catch(err) {
        console.error(err)
        next(err)
    }
}); 

router.get('/join', (req, res, next)=>{
    res.render('join', {title:'NodeGram 회원가입'})
})

router.get('/profile', (req, res)=>{
    res.render('profile', {
        title: '내정보 - Nodegram',
        user: req.user,
        followerCount: 0,
        followingCount: 0,
        follwerIdList: []
    })
})

router.get('/hashtag', async (req, res, next) => {
    const query = req.query.hashtag
    if(!query) { //입력된 검색어가 없을 때 
        return res.redirect('/') 
    }
    try{
        const hashtag = await Hashtag.findOne({where: {title: query}})
        let posts = []
        if(hashtag) {
            posts = await hashtag.getPosts({include: [{model: User}]})
            //해당 해시태그로 게시물 번호 검색
        } return res.render('main', {
            title: `${query} | NodeGram`,
            posts, 
            user:req.user,
            followerCount: 0,
            followingCount: 0,
            follwerIdList: []
        })
    } catch(error) {
        console.error(error)
        return next(error)
    }
})

module.exports = router