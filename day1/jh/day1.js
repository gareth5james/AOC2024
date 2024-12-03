const fs = require("fs");

fs.readFile("input.csv", "utf-8", (err, data) => {
  if (err) {
    console.error("Error reading the file:", err);
    return;
  }

  const lines = data
    .split("\n")
    .map((line) => line.trim())
    .filter((line) => line);
  compareNumbers(lines);
  compareNumbers2(lines);
});

function compareNumbers(input) {
  let count = 0;
  let arr1 = [];
  let arr2 = [];
  for (let i = 0; i < input.length; i++) {
    let arr = input[i].trim().split(/\s+/);
    arr1.push(arr[0]);
    arr2.push(arr[1]);
  }
  arr1 = arr1.sort();
  arr2 = arr2.sort();
  for (let j = 0; j < arr1.length; j++) {
    if (arr1[j] > arr2[j]) {
      count += arr1[j] - arr2[j];
    } else {
      count += arr2[j] - arr1[j];
    }
  }
  console.log(`Part 1 - ${count}`);
}

function compareNumbers2(input) {
  let count = 0;
  let arr1 = [];
  let arr2 = [];
  for (let i = 0; i < input.length; i++) {
    let arr = input[i].trim().split(/\s+/);
    arr1.push(arr[0]);
    arr2.push(arr[1]);
  }
  for (let j = 0; j < arr1.length; j++) {
    let matches = arr2.filter((num) => num === arr1[j]);
    if (matches.length) {
      count += arr1[j] * matches.length;
    }
  }
  console.log(`Part 2 - ${count}`);
}
