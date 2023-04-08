const combination = (combinationMap, count, key, elements, score) => {
  if (count === 4) {
    if (!combinationMap[key]) {
      combinationMap[key] = [score];
    } else {
      combinationMap[key].push(score);
    }
    return;
  }

  combination(
    combinationMap,
    count + 1,
    key + elements[count],
    elements,
    score,
  );
  combination(combinationMap, count + 1, key + '-', elements, score);
};

const sortCombinationMap = (combinationMap) => {
  for (let key in combinationMap) {
    combinationMap[key] = combinationMap[key].sort((a, b) => a - b);
  }
};

function solution(infos, queries) {
  const combinationMap = new Map();

  infos.forEach((info) => {
    const elements = info.split(' ');
    const score = parseInt(elements.pop());
    combination(combinationMap, 0, '', elements, score);
  });

  sortCombinationMap(combinationMap);

  return queries.map((query) => {
    const elements = query.replace(/ and /g, ' ').split(' ');
    const score = parseInt(elements.pop());

    const key = elements.join('');
    const scores = combinationMap[key];

    if (scores) {
      let left = 0;
      let right = scores.length;

      while (left < right) {
        const mid = parseInt((left + right) / 2);
        if (scores[mid] >= score) {
          right = mid;
        } else if (scores[mid] < score) {
          left = mid + 1;
        }
      }
      return scores.length - left;
    } else {
      return 0;
    }
  });
}

console.log([
  'java backend junior pizza 150',
  'python frontend senior chicken 210',
  'python frontend senior chicken 150',
  'cpp backend senior pizza 260',
  'java backend junior chicken 80',
  'python backend senior chicken 50',
]);
