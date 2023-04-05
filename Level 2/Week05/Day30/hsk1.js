function solution(word) {
  const chars = ['', 'A', 'E', 'I', 'O', 'U'];

  const result = [];
  const recursion = (n, char) => {
    if (n === 0) {
      result.push(char);
      return;
    }

    for (let i = 0; i < 6; i++) {
      recursion(n - 1, `${char}${chars[i]}`);
    }
  };

  recursion(5, '');
  return [...new Set(result)].sort().indexOf(word);
}

console.log(solution('AAAAE'));
console.log(solution('AAAE'));
console.log(solution('I'));
console.log(solution('EIO'));
