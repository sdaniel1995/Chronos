const userUri = 'http://localhost:8080/chronos.com/user';
const timeUri = 'http://localhost:8080/chronos.com/allTime';
let editButton = document.querySelector("#more");
let submitButton = document.querySelector("#timesheet-action");

(async() => {
    let resp = await fetch(userUri)
    let user = await resp.json();
    let profileName = document.querySelector("#name");
    let profileUserName = document.querySelector("#username");
    let profileImg = document.querySelector("#profile-image");
  
    profileImg.src = user.picture;
    profileName.innerHTML = user.firstName + " " + user.lastName;
    profileUserName.innerHTML = user.userName;
})();

(async() => {
    let resp = await fetch(timeUri);
    let tSheets = await resp.json();
    let table = document.querySelector("#time-sheet");
  
    for (let index = 0; index < tSheets.length; index++) {
      let row = table.insertRow(index);  
      let cell1 = row.insertCell(0);
      let cell2 = row.insertCell(1);
      let cell3 = row.insertCell(2);
      let cell4 = row.insertCell(3);
      let submitDate = tSheets[index].submitDate;
      let date = new Date(submitDate);

  
      cell1.innerHTML = tSheets[index].eid;
      cell1.style.width = "135px";
      cell2.innerHTML = date.getMonth() + "/" + date.getDate() + "/" + date.getFullYear();
      cell3.innerHTML = tSheets[index].totalHours.toFixed(2);
      cell4.innerHTML = tSheets[index].status;
    }
  })();

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