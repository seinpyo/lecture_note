const Sequelize = require('sequelize')
const { sequelize } = require('.')

module.exports = class Comment extends Sequelize.Model {
    static init(sequelize){
        return super.init({
            //id 필드는 이 테이블에 PK로 자동 생성됨
            //누가 댓글을 썼는지 저장할 필드 : commenter 
            //외래키 설정도 자동으로 가능 => user 테이블의 id가 복사 되어 현재테이블의 필드로 삽입 생성
            //=> 외래키로 설정하기만 하면 됨 (associate에서)
            comment: { type: Sequelize.STRING(100), allowNull: false},
            create_at: { type: Sequelize.DATE, allowNull: true, defaultValue: Sequelize.NOW}
        }, {
            sequelize,
            timestamp: false,
            underscored: false,
            modelName: 'Comment',
            tableNameName: 'comments',
            paranoid: false,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci'
        })
    }

    static associate(db){
        db.Comment.belongsTo(db.User, { foreignKey:'commenter', targetKey: 'id'});
        //Comment 테이블의 commenter 필드가 User테이블의 id를 참조하도록 설정
    }
}