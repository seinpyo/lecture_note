const passport = require('passport')
const LocalStrategy = require('passport-local').Strategy;
const bcrypt = require('bcrypt')
const User = require('../models/user')

//local 사용자의 로그인 절차를 정의한 strategy
module.exports = ()=>{
    passport.use(new LocalStrategy({
        usernameField:'email', //req.body.email (파라미터의 key값과 일치하게 작성 )
        passwordField:'password', //req.body.password 
    }, async(email, password, done)=>{
        try{
            const exUser = await User.findOne({
                where:{email}
            }) 
            if(exUser){ //검색결과가 존재한다면
                const result = await bcrypt.compare(password, exUser.password)
                if(result) { //비밀번호가 일치한다면
                    done(null, exUser) //passport.authenticate가 호출된 위치로 돌아감
                    //authError:null, user:exUser
                } else {    //비밀번호 일치 x
                    done(null, false, {message:'비밀번호가 일치하지 않습니다.'})
                    //authError:null, user:false, info:보내는 메시지
                }
            } else {    //존재하지 않는다면
                done(null, false, {message: '존재하지 않는 아이디입니다.'})
            }
        }catch(err) { 
        } 
    }))
}