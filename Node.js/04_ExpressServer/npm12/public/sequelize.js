getUsers();
getComments();

document.getElementById('user-form').addEventListener('submit', async (e)=>{
    e.preventDefault()
    const name = e.target.username.value
    const age = e.target.age.value
    const married = e.target.married.checked
    
    if(!name) {return alert('이름을 입력하세요')}
    if(!age) {return alert('나이를 입력하세요')}

    try{
        await axios.post('/users', {name, age, married})
        //레코드 추가 후, user-list를 새로고침 
        //레코드 조최 후 행단위로 추가하는 함수 -> getUsers()
        getUsers()
    } catch(err) { console.error(err) }

    e.target.username.value = ''
    e.target.age.value = ''
    e.target.married.checked = false

}) //사용자 등록

document.getElementById('comment-form').addEventListener('submit', async (e)=>{
    e.preventDefault()
    const id = e.target.userid.value
    const comment = e.target.comment.value

    if(!id) { return alert('아이디를 입력하세요') } 
    if(!comment) { return alert('내용을 입력하세요') }

    try {
        await axios.post('/comments', {id, comment})
        console.log('어웨이트 끝남')
        getComments();
    } catch(err) { console.error(err)}

    e.target.userid.value = ''
    e.target.comment.value = ''
}) //댓글 등록


async function getUsers() {
    try{
        const res = await axios.get('/users')
        const users = res.data
        const tbody = document.querySelector('#user-list tbody')
        tbody.innerHTML = ''

        users.map(function(user){
            const row = document.createElement('tr')
            let td = document.createElement('td')
            td.textContent = user.id
            row.appendChild(td)
            
            td = document.createElement('td')
            td.textContent = user.name
            row.appendChild(td)

            td = document.createElement('td')
            td.textContent = user.age
            row.appendChild(td)

            td = document.createElement('td')
            td.textContent = user.married ? '기혼' : '미혼'
            row.appendChild(td)

            tbody.appendChild(row) //완성된 tr을 tbody에 추가 
        })

    } catch(err) { }
}

async function getComments() {
    try{
        const res = await axios.get('/comments')
        const comments = res.data
        const tbody = document.querySelector('#comment-list tbody')
        tbody.innerHTML = ''

        comments.map(function(comment){
            const row = document.createElement('tr')
            let td = document.createElement('td')
            td.textContent = comment.id
            row.appendChild(td)
            
            td = document.createElement('td')
            td.textContent = comment.User.name 
            //comment에 include한 User.name
            row.appendChild(td)

            td = document.createElement('td')
            td.textContent = comment.comment
            row.appendChild(td)

            tbody.appendChild(row) //완성된 tr을 tbody에 추가 

            const edit = document.createElement('button');
            edit.textContent = '수정';

            const remove = document.createElement('button')
            remove.textContent = '삭제'

            td = document.createElement('td')
            td.appendChild(edit)   //버튼을 td에 추가
            row.appendChild(td);    // td를 tr에 추가

            td = document.createElement('td')
            td.appendChild(remove)   
            row.appendChild(td);    

            tbody.append(row);
        })

    } catch(err) { }
}