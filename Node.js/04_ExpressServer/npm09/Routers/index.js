const express = require('express')
const router = express.Router()

router.get('/', (req, res) => {
    res.send("<h1> hello, Express Router - index - '/' </h1>")
})

router.get('/about', (req, res) => {
    res.send("<h1> hello, Express Router - index - '/about' </h1>")
})

module.exports = router;

