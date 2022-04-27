const Sequelize = require('sequelize')

module.exports = class Reply extends Sequelize.Model{
    static init(sequelize){
        return super.init({
            writer: {type: Sequelize.STRING(30), allowNull:false},
            content: {type: Sequelize.STRING(200), allowNull:false},
            createdAt: {type: Sequelize.DATE, allowNull:true, defaultValue: Sequelize.NOW}
        }, {
            sequelize,
            timestamps: false, 
            modelName: 'Reply', tableName: 'replys',
            paranoide: false,
            charset: 'utf8mb4', collate: 'utf8mb4_general_ci'
        })
    }
    static associate(db){
        db.Reply.belongsTo(db.Board, {foreignKey:'boardnum', targetKey:'id'})
    }
}