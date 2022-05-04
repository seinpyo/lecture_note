let a = "HelloWorld"
console.log(a.match(/Hello|Crow/g))

a = "Welcome Crow"
console.log(a.match(/Hello|Crow/g))


a = "Life is too short"
console.log(a.match(/^Life/g))
console.log(a.match(/short$/g))


a = 'no class are all'
console.log(a)
console.log('\\b', a.match(/\bclass\b/g))
console.log('\\B', a.match(/\Bclass\B/g))

a = 'the declassified algorithm'
console.log(a)
console.log('\\b', a.match(/\bclass\b/g))
console.log('\\B', a.match(/\Bclass\B/g))




//node 02_Regix02.js