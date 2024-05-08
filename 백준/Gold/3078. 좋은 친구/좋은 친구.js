const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, K] = input[0].split(" ").map(Number);
const friends = new Array(N).fill(0);
for (let i = 1; i <= N; i++) friends[i - 1] = input[i].length;

const solution = () => {
  let lengthCnt = new Array(21).fill(0);
  for (let i = 0; i <= K; i++) lengthCnt[friends[i]]++;
  let ans = lengthCnt[friends[0]] - 1; // 내꺼 하나 뺀 값
  for (let i = 1; i < N; i++) {
    if (i + K < N) lengthCnt[friends[i + K]]++;
    lengthCnt[friends[i - 1]]--;
    ans += lengthCnt[friends[i]] - 1;
  }
  console.log(ans);
};

solution();
