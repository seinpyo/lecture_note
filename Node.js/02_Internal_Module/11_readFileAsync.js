const fs = require('fs')


// fs.readFile('./readMe1.txt', (err,data)=> {
//     if(err) {throw err}
//     console.log('first : ', data.toString())
// })

// fs.readFile('./readMe2.txt', (err,data)=> {
//     if(err) {throw err}
//     console.log('second : ', data.toString())
// })

// fs.readFile('./readMe3.txt', (err,data)=> {
//     if(err) {throw err}
//     console.log('third : ', data.toString())
// })

console.log('시작')

fs.readFile('./readMe1.txt', (err,data)=> {
    if(err) {throw err}
    console.log('first : ', data.toString())

    fs.readFile('./readMe2.txt', (err,data)=> {
        if(err) {throw err}
        console.log('second : ', data.toString())
        
        fs.readFile('./readMe3.txt', (err,data)=> {
                if(err) {throw err}
            console.log('third : ', data.toString())
            console.log('끝')
        })        
    })
})







//node 11_readFileAsync.js