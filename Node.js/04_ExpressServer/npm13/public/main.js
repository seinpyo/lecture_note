getBoard_list()

async function getBoard_list(){
    try{
        const res = await axios.get('/boards/boardlist')
        const boards = res.data

        const tbody = document.querySelector('#board-list tbody')
        tbody.innerHTML=''

        boards.map (async function(board){
            const row = document.createElement('tr')

            let td = document.createElement('td')
            td.textContent = board.id
            td.id = 'boardnum'
            row.append(td)

            td = document.createElement('td')
            td.textContent = board.subject
            td.innerHTML = tContent
            row.appendChild(td)

            td = document.createElement('td')
            td.textContent = board.writer
            td.id = 'writer'
            row.appendChild(td)

            td = document.createElement('td')
            td.textContent = board.readCount
            td.id = 'readCount'
            row.appendChild(td)
            
            tbody.appendChild(row)
        })
    } catch(err) {}
}