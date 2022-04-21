const http = require('http')
const fs = require('fs').promises
const url = require('url')
const qs = require('querystring')

const parseCookies = (cookie='') =>
    cookie 
        .split(';')
        .map(v=>v.split('='))
        .reduce(( acc, [k, v]) =>{
            acc[k.trim()] = decodeURIComponent(v)
            return acc
        }, {})

const session = {}

http.createServer(async(req, res) => {
    const cookies = parseCookies(req.headers.cookie) 
    
    if(req.url.startsWith('/login')) {
        const {query} = url.parse(req.url)
        const {name} = qs.parse(query)
        
        console.log('name : ' + name)

        //세션, 쿠키 수명 계산
        const expires = new Date()
        expires.setMinutes(expires.getMinutes() + 1)

        //세션 객체에 저장하기 위한 고유 키값
        const uniqueInt = Date.now() 

        //Cookies -> name = ${uniqueInt}
        //Session -> ${uniqueInt} : '홍길동'
        //의 형태로 저장됨
        //세션의 값들은 서버에서 관리 : 세션에서 해당값의 유무, 쿠키 값의 유무를 검사해 조회한다

        session[uniqueInt] = {
            name, 
            expires,
        }

        res.writeHead(302, {
            Location: '/',
            'Set-Cookie' : `session=${uniqueInt}; Expires=${expires.toGMTString()}; HttpOnly; Path=/`
        })  
        //쿠키에는 고유 키 값(uniqueInt)을 value로써 session key에 저장 (실제 값은 없음)
        res.end()
    } else if(cookies.session && session[cookies.session].expires > new Date() ) { 
        //쿠키에 session이라는 key가 존재 && session의 유효시간이 지나지 않있을 때

        console.log(cookies.session)
        res.writeHead(200, {'Content-Type' : 'text/plain; charset=utf-8'})
        res.end(`${session[cookies.session].name}님 안녕하세요`)

    } else {
        try {
            const data = await fs.readFile('./06_Cookie_page.html')
            res.end(data)
        } catch(err) {
            res.writeHead(500, {'Content-Type' : 'text/plain; charset=utf-8'})
            res.end(err.message)
        }
    }
}).listen(8090, () => {
    console.log('Server is ready in port 8090')
})