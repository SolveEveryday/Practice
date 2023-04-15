function solution(n, wires) {
  // v1에서 시작해서 갯수, v2에서 시작하는 개수의 차가 최소
  const tree = Array.from(Array(n + 1), () => []);
  wires.forEach(([v1, v2]) => {
    tree[v1].push(v2);
    tree[v2].push(v1);
  });

  const bfs = (start, disconnectedNode) => {
    const visited = new Array(n + 1).fill(false);
    const queue = [start];

    let count = 1;
    visited[start] = true;

    while (queue.length) {
      const node = queue.shift();

      for (const nextNode of tree[node]) {
        if (visited[nextNode]) continue;
        if (nextNode === disconnectedNode) continue;

        queue.push(nextNode);
        visited[nextNode] = true;
      }
      count += 1;
    }
    return count;
  };

  let result = Number.POSITIVE_INFINITY;
  wires.forEach(([v1, v2]) => {
    result = Math.min(Math.abs(bfs(v1, v2) - bfs(v2, v1)), result);
  });
  return result;
}

console.log(
  solution(9, [
    [1, 3],
    [2, 3],
    [3, 4],
    [4, 5],
    [4, 6],
    [4, 7],
    [7, 8],
    [7, 9],
  ]),
);
console.log(
  solution(4, [
    [1, 2],
    [2, 3],
    [3, 4],
  ]),
);
console.log(
  solution(7, [
    [1, 2],
    [2, 7],
    [3, 7],
    [3, 4],
    [4, 5],
    [6, 7],
  ]),
);
