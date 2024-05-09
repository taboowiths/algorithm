const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
let visitors = input[1].split(" ").map(Number);

const solution = () => {
  let count = 0; // 방문자 수
  let max = 0; // 최대 방문자 수
  let period = 0; // 기간 수

  for (let i = 0; i < N; i++) {
    if (i < M) {
      count += visitors[i];
    } else {
      count += visitors[i];
      count -= visitors[i - M];
    }
    if (max < count) {
      max = count;
      period = 1;
    } else if (max === count) {
      period++;
    }
  }

  if (max === 0) console.log("SAD");
  else {
    console.log(max);
    console.log(period);
  }
};

solution();