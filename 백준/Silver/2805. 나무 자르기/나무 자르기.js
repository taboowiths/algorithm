const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const trees = input[1].split(" ").map(Number);

let left = 0,
  right = 1000000000;

while (left + 1 < right) {
  let mid = Math.floor((left + right) / 2);
  if (Check(mid)) left = mid;
  else right = mid;
}

console.log(left);

function Check(mid) {
  let sum = 0;
  trees.map((tree, i) => {
    if (tree > mid) sum += tree - mid;
  });
  return sum >= M;
}
