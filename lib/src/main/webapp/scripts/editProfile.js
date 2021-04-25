const uri = 'http://localhost:8080/chronos.com/user';
let saveButton = document.querySelector("#save-info");

async function getUserInfo() {
    let resp = await fetch(uri)
    let user = await resp.json();
    let profileImg = document.querySelector("#profile-image");
    let firstName= document.querySelector("#fname");
    let lastName = document.querySelector("#lname");
    let username = document.querySelector("#uname");
    let email = document.querySelector("#email");
    let password = document.querySelector("#pass");
  
    profileImg.src = user.picture;
    firstName.value = user.firstName;
    lastName.value = user.lastName;
    username.value = user.userName;
    email.value = user.email;
    password.value = user.password;
  }
  getUserInfo();


  saveButton.addEventListener("mouseover", function() {
    saveButton.style.background = "#f72585";
    saveButton.style.transform = "scale(1.1, 1.1)";
  });

  saveButton.addEventListener("mouseout", function() {
    saveButton.style.background = "linear-gradient(to right, #f72585, #b5179e, #7209b7, #560bad, #480ca8, #3a0ca3, #3f37c9, #4361ee, #4895ef, #4cc9f0)";
    saveButton.style.transform = "scale(1, 1)";
  });
