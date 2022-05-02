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

// const product = {
//     name: 'Eclipse & Tomcat',
//     price: 'free',
//     language: '한국어',
//     suppertOS: 'win32/64',
//     subscruption:true
// }

// for(let key in product) {
//     let output = `${key} : ${product[key]}`
//     console.log(output)
//}


// const student = {
//     이름 : '홍길동',
//     국어 : 92,
//     수학 : 98, 
//     영어 : 96,
//     과학 : 98
// }


// let write = '';
// write += '이름 : ' + student.이름 + '\n';
// write += '국어 : ' + student.국어 + '\n';
// write += '수학 : ' + student.수학 + '\n';
// write += '영어 : ' + student.영어 + '\n';
// write += '과학 : ' + student.과학 + '\n';


// write = '';
// with(student) {
//     write += '이름 : ' + 이름 + '\n';
//     write += '국어 : ' + 국어 + '\n';
//     write += '수학 : ' + 수학 + '\n';
//     write += '영어 : ' + 영어 + '\n';
//     write += '과학 : ' + 과학 + '\n';
// }


// student.이름 = '홍길동';
// student.취미 = '악기';
// student.특기 = '프로그래밍';

// student.toString = function(){
//     for(let key in this) { //자신의 객체를 for문에 적용
//         if(key!='toString')
//             console.log(`${key} : ${student[key]}`)
//     }
// }


// delete(student.특기)
// student.toString()
// console.log('\n');


// let student1 = { 이름: '홍길동' }
// let student2 = { 이름: '홍길동', 성별: '남' }
// let student3 = { 이름: '홍길동', 성별: '남', 나이:20 }  


// function Student(name, korean, math, english, science) {
//     this.name = name;
//     this.korean = korean;
//     this.math = math;
//     this.english = english;
//     this.science = science;

//     this.getSum = function(){
//         return this.korean+this.math+this.english+this.science
//     }
//     this.getAvg = function(){
//         return this.getSum() / 4;
//     }
//     this.toString= function(){
//         return this.name + ',    ' + this.getSum() + ',    ' + this.getAvg()
//     }
// }

// const std1 = new Student('홍길동', 98,76,45,67);
// const std2 = new Student('홍길남', 82,61,55,71);
// const std3 = new Student('홍길서', 83,77,98,63);

// console.log(std1.toString())
// console.log(std2.toString())
// console.log(std3.toString())

// function Student(name, korean, math, english, science) {
//         this.name = name;
//         this.korean = korean;
//         this.math = math;
//         this.english = english;
//         this.science = science;
// }

// let std1 = new Student('홍길동', 65, 88, 97, 89)
// //위 명령이 실행될 때 프로토타입의 사본이 std1에 저장되면서 새로운 객체를 이룬다.

// //만약 생성자 함수에 추가로 멤버 변수 또는 멤버 메서드를 추가하려고 하면 
// Student.prototype.basicLanguage = 100;
// Student.prototype.getSum = function(){
//     return this.korean + this.math + this.english + this.science + this.basicLanguage
// }
// Student.prototype.getAvg = function() {
//     return this.getSum()/5
// }


// //새로 추가된 멤버변수 basicLanguage 변수의 값을 전달인수로 전달해 초기화 할 수 는 없다
// let std2 = new Student('홍길동', 65, 88, 97, 89); //basicLanguage의 값은 100
// console.log(std2.basicLanguage)


// std1.toString() = function(){ 
//     return this.name + ',    ' + this.getSum() + ',    ' + this.getAvg()
// } // std1 (지정한 객체)에만 toString 메소드 추가 


// Student.prototype.toString = function(){
//     return this.name + ',    ' + this.getSum() + ',    ' + this.getAvg()
// } // 이 명령이 실행된 후 Student 생성자를 이용해 만들어지는 모든 객체에 toString 메소드 추가


// function Rectangle(w, h) {
//     let width = w;
//     let height = h;
//     this.getWidth = function() {return width}
//     this.getHeight = function() {return height}
//     this.setWidth = function(value) {width = value}
//     this.setHeight = function(value) {height = value}
// }

// Rectangle.prototype.getArea = function() {
//     return this.getWidth() * this.getHeight()
// }

// let rectangle = new Rectangle(5, 7) 
// rectangle.setWidth(8)
// console.log('area : ' + rectangle.getArea())
// console.log('\n')

// //Rectangle 생성자를 상속

// function Square(length) {
//     this.base = Rectangle; //전달된 length 값을 base 생성자인 w,h에 같은 값으로 전달
//     this.base(length, length);
// }

// Square.prototype = Rectangle.prototype //프로토타입도 복사

// let rectangle1 = new Rectangle(5,7)
// let square = new Square(5)

// console.log('rectangle Area : ' + rectangle.getArea())
// console.log('square Area : ' + square.getArea())

let obj = new Object()
console.log(obj) //{}
console.log(obj.toString()) //[object Object]

//toString()의 재정의
let student = {
    name : '홍길동',
    grade : '1',
    toString: function() { return this.name + ' : ' + this.grade }
}

console.log(student)
console.log(student.toString())


//node 03_object.js