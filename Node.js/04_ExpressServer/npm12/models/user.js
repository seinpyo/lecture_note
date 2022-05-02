const Sequelize = require('sequelize');

//
module.exports = class User extends Sequelize.Model{
    //테이블을 생성하고 초기화하는 함수 
    static init( sequelize ){
        return super.init({
            //init 함수에 각 필드이름, 속성이 객체로 전달
            //각 필드를 객체 멤버 형식으로 나열 
            name: { type: Sequelize.STRING(20), allowNull: false, unique: false },
            age: { type: Sequelize.INTEGER.UNSIGNED, allowNull: false },
            married: { type: Sequelize.BOOLEAN, allowNull: true },
            comment: { type: Sequelize.TEXT, allowNull: true },
            created_at: { type: Sequelize.DATE, allowNull: true, defaultValue: Sequelize.NOW }
            //따로 기술하지 않아도 auto increment 필드가 추가됨
        },{
            //테이블의 옵션들이 멤버 형식으로 정의됨
            sequelize,
            timestamp: false, //속성이 true이면 createAt, updateAt 필드를 자동 생성
            underscored: false, //예시 : createAt을 create_at으로 바꿔줌
            modelName: 'User', //sequelize가 사용할 테이블(모델) 이름
            tableNameName: 'users', //DB의 실제 테이블 이름
            paranoid: false, // deletedAt(실제 데이터를 삭제하지 않고 시간만 기록) 필드 자동생성
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci'
        });
    }

    //테이블관 관계 설정 함수
    static associate(db){
        db.User.hasMany(db.Comment); //1:n 관계로 설정
        //User 모델의 id 필드를 Comment모델에 commenter필드로 복사, 관계를 설정
        
    }
};