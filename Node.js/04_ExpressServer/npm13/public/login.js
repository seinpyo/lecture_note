document.getElementById('login-form').addEventListener('submit', async(e)=>{
    e.preventDefault()
    const userid = e.target.userid.value
    const pwd = e.target.password.value

    if(!userid) {return alert('아이디를 입력하세요')}
    if(!pwd) {return alert('비밀번호를 입력하세요')}
    
    try{
        const res = await axios.post('/members/login', {userid, pwd})
        const member = res.data

        let m = document.getElementById('message')
        if(member == null) { m.innerHTML = '아이디가 없습니다'}
        else if(member.pwd != pwd) { innerHTML = '비밀번호를 확인하세요'}
        else if(member.pwd == pwd) { location.href='/boards'}
        else { innerHTML = '오류가 발생했어요. 관리자에게 문의하세요 '}
    } catch(err) {}

    e.target.password.value = '';
})