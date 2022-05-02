const Sequelize = require('sequelize')

module.exports = class Member extends Sequelize.Model{
    static init(sequelize){
        return super.init({
            userid: {
                type: Sequelize.STRING(30), allowNull:false,  
                primaryKey:true, unique:true
            },
            pwd: {type: Sequelize.STRING(30), allowNull:false},
            name: {type: Sequelize.STRING(30), allowNull:false},
            phone: {type: Sequelize.STRING(30), allowNull:false},
            email: {type: Sequelize.STRING(50), allowNull:true},
            createdAt: {type: Sequelize.DATE, allowNull:true, defaultValue: Sequelize.NOW}
        }, {
            sequelize,
            timestamps: false, underscored: false,
            modelName: 'Member', tableName: 'members',
            paranoide: false,
            charset: 'utf8mb4', collate: 'utf8mb4_general_ci'
        })
    }
    static associate(db){ db.Member.hasMany(db.Board , {
        foreignKey:'writer', sourceKey:'userid', onDelete:'cascade'
    })}
} 