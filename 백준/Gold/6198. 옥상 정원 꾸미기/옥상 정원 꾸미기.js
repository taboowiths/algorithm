const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);

let stk = [];
let ans = 0;
for (let i = 1; i <= N; i++) {
  let cur = Number(input[i]);
  while (stk.length > 0 && stk[stk.length - 1] <= cur) {
    // cur를 볼 수 없으면 삭제
    stk.pop();
  }
  ans += stk.length;
  stk.push(cur);
}
console.log(ans);
