function solution(board) {
  const row = board.length;
  const col = board[0].length;
  const visited = Array.from(Array(row), () => Array(col).fill(false));

  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];

  let canMove = (x, y, i) => {
    const nx = x + dx[i];
    const ny = y + dy[i];

    return nx >= 0 && ny >= 0 && nx < row && ny < col && board[nx][ny] !== 'D';
  };

  const bfs = (startX, startY) => {
    const queue = [[startX, startY, 0]];

    visited[startX][startY] = true;

    while (queue.length) {
      const [x, y, count] = queue.shift();

      if (board[x][y] === 'G') {
        return count;
      }

      for (let i = 0; i < 4; i++) {
        let nx = x;
        let ny = y;

        while (canMove(nx, ny, i)) {
          nx += dx[i];
          ny += dy[i];
        }

        if (!visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.push([nx, ny, count + 1]);
        }
      }
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
