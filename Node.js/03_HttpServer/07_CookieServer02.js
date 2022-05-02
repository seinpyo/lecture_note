const http = require('http')
const fs = require('fs').promises
const url = require('url')
const qs = require('querystring')

const parseCookies = (cookie='') => 
cookie  
    .split(';')
    .map(v=>v.split('='))

//cookie1=test1; cookie2=test2; 형태로 전달되는 쿠키를 
//쿠키 단위로 나누고 다시 '='로 분리
    .reduce(( acc, [k, v]) =>{
        acc[k.trim()] = decodeURIComponent(v)
        return acc
    }, {})
// 분리된 cookie1, test를 각각 k와 v에 전달 -> 객체 형태로 만든 후 acc에 저장 --> 마지막 {} 는 분리된 쿠키들이 [k, v] 형태가 되어 객체로 저장 취합된다는 의미 


http.createServer(async (req, res) => {
    
    const cookies = parseCookies ( req.headers.cookie )
    // key:value 형태로 변환후 cookies 변수에 저장 

    if(req.url.startsWith('/login')) {
        //쿼리 스트링 분리
        const {query} = url.parse(req.url)
        console.log(query) //name=%EA%B9%80%EC%A0%9C%EB%8F%99
        const {name} = qs.parse(query)
        
        const expires = new Date()
        //쿠키 유효시간 설정을 위해 현재 날짜 데이터 생성
        expires.setMinutes(expires.getMinutes()+1) 
        //쿠키 유효시간을 현재 시간 +1분으로 설정 

        res.writeHead(302, {
            Location : '/',
            'Set-Cookie': `name=${encodeURIComponent(name)}; Expires=${expires.toGMTString()}; HttpOnly; Path=/`
        })  //경로및위치, 유효시간, 쿠키 접근을 http 방식으로만 제한

        res.end()

    } else if(cookies.name) { //로그인 되어 세션값이 존재하는 경우

        res.writeHead(200, {'Content-Type' : 'text/plain; charset=utf-8'})
        res.end(`${cookies.name}님 안녕하세요`)
            
        }else {
            try {
                const data = await fs.readFile('./06_Cookie_page.html')
                res.end(data)
            } catch(err) {
                res.writeHead(500, {'Content-Type' : 'text/plain; charset=utf-8'})
                res.end(err.message)
            }
        }
    }
).listen(8090, () => {
    console.log('Server is ready in port 8090')
})