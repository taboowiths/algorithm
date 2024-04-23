const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [d, n, m] = input[0].split(" ").map(Number);
const stones = [];
for (let i = 1; i <= n; i++) {
  stones.push(+input[i]);
}
stones.sort((a, b) => a - b);
stones.push(d);

let left = 0;
let right = d;
let ans = 0;

while (left <= right) {
  let mid = Math.floor((left + right) / 2);
  let pre = 0;
  let cnt = 0;
  stones.map((stone) => {
    if (stone - pre < mid) cnt++;
    else pre = stone;
  });
  if (cnt > m) {
    right = mid - 1;
  } else {
    ans = mid;
    left = mid + 1;
  }
}

console.log(ans);
