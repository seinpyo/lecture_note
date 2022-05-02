const http = require('http')
const fs = require('fs').promises

http.createServer( async (req, res)=>{
    try { 
        const data = await fs.readFile('./04_Server.html')
        res.writeHead(200, {'Content_Type':'text/html; charset=utf-8'})
        res.writeHead
        res.end(data)
    } catch {
        console.error(err)
        res.writeHead(500, {'Content_Type':'text/html; charset=utf-8'})
        res.end(err.message)
    }
}).listen(8081, ()=>{
    console.log('Server is ready in port 8081')
})