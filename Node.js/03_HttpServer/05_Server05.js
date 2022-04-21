const http = require('http')
const fs = require('fs').promises

let users = {} 
//서버가 종료될 때까지 값이 유지되는 변수

http.createServer( async (req, res)=>{
    try { 
        if(req.method == 'GET') {
            if(req.url === '/') {
                //첫번째 페이지로 갈 때
                const data = await fs.readFile('./05_Front.html')
                res.writeHead(200, {'Content-Type' : 'text/html; charset=utf-8'})
                return res.end(data)
                //파일 내용 전송 후 async(req, res)=>{} 함수가 
                //종료되도록 return
                //return이 없으면 try문 아래에 400 NOTFOUND도 같이 실행되게 됨
            } else if(req.url === '/about'){
                const data = await fs.readFile('./05_about.html')
                res.writeHead(200, {'Content-Type' : 'text/html; charset=utf-8'})
                return res.end(data)
            } else if(req.url === '/users'){
                return res.end(JSON.stringify(users))
                //user 객체 안의 내용을 json 형식으로 변경하여 전송
            }
        } else if (req.method == 'POST'){
            if(req.url === '/user') {
                //req에 전송된 자료를 stream 형식으로 받아 body변수에 대입
                let body = ''
                req.on('data', (data)=>{
                    body += data
                })
                //req.on() : request의 동작을 첫 번째 인수로 전달된 키워드로 구분, 익명함수를 실행한다. 
                //전달된 자료를 모두 객체 형식으로 받아서 처리한다. 
                return req.on('end', ()=> {
                    const {name} = JSON.parse(body)
                    //전달된 데이터를 name 변수에 저장
                    const id = Date.now() //id 변수에 날짜를 추출
                    users[id] = name;
                    res.writeHead(201, {'Content-Type' : 'text/plain; charset=utf-8'})
                    res.end('ok') //함수에서 빠져 나감
                })
            } 
        } else if (req.method == 'PUT') {
            if(req.url.startsWith('/user/')){
                // axios.put('/user/' + key, {name}) 이 전달되기 때문에 
                // '/user/'로 시작하는 주소를 찾도록 함
                
                const key = req.url.split('/')[2] 
                //  req.url.split('/')[0]: , [1]: user, [2]: key
                console.log(key)
                // 1650515427987 (POST ('/user')에서 설정한 Date.now()의 값)

                let body = ''
                req.on('data', (data)=> {
                    body+= data
                })

                return req.on('end', ()=>{
                    users[key] = JSON.parse(body).name
                    res.writeHead(201, {'Content-Type' : 'text/plain; charset=utf-8'})
                    res.end('ok')
                })
            
            }
        } else if (req.method == 'DELETE'){
            if(req.url.startsWith('/user/')){
                const key = req.url.split('/')[2]
                delete users[key]
                res.writeHead(201, {'Content-Type' : 'text/plain; charset=utf-8'})
                return res.end('ok')
            }
        }

        //위 if-else 문 어디에도 걸리지 않을 경우 
        //아래 코드를 실행
        res.writeHead(404)
        return res.end('NOT FOUND')

    } catch(err) { 
        //서버 실행상의 에러를 처리 
        // : 404 에러 등은 여기서 처리 안됨
        console.error(error)
        res.writeHead(500, {'Content-Type' : 'text/html; charset=utf-8'})
        return res.end(err.message)
    } 
}).listen(8090, ()=>{
    console.log('Server is ready in port 8090')
})