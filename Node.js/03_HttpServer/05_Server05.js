const http = require('http')
const fs = require('fs').promises

const users = {} 
//서버가 종료될 때까지 값이 유지되는 변수

http.createServer( async (req, res)=>{
    try { 
        if(req.method == 'GET') {
            if(req.url === '/') {
                //첫번째 페이지로 갈 때
                const data = await fs.readFile('./05_Front.html')
                res.writeHead(200, {'Content-Type' : 'text/html; charset=utf-8'})
                res.end(data)
                return res.end(data)
                //파일 내용 전송 후 async(req, res)=>{} 함수가 
                //종료되도록 return
                //return이 없으면 try문 아래에 400 NOTFOUND도 같이 실행되게 됨
            } else if(req.url === '/users'){

            }
        } else if (req.method == 'POST'){
            if(req.url === '/user') {

            } 
        } else if (req.method == 'PUT') {

        } else if (req.method == 'DELETE'){

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