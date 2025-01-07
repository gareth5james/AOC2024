const fs = require("fs");

fs.readFile("input.txt", "utf-8", (err, data) => {
  if (err) {
    console.error("Error reading the file:", err);
    return;
  }

  const sections = data
    .replace(/\r\n/g, "\n")
    .split(/\n\s*\n/)
    .map((section) =>
      section
        .trim()
        .split("\n")
        .map((line) => line.trim())
        .filter((line) => line)
    );

  let rules = sections[0];
  let pages = sections[1];

  // Split rules into separate numbers
  for (let i = 0; i < rules.length; i++) {
    rules[i] = rules[i].split("|").map(Number);
  }

  // Split pages into arrays of numbers
  for (let j = 0; j < pages.length; j++) {
    pages[j] = pages[j].split(",").map(Number);
  }

  part1(rules, pages)
});

function part1(rules, pages) {
  let sumOfMiddlePages = 0;

  // Iterate over each page line
  for (let i = 0; i < pages.length; i++) {
    let isOrdered = true;

    // Iterate over all rules for the current line
    for (let j = 0; j < rules.length; j++) {
      // Check if both pages are present in the line
      const beforeIndex = pages[i].indexOf(rules[j][0]);
      const afterIndex = pages[i].indexOf(rules[j][1]);

      if (beforeIndex !== -1 && afterIndex !== -1 && beforeIndex > afterIndex) {
        isOrdered = false;
        break;
      }
    }

    if (isOrdered) {
      const middleIndex = Math.floor(pages[i].length / 2);
      sumOfMiddlePages += pages[i][middleIndex];
    }
  }

  console.log(`Part1 - ${sumOfMiddlePages}`);
}