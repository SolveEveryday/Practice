function solution(numbers, target) {
  let answer = 0;

  let dfs = (sum, index) => {
    if (index === numbers.length) {
      if (sum === target) {
        answer += 1;
      }
      return;
    }
    dfs(sum + numbers[index], index + 1);
    dfs(sum - numbers[index], index + 1);
  };

  dfs(0, 0);

  return answer;
}

console.log(solution([1, 1, 1, 1, 1], 3));
console.log(solution([4, 1, 2, 1], 4));
