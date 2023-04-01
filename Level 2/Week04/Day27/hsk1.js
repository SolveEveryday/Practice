function solution(n, a, b) {
  // 게임 참가자 수 n,
  // a, b 경쟁자 번호

  let answer = 0;

  while (a !== b) {
    a = Math.ceil(a / 2);
    b = Math.ceil(b / 2);
    answer += 1;
  }

  return answer;
}

console.log(solution(8, 4, 7));
