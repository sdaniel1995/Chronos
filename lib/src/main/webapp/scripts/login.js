let elem1 = document.getElementById("username");
let elem2 = document.getElementById("password");
let elem3 = document.getElementById("login");

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

elem3.addEventListener("mouseover", function() {
  elem3.style.background = "#f72585";
  elem3.style.transform = "scale(1.1, 1.1)";
});

elem3.addEventListener("mouseout", function() {
  elem3.style.background = "linear-gradient(to right, #f72585, #b5179e, #7209b7, #560bad, #480ca8, #3a0ca3, #3f37c9, #4361ee, #4895ef, #4cc9f0)";
  elem3.style.transform = "scale(1, 1)";
})