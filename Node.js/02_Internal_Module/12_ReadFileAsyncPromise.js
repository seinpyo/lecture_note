const fs = require('fs').promises

console.log('start')
fs.readFile('./readMe1.txt')
.then((data) => {
    console.log('first : ', data.toString())
    return fs.readFile('./readMe2.txt')
})
.then((data) => {
    console.log('second : ', data.toString())
    return fs.readFile('./readMe3.txt')
})
.then((data) => {
    console.log('third : ', data.toString())
    console.log('finish')
})
.catch((err) => {
    console.error(err)
})


//node 12_ReadFileAsyncPromise.js