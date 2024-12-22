const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);

function solution() {
  let stringKeyMap = new Map();
  let numberKeyMap = new Map();

  for (let i = 1; i <= N; i++) {
    stringKeyMap.set(input[i], i);
    numberKeyMap.set(i, input[i]);
  }

  for (let i = 1; i <= M; i++) {
    const question = input[N + i];
    if (checkType(question) === "Number")
      console.log(numberKeyMap.get(Number(question)));
    else {
      console.log(stringKeyMap.get(question));
    }
  }
}

function checkType(value) {
  if (!isNaN(value)) {
    return "Number";
  } else {
    return "String";
  }
}

solution();
