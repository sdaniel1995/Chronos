let elem1 = document.getElementById("first-name");
let elem2 = document.getElementById("last-name");
let elem3 = document.getElementById("email");
let elem4 = document.getElementById("password");
let elem5 = document.getElementById("position");
let button = document.querySelector("#submit");

elem1.addEventListener("focusin", function() {
  elem1.style.borderBottom = "2px solid black";
});

elem1.addEventListener("focusout", function() {
  elem1.style.borderBottom = "2px solid lightgrey";
});

elem2.addEventListener("focusin", function() {
  elem2.style.borderBottom = "2px solid black";
});

elem2.addEventListener("focusout", function() {
  elem2.style.borderBottom = "2px solid lightgrey";
});

elem3.addEventListener("focusin",function() {
    elem3.style.borderBottom = "2px solid black";
});

elem3.addEventListener("focusout", function() {
    elem3.style.borderBottom = "2px solid lightgrey";
});

elem4.addEventListener("focusin", function() {
    elem4.style.borderBottom = "2px solid black";
});
  
elem4.addEventListener("focusout", function() {
    elem4.style.borderBottom = "2px solid lightgrey";
});

elem5.addEventListener("focusin", function() {
    elem5.style.borderBottom = "2px solid black";
});
  
elem5.addEventListener("focusout", function() {
    elem5.style.borderBottom = "2px solid lightgrey";
});

button.addEventListener("mouseover", function() {
    button.style.background = "#f72585";
    button.style.transform = "scale(1.2, 1.2)";
}); 

button.addEventListener("mouseout", function() {
    button.style.background = "linear-gradient(to right, #f72585, #b5179e, #7209b7, #560bad, #480ca8, #3a0ca3, #3f37c9, #4361ee, #4895ef, #4cc9f0)";
    button.style.transform = "scale(1, 1)";
});

let input = document.querySelector(".input");

button.disabled = true;

input.addEventListener("change", stateHandle);

function stateHandle() {
  if (document.querySelector(".input").value === "") {
    button.disabled = true;
  } else {
    button.disabled = false;
  }
}