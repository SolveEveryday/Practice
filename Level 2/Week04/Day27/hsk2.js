function solution(s) {
  return s
    .split(' ')
    .map((word) => {
      let firstChar = word.charAt(0).toUpperCase();
      let withoutFirstChar = word.substring(1).toLowerCase();
      return firstChar + withoutFirstChar;
    })
    .join(' ');
}

console.log(solution('3people unFollowed me'));
console.log(solution('for the last week'));
