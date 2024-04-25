const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const trees = input[1].split(" ").map(Number);
let mx = -1;
trees.map((tree) => (mx = Math.max(mx, tree)));

const Check = (mid) => {
  let sum = 0;
  for (let i = 0; i < trees.length; i++) {
    sum += trees[i] - mid > 0 ? trees[i] - mid : 0;
    if (sum >= M) return false;
  }
  return true;
};

const solution = () => {
  let lo = 0;
  let hi = mx;
  let mid = 0;
  while (lo <= hi) {
    mid = Math.floor((lo + hi) / 2);
    Check(mid) ? (hi = mid - 1) : (lo = mid + 1);
  }
  console.log(hi);
};

solution();
