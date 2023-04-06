function solution(progresses, speeds) {
  // 기능은 진도가 100프로일 떄 서비스에 반영됨
  // 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 같이 배포
  // 작업의 개수는 100개 이하, 하루에 1프로씩 작업 가능

  let answer = [];
  while (progresses.length) {
    let count = 0;

    for (let i = 0; i < progresses.length; i++) {
      progresses[i] += speeds[i];
    }

    while (progresses[0] >= 100) {
      progresses.shift();
      speeds.shift();
      count += 1;
    }

    if (count > 0) {
      answer.push(count);
    }
  }
  return answer;
}

console.log(solution([93, 30, 55], [1, 30, 5]));
console.log(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]));
