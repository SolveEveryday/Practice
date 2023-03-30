function solution(n, k, enemy) {
  // 병사 n명
  // enemy[i] 마리의 적
  // 무적권 k번 사용 가능

  let left = 0;
  let right = enemy.length;
  let mid = Math.floor((left + right) / 2);
  while (left <= right) {
    const sortedEnemyUntilMid = enemy.slice(0, mid).sort((a, b) => b - a);

    let attack = k;
    const enemyAfterWar = sortedEnemyUntilMid.reduce((acc, cur) => {
      if (attack > 0) {
        attack -= 1;
        return acc;
      }
      return acc + cur;
    }, 0);

    if (n - enemyAfterWar >= 0 && k >= 0) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }

    mid = Math.floor((left + right) / 2);
  }
  return left - 1;
}

console.log(solution(7, 3, [4, 2, 4, 5, 3, 3, 1]));
console.log(solution(2, 4, [3, 3, 3, 3]));
