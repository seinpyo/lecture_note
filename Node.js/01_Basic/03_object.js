// const product = {name:'냉장고', 제조:'대한민국'}
// console.log(product['제조'])
// console.log(product.name);
// console.log(product)

// const product2 = {}
// console.log(product2)

// const object = {
//     userNumber:273,
//     userString:'문자열',
//     userBoolean: true,
//     userArray:[52,123,253,346],
//     method: function(){
//         console.log('멤버 함수를 실행 합니다.')
//     }
// }

// object.method(); //함수 이르메 괄호를 붙여 함수 내용 실행
// console.log(object.method)
// console.log(object.method()) 


// const person={
//     name: '홍길동',
//     eat: function(food) {
//         console.log(`'${this.name}' 이가 ${food} 을/를 먹어요`)
//     }
// }

// person.eat('스파게티')

const product = {
    name: 'Eclipse & Tomcat',
    price: 'free',
    language: '한국어',
    suppertOS: 'win32/64',
    subscruption:true
}

for(let key in product) {
    let output = `${key} : ${product[key]}`
    console.log(output)
}
