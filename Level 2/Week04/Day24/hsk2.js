function solution(board) {
  const row = board.length;
  const col = board[0].length;
  const visited = Array.from(Array(row), () => Array(col).fill(false));

  const bfs = (startX, startY) => {
    const dx = [-1, 1, 0, 0];
    const dy = [0, 0, -1, 1];
    const queue = [[startX, startY]];

    let count = 0;
    visited[startX][startY] = true;

    while (queue.length) {
      const size = queue.length;
      for (let k = 0; k < size; k++) {
        const [x, y] = queue.shift();

        for (let i = 0; i < 4; i++) {
          let nx = x + dx[i];
          let ny = y + dy[i];

          while (
            nx >= 0 &&
            ny >= 0 &&
            nx < row &&
            ny < col &&
            board[nx][ny] !== 'D'
          ) {
            nx += dx[i];
            ny += dy[i];
          }

          nx -= dx[i];
          ny -= dy[i];

          if (board[nx][ny] === 'G') {
            return count + 1;
          }

          if (!visited[nx][ny]) {
            visited[nx][ny] = true;
            queue.push([nx, ny]);
          }
        }
      }
      count += 1;
    }
    return -1;
  };

  for (let i = 0; i < row; i++) {
    for (let j = 0; j < col; j++) {
      if (board[i][j] === 'R') {
        return bfs(i, j);
      }
    }
  }
}

console.log(solution(['...D..R', '.D.G...', '....D.D', 'D....D.', '..D....']));
console.log(solution(['.D.R', '....', '.G..', '...D']));
