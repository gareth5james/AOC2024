const fs = require("fs");

fs.readFile("input.txt", "utf-8", (err, data) => {
  if (err) {
    console.error("Error reading the file:", err);
    return;
  }
  const regex = /mul\((\d+),(\d+)\)/g;
  const lines = Array.from(data.matchAll(regex)).map((match) => [
    parseInt(match[1]),
    parseInt(match[2])
  ]);
  const lines2 = data
    .split(/(?=[d])/g)
    .map((line) => line.trim())
    .filter((line) => line);
  part1(lines);
  part2(lines2);
});

function part1(input) {
  let total = 0;
  input.forEach((arr) => total += arr[0] * arr[1])
  console.log(total);
}

function part2(input) {
  let total = 0;
  const regex = /mul\((\d+),(\d+)\)/g;
  for (let i = 0; i < input.length; i++) {
    if (input[i][2] !== 'n') {
      const numbers = Array.from(input[i].matchAll(regex)).map((match) => [
        parseInt(match[1]),
        parseInt(match[2])
      ]);
      numbers.forEach((arr) => total += arr[0] * arr[1])
    }
  }
  console.log(total)
}