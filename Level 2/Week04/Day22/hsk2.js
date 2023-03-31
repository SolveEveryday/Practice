// 입력된 수가 짝수라면 2로 나눔
// 입력된 수가 홀수라면 3을 곱하고 1을 더함
// 위의 결과가 1보다 크다면 위 두개 반복

function solution(k, ranges) {
  const collatz = [k];
  while (k !== 1) {
    if (k % 2 === 0) {
      k /= 2;
    } else {
      k *= 3;
      k += 1;
    }
    collatz.push(k);
  }

  const area = [0];
  for (let i = 0; i < collatz.length - 1; i++) {
    let currArea = (collatz[i] + collatz[i + 1] * 1) / 2;
    area.push(area[i] + currArea);
  }

  const result = [];
  for (let [x, y] of ranges) {
    // 시작 점 : x
    // 끝나는 점 : area 배열의 길이 - y
    let start = x;
    let finish = y + area.length - 1;

    if (start === finish) {
      result.push(0);
    } else if (start > finish) {
      result.push(-1);
    } else {
      result.push(area[finish] - area[start]);
    }
  }
  return result.map((value) => value.toFixed(1));
}

console.log(
  solution(5, [
    [0, 0],
    [0, -1],
    [2, -3],
    [3, -3],
  ]),
);
