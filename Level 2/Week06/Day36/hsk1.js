function solution(maps) {
  const row = maps.length
  const col = maps[0].length
  const visited = Array.from(Array(row), ()=>Array(col).fill(false))
  const answer = []
  
  const bfs = (startX, startY) => {
      const queue = [[startX, startY]]
      const dx = [-1, 1, 0, 0]
      const dy = [0, 0, -1, 1]
      
      let days = parseInt(maps[startX][startY], 10)
      visited[startX][startY] = true
      
      while(queue.length){
          const [x, y] = queue.shift()
                      
          for(let i = 0; i< 4; i++){
              const nx = x + dx[i]
              const ny = y + dy[i]
              
              if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue
              if(visited[nx][ny] || maps[nx][ny] === 'X') continue
              
              visited[nx][ny] = true
              queue.push([nx, ny])
              days += parseInt(maps[nx][ny], 10)
          }     
      }
      answer.push(days)
  }
  
  for(let i = 0; i < row; i++){
      for(let j = 0; j < col; j++){
          if(visited[i][j] || maps[i][j] === 'X') continue
          bfs(i, j)
      }
  }
  
  if(answer.length === 0) return [-1]
  return answer.sort((a, b) => a - b);
}

console.log(solution(["X591X","X1X5X","X231X", "1XXX1"]))
console.log(solution(["XXX","XXX","XXX"]))