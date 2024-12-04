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
  //part1(lines)
  part2(lines);
});

function part1(input) {
  let totalSafe = 0;
  for (let i = 0; i < input.length; i++) {
    const levels = input[i].split(" ").map(Number);
    let safe = true;
    let asc = levels[1] > levels[0];

    for (let j = 1; j < levels.length; j++) {
      const diff = Math.abs(levels[j] - levels[j - 1]);

      if (diff < 1 || diff > 3) {
        safe = false;
        break;
      }

      if (asc && levels[j] < levels[j - 1]) {
        safe = false;
        break;
      } else if (!asc && levels[j] > levels[j - 1]) {
        safe = false;
        break;
      }
    }
    if (safe === true) {
      totalSafe++;
    }
  }
  console.log(totalSafe);
}

function part2(input) {
    let totalSafe = 0;
  
    for (let i = 0; i < input.length; i++) {
      const originalLevels = input[i].split(" ").map(Number);
  
      if (isSafe(originalLevels)) {
        totalSafe++;
      } else {
        let safeWithOneRemoval = false;
  
        for (let j = 0; j < originalLevels.length; j++) {
          const modifiedLevels = [...originalLevels];
          modifiedLevels.splice(j, 1);
  
          if (isSafe(modifiedLevels)) {
            safeWithOneRemoval = true;
            break;
          }
        }
  
        if (safeWithOneRemoval) {
          totalSafe++;
        }
      }
    }
  
    console.log(totalSafe);
  }
  
  function isSafe(levels) {
    let asc = levels[1] > levels[0];
  
    for (let j = 1; j < levels.length; j++) {
      const diff = Math.abs(levels[j] - levels[j - 1]);

      if (diff < 1 || diff > 3) {
        return false;
      }
      if (asc && levels[j] < levels[j - 1]) {
        return false;
      } else if (!asc && levels[j] > levels[j - 1]) {
        return false;
      }
    }
  
    return true;
  }
