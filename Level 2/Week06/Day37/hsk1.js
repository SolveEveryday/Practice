function solution(n) {
  let fibonacci = [0, 1];
  for (let i = 2; i <= n; i++) {
    fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1234567;
  }

  return fibonacci[n];
}

console.log(solution(3));
console.log(solution(5));
