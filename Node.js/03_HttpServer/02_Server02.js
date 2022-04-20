const http = require('http')

const server = http.createServer( (req, res) => {
    res.write('<h1>Hello World!</h1>')
    res.write('<h2>Welcome to my NodeJS server :) </h2>')
    res.write('<h3>This is my Second Server</h3>')
});
server.listen(8090);
server.on('listening', ()=>{
    console.log('Server is ready in port 8090')
})
server.on('error', (error) => {
    console.log(error)
})