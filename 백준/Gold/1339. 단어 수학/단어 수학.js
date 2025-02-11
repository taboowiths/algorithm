const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath, "utf8").trim().split("\n");

function init () {
    let N = Number(input[0]);
    let weight = new Map();
    let words = [];

    Array.from({ length: N }, (_, i) => {
        const alphabet = input[i+1]
        words[i] = alphabet;
        alphabet.trim().split("").reverse().map((v, i) => {
            if (weight.has(v)) {
                weight.set(v, weight.get(v) + 10 ** i);
            } else weight.set(v, 10 ** i);
        })
    })

    const sortedMap = new Map(
        [...weight].sort(([, a], [, b]) => b - a) 
    )

    let max = 9;    
    let matchedMap = new Map();
    sortedMap.forEach((_, key) => matchedMap.set(key, max--));
    
    const mappedValues = words
    .map((word) => [...word.trim()].map((char) => matchedMap.get(char) || 0).join(""))
    .map(Number);
    
    const result = mappedValues.reduce((acc, cur) => acc + cur, 0);
    console.log(result)
    
}

init();