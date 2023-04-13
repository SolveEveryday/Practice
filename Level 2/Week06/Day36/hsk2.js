function solution(sequence, k) {
  // 부분수열의 합 k, 합이 k -> 여러개라면 길이가 짧은 수열
  // 연속되어야함

  let result = [];
  for (let i = 1; i <= sequence.length; i++) {
    // 길이 1부터 sequence의 길이까지 부분 수열의 길이가 될 수 있음
    for (let j = 0; j < sequence.length; j++) {
      if (i + j > sequence.length) {
        continue;
      }

      let seq = sequence.slice(j, j + i);
      let sum = seq.reduce((acc, cur) => acc + cur, 0);
      if (sum === k) {
        result.push([j, j + i - 1]);
      }
    }
  }

  return result.sort((a, b) => a.length - b.length)[0];
}

console.log(solution([1, 2, 3, 4, 5], 7));
console.log(solution([1, 1, 1, 2, 3, 4, 5], 5));
console.log(solution([2, 2, 2, 2, 2], 6));
