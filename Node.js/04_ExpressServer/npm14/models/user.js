const Sequelize = require("sequelize")

module.exports = class User extends Sequelize.Model{
    static init(sequelize){
        return super.init({
            email: {type: Sequelize.STRING(50), allowNull: true, unique: true},
            //unique값은 중복값을 허용하지 않지만 null 값은 허용한다
            nick: {type: Sequelize.STRING(30), allowNull: false},
            password: {type: Sequelize.STRING(200), allowNull: false},
            provider: {type: Sequelize.STRING(20), allowNull: false, defaultValue:'local'},
            //↑ 다른 사이트 계정으로 로그인 할 수 있도록 만드는 컬럼
            snsid: {type: Sequelize.STRING(30), allowNull: true}
            //↑ provider에서 지정된 사이트의 아이디 (local로 가입할 경우 null)
        }, {
            sequelize,
            timestamp: true,
            underscored: false,
            modelName: 'User',
            tableName: 'users',
            paranoid: true, //데이터를 실제로 삭제하지 않고 삭제한 시간을 기록
            charset: 'utf8mb4', 
            collate: 'utf8mb4_general_ci'
        })
    }

    static associate(db){
        db.User.hasMany(db.Post)
        //user:post 가 1:n관계로 연결 - post 테이블의 writer컬럼이 user테이블의 userid
        //컬럼을 참조함
        db.User.belongsToMany(db.User, {
            foreignKey:'followingId', as:'Followings', through:'Follow'})
        db.User.belongsToMany(db.User, {
            foreignKey:'followerId', as:'Followers', through:'Follow'})
    }
}