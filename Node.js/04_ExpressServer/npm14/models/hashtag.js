const Sequelize = require('sequelize')

module.exports = class Hashtag extends Sequelize.Model{
    static init(sequelize){
        return super.init({
            title: {type: Sequelize.STRING(20), allowNull:false, unique:true}
        },{
        sequelize,
        timestamp: false,
        underscored: false,
        modelName: 'Hashtag',
        tableName: 'hashtags',
        paranoid: false,
        charset: 'utf8mb4', 
        collate: 'utf8mb4_general_ci'
        })
    }
    
    static associate(db){
        db.Hashtag.belongsToMany(db.Post, {through: 'PostHashtag'})
    }
    //posts 테이블과 n:n 관계
}