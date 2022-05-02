const Sequelize = require("sequelize")

module.exports = class Post extends Sequelize.Model{
    static init(sequelize){
        return super.init({
            content: {type: Sequelize.STRING(140), allowNull: false},
            img: {type: Sequelize.STRING(200), allowNull: true}
        }, {
            sequelize,
            timestamp: true,
            underscored: false,
            modelName: 'Post',
            tableName: 'posts',
            paranoid: false,
            charset: 'utf8mb4', 
            collate: 'utf8mb4_general_ci'
        })
    }

    static associate(db){
        db.Post.belongsTo(db.User)
        //user:post 가 1:n관계로 연결 - post 테이블의 기본키 컬럼이 user테이블의 기본키 컬럼
        //컬럼을 참조함

        db.Post.belongsToMany(db.Hashtag, {through: 'PostHashtag'})
    }
}