function solution(number, k) {
  // k개 수를 제거했을 때 가장 큰 숫자 구하기

  const result = [];
  for (let i = 0; i < number.length; i++) {
    while (k > 0 && result[result.length - 1] < number[i]) {
      k -= 1;
      result.pop();
    }
    result.push(number[i]);
  }

  return result.join('');
}

console.log(solution('1924', 2));
console.log(solution('1231234', 3));
console.log(solution('4177252841', 4));
