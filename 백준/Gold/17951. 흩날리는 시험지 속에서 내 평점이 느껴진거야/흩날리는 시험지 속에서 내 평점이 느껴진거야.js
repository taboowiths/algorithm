const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, K] = input[0].split(" ").map(Number);
const scores = input[1].split(" ").map(Number);

let left = 0;
let right = scores.reduce((acc, cur) => {
  return acc + cur;
}, 0);

while (left <= right) {
  let mid = Math.floor((left + right) / 2);
  let cnt = 0;
  let sum = 0;
  for (const score of scores) {
    sum += score;
    if (sum >= mid) {
      cnt++;
      sum = 0;
    }
  }
  if (cnt >= K) {
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}

console.log(right);
