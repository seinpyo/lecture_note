const express = require('express');
const User = require('../models/user');
const Comment = require('../models/comment');

const router = express.Router();

router.post('/', async (req, res, next)=>{
    try{
        const comment = await Comment.create({
            commenter: req.body.id,
            comment: req.body.comment,
        });
        res.json(comment);
    }catch(err){
        console.error(err);
        next(err);
    }
});


router.get('/', async (req, res, next)=>{
    try{
        const comments = await Comment.findAll({
            include:{
                model:User,
            }
        });
        res.json(comments);
    }catch(err){
        console.error(err);
        next(err);
    }
});

router.get('/search/:id', async (req, res) => {
    try{
        const result = await Comment.findAll({
            where : {commenter: req.params.id},
            include: {model: User}
        })
        res.json(result);
    } catch(err) { console.error(err); next(err); }
})

router.patch('/update/:id', async (req, res) => {
    try {
    const  result = await Comment.update(
        { comment: req.body.comment }, { where: {id: req.params.id }}
        )
        res.json(result);
    } catch(err) { console.error(err); next(err); }
})


router.delete('/delete/:id', async(req, res) => {
    try{
        await Comment.destroy( { where : {id: req.params.id} } )
    } catch(err) { console.error(err); next(err) }
})


module.exports = router;