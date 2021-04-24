let input1 = document.querySelector("#username");
let input2 = document.querySelector("#password");
let button = document.querySelector("#login");

input1.addEventListener("focusin", function () {
  input1.style.borderBottom = "2px solid black";
});

input1.addEventListener("focusout", function () {
  input1.style.borderBottom = "2px solid lightgrey";
});

input2.addEventListener("focusin", function () {
  input2.style.borderBottom = "2px solid black";
});

input2.addEventListener("focusout", function () {
  input2.style.borderBottom = "2px solid lightgrey";
});

button.addEventListener("mouseover", function () {
  button.style.background = "#f72585";
  button.style.transform = "scale(1.1, 1.1)";
});

button.addEventListener("mouseout", function () {
  button.style.background = "linear-gradient(to right, #f72585, #b5179e, #7209b7, #560bad, #480ca8, #3a0ca3, #3f37c9, #4361ee, #4895ef, #4cc9f0)";
  button.style.transform = "scale(1, 1)";
});

let input = document.querySelector(".input");

button.disabled = true;

input.addEventListener("change", function() {
  if (input.value === "") {
    button.disabled = true;
  } else {
    button.disabled = false;
  }
});

