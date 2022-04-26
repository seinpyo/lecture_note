const express = require('express')
const User = require('../models/user') 
const Comment = require('../models/comment')

const router = express.Router()

router.get('/', (req, res) => {
    res.render('sequelize', {}) //서버 실행 첫페이지 : sequelize.html 
})


module.exports = router; 