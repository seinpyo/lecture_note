
exports.isLoggedIn = (req, res, next)=>{
    if(req.isAuthenticated()) {
        next() //다음 라우터로 이동
    } else {
        res.status(403).send('로그인하세요')
    }
}

exports.isNotLoggedIn = (req,res, next)=>{
    if(!req.isAuthenticated()){ next() }
    else {
        const message = encodeURIComponent('이미 로그인했어요')
        res.redirect(`/?error=${message}`)
    }
}