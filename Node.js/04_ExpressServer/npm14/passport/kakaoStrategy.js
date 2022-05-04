const passport = require('passport')
const KakaoStrategy = require('passport-kakao').Strategy;
const User = require('../models/user')
module.exports = ()=> {
    passport.use(new KakaoStrategy({
        clientID: process.env.KAKAO_ID,
        callbackURL: '/auth/kakao/callback'
        
    }, async (accessToken, refreshToken, profile, done) => {
        console.log('kakao profile', profile); 
        try{
            const exUser = await User.findOne({
                where: {snsid: profile.id, provider: 'kakao'}
            })
            if(exUser) {
                done(null, exUser) //아이디가 존재하면 검색결과(exUser)를 가지고 done으로 복귀
                //로그인 절차를 실행한다
            } else {
                //검색 결과가 없으면 회원정보를 user테이블에 추가
                const newUser = await User.create({
                    email:profile._json && profile._json.kakao_account.email,
                    nick: profile.displayName,
                    snsid: profile.id, 
                    provider: 'kakao'
                }) 
                done(null, newUser) //회원가입 후 로그인 절차 실행
            } 
        }catch(error) {
            console.error(error); done(error);
        }
    }))
}