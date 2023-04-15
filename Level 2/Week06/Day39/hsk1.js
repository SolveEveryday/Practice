function solution(N, road, K) {
  const graph = Array.from(Array(N + 1), () => []);
  road.forEach(([a, b, time]) => {
    graph[a].push([b, time]);
    graph[b].push([a, time]);
  });

  const times = new Array(N + 1).fill(Number.POSITIVE_INFINITY);
  const queue = [[1, 0]];

  times[0] = 0;
  times[1] = 0;

  while (queue.length) {
    const [city, time] = queue.shift();

    for (const [nextCity, nextTime] of graph[city]) {
      if (times[nextCity] > times[city] + nextTime) {
        times[nextCity] = times[city] + nextTime;
        queue.push([nextCity, nextTime]);
      }
    }
  }

  return times.filter((time) => time <= K).length - 1;
}

console.log(
  solution(
    5,
    [
      [1, 2, 1],
      [2, 3, 3],
      [5, 2, 2],
      [1, 4, 2],
      [5, 3, 1],
      [5, 4, 2],
    ],
    3,
  ),
);
console.log(
  solution(
    6,
    [
      [1, 2, 1],
      [1, 3, 2],
      [2, 3, 2],
      [3, 4, 3],
      [3, 5, 2],
      [3, 5, 3],
      [5, 6, 1],
    ],
    4,
  ),
);
