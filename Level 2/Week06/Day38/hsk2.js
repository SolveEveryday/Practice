function solution(k, tangerine) {
  // 한 상자에 담으려는 귤 k개
  // 크기가 서로 다른 종류의 수의 최솟값

  const map = new Map();
  tangerine.forEach((num) => {
    if (map.has(num)) {
      map.set(num, map.get(num) + 1);
    } else {
      map.set(num, 1);
    }
  });

  const mapToArr = [...map];
  mapToArr.sort((a, b) => b[1] - a[1]);

  let result = [];
  for (const [size, cnt] of mapToArr) {
    result.push(size);
    if (k > cnt) {
      k -= cnt;
    } else {
      break;
    }
  }
  console.log(result);
  return result.length;
}

console.log(solution(6, [1, 3, 2, 5, 4, 5, 2, 3]));
console.log(solution(4, [1, 3, 2, 5, 4, 5, 2, 3]));
console.log(solution(2, [1, 1, 1, 1, 2, 2, 2, 3]));
