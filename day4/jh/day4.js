const fs = require("fs");

fs.readFile("input.txt", "utf-8", (err, data) => {
  if (err) {
    console.error("Error reading the file:", err);
    return;
  }

  const lines = data
    .split("\n")
    .map((line) => line.trim())
    .filter((line) => line);
  part1(lines);
  part2(lines);
});

function part1(input) {
  let total = 0;
  for (i = 0; i < input.length; i++) {
    for (j = 0; j < input[i].length; j++) {
      if (input[i][j] === "X") {
        //Backwards
        if (
          input[i].length - j >= 4 &&
          input[i][j + 1] === "M" &&
          input[i][j + 2] === "A" &&
          input[i][j + 3] === "S"
        ) {
          total++;
        }
        //Forwards
        if (
          j > 2 &&
          input[i][j - 1] === "M" &&
          input[i][j - 2] === "A" &&
          input[i][j - 3] === "S"
        ) {
          total++;
        }
        //Up
        if (
          i > 2 &&
          input[i - 1][j] === "M" &&
          input[i - 2][j] === "A" &&
          input[i - 3][j] === "S"
        ) {
          total++;
        }
        //Down
        if (
          input[i].length - i >= 4 &&
          input[i + 1][j] === "M" &&
          input[i + 2][j] === "A" &&
          input[i + 3][j] === "S"
        ) {
          total++;
        }
        //Diagonal Up Right
        if (
          i > 2 &&
          input[i - 1][j + 1] === "M" &&
          input[i - 2][j + 2] === "A" &&
          input[i - 3][j + 3] === "S"
        ) {
          total++;
        }
        //Diagonal Up Left
        if (
          i > 2 &&
          input[i - 1][j - 1] === "M" &&
          input[i - 2][j - 2] === "A" &&
          input[i - 3][j - 3] === "S"
        ) {
          total++;
        }
        //Diagonal Down Right
        if (
          input[i].length - i >= 4 &&
          input[i + 1][j - 1] === "M" &&
          input[i + 2][j - 2] === "A" &&
          input[i + 3][j - 3] === "S"
        ) {
          total++;
        }
        //Diagonal Down Left
        if (
          input[i].length - i >= 4 &&
          input[i + 1][j + 1] === "M" &&
          input[i + 2][j + 2] === "A" &&
          input[i + 3][j + 3] === "S"
        ) {
          total++;
        }
      }
    }
  }
  console.log(total);
}

function part2(input) {
  let total = 0;
  for (i = 0; i < input.length; i++) {
    for (j = 0; j < input[i].length; j++) {
      if (
        input[i][j] === "A" &&
        i - 1 >= 0 &&
        i + 1 <= input.length - 1 &&
        j + 1 <= input[i].length - 1 &&
        j - 1 >= 0
      ) {
        if (
          /*
                M M
                 A
                S S
                */
          //Check for undefined
          (input[i - 1] &&
            input[i - 1][j - 1] &&
            input[i - 1][j + 1] &&
            input[i + 1] &&
            input[i + 1][j - 1] &&
            input[i + 1][j + 1] &&
            //Check for letters
            input[i - 1][j - 1] === "M" &&
            input[i - 1][j + 1] === "M" &&
            input[i + 1][j - 1] === "S" &&
            input[i + 1][j + 1] === "S") ||
          /*
                S M
                 A
                S M
                */
          //Check for undefined
          (input[i - 1] &&
            input[i - 1][j - 1] &&
            input[i - 1][j + 1] &&
            input[i + 1] &&
            input[i + 1][j - 1] &&
            input[i + 1][j + 1] &&
            //Check for letters
            input[i - 1][j - 1] === "S" &&
            input[i - 1][j + 1] === "M" &&
            input[i + 1][j - 1] === "S" &&
            input[i + 1][j + 1] === "M") ||
          /*
                S S
                 A
                M M
                */
          //Check for undefined
          (input[i - 1] &&
            input[i - 1][j - 1] &&
            input[i - 1][j + 1] &&
            input[i + 1] &&
            input[i + 1][j - 1] &&
            input[i + 1][j + 1] &&
            //Check for letters
            input[i - 1][j - 1] === "S" &&
            input[i - 1][j + 1] === "S" &&
            input[i + 1][j - 1] === "M" &&
            input[i + 1][j + 1] === "M") ||
          /*
                M S
                 A
                M S
                */
          //Check for undefined
          (input[i - 1] &&
            input[i - 1][j - 1] &&
            input[i - 1][j + 1] &&
            input[i + 1] &&
            input[i + 1][j - 1] &&
            input[i + 1][j + 1] &&
            //Check for letters
            input[i - 1][j - 1] === "M" &&
            input[i - 1][j + 1] === "S" &&
            input[i + 1][j - 1] === "M" &&
            input[i + 1][j + 1] === "S")
        ) {
          total++;
        }
      }
    }
  }
  console.log(total);
}