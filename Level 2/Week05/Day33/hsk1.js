function solution(p) {
  const checkBalance = (p) => {
    let stack = [];
    for (const char of p) {
      if (char === '(') {
        stack.push('(');
      } else {
        if (stack.length === 0) {
          return false;
        }
        stack.pop();
      }

      return true;
    }
  };

  const reversed = (p) => {
    const result = [];
    for (const char of p) {
      if (char === '(') {
        result.push(')');
      } else {
        result.push('(');
      }
    }
    return result.join('');
  };

  const solve = (p) => {
    if (!p) return '';

    let i = 0;
    let j = 0;

    while (i < p.length) {
      if (p[i] === '(') {
        j += 1;
      } else {
        j -= 1;
      }

      if (!j) break;
      i += 1;
    }

    const u = p.slice(0, i + 1); // 균형잡힌 문자열
    const v = p.slice(i + 1);

    // u가 올바른 괄호 문자열
    if (checkBalance(u)) {
      return u + solve(v);
    }

    return `(${solve(v)})${reversed(u.slice(1, -1))}`;
  };

  return solve(p);
}

console.log(solution('(()())()'));
console.log(solution(')('));
console.log(solution('()))((()'));
