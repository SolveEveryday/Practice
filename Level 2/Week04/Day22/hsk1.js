// 0이 적힌 블록들이 설치된 도로
// n * 2 번째 위치에 설치
// result.push('약수 중 가장 큰 값');

function solution(begin, end) {
  let result = [];
  for (let i = begin; i <= end; i++) {
    if (i === 1) {
      result.push(0);
      continue;
    }

    let maxDivisor = 1;
    for (let j = 2; j <= i / 2; j++) {
      if (i % j === 0) {
        maxDivisor = Math.max(maxDivisor, j);
      }
    }
    result.push(maxDivisor);
  }

  return result;
}

solution(1, 10);