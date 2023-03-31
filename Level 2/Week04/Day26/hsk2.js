function solution(book_time) {
  // 퇴실 시간을 기준으로 10분간 청소
  // 필요한 객실의 수 return

  let bookEndTimes = [];
  book_time.sort().forEach(([startTime, endTime]) => {
    const [startHour, startMinute] = startTime.split(':');
    const [endHour, endMinute] = endTime.split(':');

    const start = Number(startHour) * 60 + Number(startMinute);
    const end = Number(endHour) * 60 + Number(endMinute) + 10;

    if (bookEndTimes.length === 0) {
      bookEndTimes.push(end);
    } else {
      bookEndTimes.sort();
      let isChangedRoom = false;
      for (let i = 0; i < bookEndTimes.length; i++) {
        if (bookEndTimes[i] <= start) {
          bookEndTimes[i] = end;
          isChangedRoom = true;
          break;
        }
      }

      if (!isChangedRoom) {
        bookEndTimes.push(end);
      }
    }
  });

  return bookEndTimes.length;
}

console.log(
  solution([
    ['15:00', '17:00'],
    ['16:40', '18:20'],
    ['14:20', '15:20'],
    ['14:10', '19:20'],
    ['18:20', '21:20'],
  ]),
);
console.log(
  solution([
    ['09:10', '10:10'],
    ['10:20', '12:20'],
  ]),
);
console.log(
  solution([
    ['10:20', '12:30'],
    ['10:20', '12:30'],
    ['10:20', '12:30'],
  ]),
);
