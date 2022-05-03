const passport = require('passport')
const local = require('./localStrategy')
const User = require('../models/user')

module.exports = () => {
    passport.serializeUser((user, done)=>{ //정상 로그인되었을 때 실행
        done(null, user.id) //세션에 아이디 저장
        //이 동작 이후 세션에 아이디가 저장 = 세션 쿠키에도 암호회된 키가 저장
        //{id:3, 'connect.sid:123124123'} 와같은 세션쿠키가 생성되며
        //브라우저에서 connect.sid 값이 deserializeUser로 세션값으로 복구/사용 됨
    })

    passport.deserializeUser((id,done)=>{
        User.findOne({ where: {id} })
        .then(user => done(null, user)) 
        //세션에 저장된 아이디와 쿠키로 user를 복구, req.user로 사용
        //로그인 되어있는동안 req.isAuthenticated()함수의 결과는 true
        .catch(err=>done(err))
    })
    local()
}