const express = require('express')
const Member = require('../models/Member') 
const Board = require('../models/Board')
const Reply = require('../models/Reply')
const router = express.Router();

router.get('/', (req, res) => {
    const loginUser = req.session.loginUser
    res.render('main', {loginUser})
})

router.get('/boardlist', (req, res) => {
    
})

module.exports = router;