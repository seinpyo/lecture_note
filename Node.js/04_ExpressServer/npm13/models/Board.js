const Sequelize = require('sequelize')

module.exports = class Board extends Sequelize.Model {
    static init(sequelize) {
        return super.init ({
            subject: {type: Sequelize.STRING(100), allowNull:false},
            content: {type: Sequelize.STRING(1000), allowNull:false},
            readcount: {type: Sequelize.INTEGER.UNSIGNED, allowNull:false, defaultValue: 0},
            createdAt: {type: Sequelize.DATE, allowNull:true, defaultValue: Sequelize.NOW},
            filename: {type: Sequelize.STRING(100), allowNull:true},
            realfilename: {type: Sequelize.STRING(100), allowNull:true}
        }, {
            sequelize,
            timestamps: false, underscored: false,
            modelName: 'Board', tableName: 'boards',
            paranoide: false,
            charset: 'utf8mb4', collate: 'utf8mb4_general_ci'
        })
    }

    static associate(db){
        db.Board.belongsTo(db.Member, {foreignKey: 'writer', targetKey: 'userid'})
        db.Board.hasMany( db.Reply, {
            foreignKey: 'boardnum', sourceKey: 'id', onDelete:'cascade' 
        })
    }
}
