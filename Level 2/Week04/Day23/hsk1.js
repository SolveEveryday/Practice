function solution(record) {
  let userIds = new Map();
  let chatInfos = [];
  for (let i = 0; i < record.length; i++) {
    let [chatInfo, userId, userName] = record[i].split(' ');
    chatInfos.push([chatInfo, userId]);
    if (chatInfo === 'Enter') {
      userIds.set(userId, userName);
    } else if (chatInfo === 'Change') {
      userIds.set(userId, userName);
    }
  }

  let answer = [];
  for (let i = 0; i < chatInfos.length; i++) {
    let [chatInfo, userId] = chatInfos[i];
    if (chatInfo === 'Enter') {
      answer.push(`${userIds.get(userId)}님이 들어왔습니다.`);
    } else if (chatInfo === 'Leave') {
      answer.push(`${userIds.get(userId)}님이 나갔습니다.`);
    }
  }
  return answer;
}

console.log(
  solution([
    'Enter uid1234 Muzi',
    'Enter uid4567 Prodo',
    'Leave uid1234',
    'Enter uid1234 Prodo',
    'Change uid4567 Ryan',
  ]),
);
