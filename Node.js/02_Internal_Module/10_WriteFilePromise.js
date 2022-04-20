const fs = require('fs').promises;

fs.writeFile('./writeMe3.txt', 'Hello How are you?')
.then(()=> {
    return fs.readFile('./writeMe3.txt')
})
.then((data)=> {
    console.log(data.toString())
})
.catch((err) => {
    console.error(err)
})