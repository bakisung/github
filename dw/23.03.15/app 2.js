const colors = ["red", "blue", "green", "yellow", "brown", "grey", "black"];
for (let i=0; i<colors.length; i++) {
    console.log(colors[i]);
};

const colorSlice = colors.slice(3, 6);
console.log(colorSlice); /* ["yellow", "brown", "grey"] */

const x = colors.splice(3, 1, "pink");
console.log(colors); /* "red" ~ "black" */

const colorSplice = colors.splice(0, 1);
console.log(colorSplice); /* ["red"] */