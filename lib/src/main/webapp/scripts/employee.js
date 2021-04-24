
const uri = 'http://localhost:8080/chronos.com/employee';
let createButton = document.querySelector("#create-timesheet");
let editButton = document.querySelector("#more");
let submitButton = document.querySelector("#submit");
let days = ["#sat", "#sun", "#mon", "#tues", "#wed", "#thurs", "#fri"];
let dayInput = ["sat-input", "#sun-input", "#mon-input", "tue-input", "wed-input", "thu-input", "fri-input"];
let regularPay = document.querySelectorAll(".input-regular");
let ptoPay = document.querySelectorAll(".input-pto");

// Get Current Week for Timesheet form.
//*******************************************************************************************/
(function() {
  let date = new Date();
  let i =  0 - (date.getDay() + 1);
  let currentDate = new Date(date);

  for (let index = 0; index < days.length; index++) {
    let x = document.querySelector(days[index]);
    currentDate.setDate(date.getDate() + i);
    x.append(date.getMonth()+ "/" + currentDate.getDate() + "/" + date.getFullYear());
    i++;
  }
})();
//*******************************************************************************************/

async function getUserProfile() {
  let resp = await fetch(uri)
  let user = await resp.json();
  let profileName = document.querySelector("#name");
  let profileUserName = document.querySelector("#username");
  let profileImg = document.querySelector("#profile-image");

  profileImg.src = user.picture;
  profileName.innerHTML = user.firstName + " " + user.lastName;
  profileUserName.innerHTML = user.userName;
  console.log(user);
}
getUserProfile();

function toggleForm() {
  let tSub = document.querySelector("#time-submission");
  let tView = document.querySelector("#timesheet-wrapper");
  let pView = document.querySelector("#profile-view")

  if (tSub.style.display === "none") {
    tSub.style.display = "block";
    tView.style.display = "none";
    pView.style.display = "none";
  } else {
    tSub.style.display = "none";
    tView.style.display = "block";
    pView.style.display = "block";
  }

}

createButton.addEventListener("mouseover", function() {
  createButton.style.background = "#f72585";
  createButton.style.transform = "scale(1.1, 1.1)";
});

createButton.addEventListener("mouseout", function() {
  createButton.style.background = "linear-gradient(to right, #f72585, #b5179e, #7209b7, #560bad, #480ca8, #3a0ca3, #3f37c9, #4361ee, #4895ef, #4cc9f0)";
  createButton.style.transform = "scale(1, 1)";
});

editButton.addEventListener("mouseover", function() {
  editButton.style.background = "#f72585";
  editButton.style.transform = "scale(1.1, 1.1)";
});

editButton.addEventListener("mouseout", function() {
  editButton.style.background = "linear-gradient(to right, #f72585, #b5179e, #7209b7, #560bad, #480ca8, #3a0ca3, #3f37c9, #4361ee, #4895ef, #4cc9f0)";
  editButton.style.transform = "scale(1, 1)";
});

submitButton.addEventListener("mouseover", function() {
  submitButton.style.background = "#f72585";
  submitButton.style.transform = "scale(1.1, 1.1)";
});

submitButton.addEventListener("mouseout", function() {
  submitButton.style.background = "linear-gradient(to right, #f72585, #b5179e, #7209b7, #560bad, #480ca8, #3a0ca3, #3f37c9, #4361ee, #4895ef, #4cc9f0)";
  submitButton.style.transform = "scale(1, 1)";
});

(function() {
  regularPay.forEach(element => {
    element.addEventListener("change", function() {
      calculateRegular();
      calculateTotal();
    });
  });
})();

(function() {
  ptoPay.forEach(element => {
    element.addEventListener("change", function() {
      calculatePTO();
      calculateTotal();
    });
  });
})();

function calculateRegular() {
  let sum = 0, temp = 0;
  let x = document.querySelector("#total-regular");

  regularPay.forEach(element => {
    if (!isNaN(element.value) && element.value.length != 0) {
      sum += parseFloat(element.value);
      temp = parseFloat(element.value);
      element.value = temp.toFixed(2);
    }
  });
  x.value = sum.toFixed(2);
}

function calculatePTO() {
  let sum = 0, temp = 0;
  let x = document.querySelector("#total-pto");

  ptoPay.forEach(element => {
    if (!isNaN(element.value) && element.value.length != 0) {
      sum += parseFloat(element.value);
      temp = parseFloat(element.value);
      element.value = temp.toFixed(2);
    }
  });
  x.value = sum.toFixed(2);
}

function calculateTotal() {
  let result = document.querySelector("#total-hrs");
  let num1 = document.querySelector("#total-regular");
  let num2 = document.querySelector("#total-pto");
  let sum = 0;

  if (!isNaN(num1.value) && !isNaN(num2.value) && num1.value.length != 0 && num2.value.length != 0) {
    sum = parseFloat(num1.value) + parseFloat(num2.value);
  }
  
  result.value = sum.toFixed(2);
}
