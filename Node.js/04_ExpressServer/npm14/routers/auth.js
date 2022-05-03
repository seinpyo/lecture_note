const express = require('express')
const User = require('../models/user')
const bcrypt = require('bcrypt')
const passport = require('passport')

const router = express.Router()

router.post('/join', async (req, res,next)=>{
    // const email = req.body.email;
    // const nick = req.body.nick;
    // const password = req.body.password;
    const { email, nick, password } = req.body
    try{
        const exUser = await User.findOne({
            where: {email}  
        })  //전송된 이메일 주소로 가입된 회원이 있는지 확인

        if(exUser){ //exUser가 검색되었다면 = 이메일 중복
            return res.redirect('/join?error=exist')
        }

        const hash = await bcrypt.hash(password, 12);
        //해시연산 : 암호화와 비슷한 연산결과로 
        //          같은 원본 데이터라도 절대 같은 결과가 나오지 않게하는 연산
        //12 : 해쉬화 하기위한 복잡도. 숫자가 클수록 복잡하게 암호화되고 복호화도 오래걸림

        await User.create({
            email, nick, password:hash
        }) //이메일 닉네임 비밀번호로 회원추가 
        
        return res.redirect('/')

    }catch(err){
        console.error(err)
        next(err)
    }
}) // 일반(local) 회원가입

router.post('/login',  (req, res, next)=>{
    //possport모듈로 로그인 구현
    passport.authenticate('local', (authError, user, info)=>{
        //로그인을 위해 현재 미들웨어가 실행되고 local 까지만 인식되고 
        //passport폴더의 localStategy 로 이동해 로그인 처리 후,
        //done()에 의해서 되돌아오면 (authError, user, info)=>{} 함수가 실행됨

        //로그인 성공 시 user에 로그인한 사람의 정보가 들어옴
        if(authError) { //서버 에러 발생 시 
            console.error(authError)
            return next(authError)
        }

        if(!user) {//user가 false라면 
            return res.redirect(`/?loginError=${info.message}`)
        }

        //정상로그인 처리
        return req.login(user,(loginError)=>{
            //req.login 하면 passport/index.js로 이동-> 로그인 루틴 실행 -> 복귀
            if(loginError) {    //index.js에서 보는 에러가 있으면 에러처리
                console.error(loginError)
                return next(loginError)
            }
            
            return res.redirect('/')
            //현재 위치에서 세션 쿠키가 브라우저로 보내짐
        })
        
    })(req, res, next) //미들웨어 내의 미들웨어 뒤에는 (req,res,next)를 붙인다
}) 

router.get('/logout', (req,res)=>{
    req.logout();
    req.session.destroy();
    res.redirect('/');
})

module.exports = router