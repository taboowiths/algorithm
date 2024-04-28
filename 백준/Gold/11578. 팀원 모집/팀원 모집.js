const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
let students = [];
let ans = 0;
let min = -1;
for (let i = 1; i <= M; i++) {
  const nums = input[i].split(" ");
  let tmp = 0;
  for (let j = 1; j <= nums[0]; j++) tmp |= 1 << (nums[j] - 1);
  students.push(tmp);
}

for (let i = 0; i < N; i++) ans |= 1 << i;

const solution = () => {
  for (let m = 1; m <= M; m++) {
    let members = Array(m);
    dfs(0, 0, m, members);
    if (min != -1) break;
  }
  console.log(min);
};

const dfs = (cnt, start, end, members) => {
  if (cnt == end) {
    // 선택한 팀원으로 문제 풀 수 있는지
    let sum = 0;
    for (let e = 0; e < end; e++) {
      sum |= students[members[e]];
    }
    if (sum === ans) min = end;
    return;
  }
  for (let i = start; i < M; i++) {
    members[cnt] = i;
    dfs(cnt + 1, i + 1, end, members);
  }
};

solution();
