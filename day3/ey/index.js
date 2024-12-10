const fs = require("fs");

const data = fs.readFileSync("input.txt", "utf-8");

const corruptedMemory =
  "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";

function sumValidMultiplications(corruptedMemory) {
  const regex = /mul\((\d{1,3}),(\d{1,3})\)/g;

  let match;
  let totalSum = 0;

  while ((match = regex.exec(corruptedMemory)) !== null) {
    console.log(typeof corruptedMemory);
    
    const x = parseInt(match[1], 10);
    
    const y = parseInt(match[2], 10);
    totalSum += x * y;
  }

//   return totalSum;
}

// console.log(sumValidMultiplications(corruptedMemory));

function sumValidMultiplicationsWithConditions(corruptedMemory) {
  const mulRegex = /mul\((\d{1,3}),(\d{1,3})\)/;
  const doRegex = /do\(\)/;
  const dontRegex = /don't\(\)/;

  let totalSum = 0;
  let isEnabled = true;

  const instructions = corruptedMemory.match(
    /(mul\(\d{1,3},\d{1,3}\)|do\(\)|don't\(\))/g
  );

  if (!instructions) return 0;

  instructions.forEach((instruction) => {
    if (doRegex.test(instruction)) {
      isEnabled = true;
    } else if (dontRegex.test(instruction)) {
      isEnabled = false;
    } else if (mulRegex.test(instruction) && isEnabled) {

      const match = instruction.match(mulRegex);
      
      const x = parseInt(match[1], 10);
      const y = parseInt(match[2], 10);
      totalSum += x * y;
    }
  });

  return totalSum;
}

console.log(sumValidMultiplicationsWithConditions(data), "<- conditions"); // Output: 48
