function solution(weights) {
  let answer = 0;
  const calculations = [1, 3 / 2, 2, 4 / 3];
  const weightMap = new Map();

  weights.sort((a, b) => b - a);

  weights.forEach((weight) => {
    calculations.forEach((calc) => {
      let calcResult = weight * calc;
      if (weightMap.has(calcResult)) {
        answer += weightMap.get(calcResult);
      }
    });
    if (weightMap.has(weight)) {
      weightMap.set(weight, weightMap.get(weight) + 1);
    } else {
      weightMap.set(weight, 1);
    }
  });
  return answer;
}
