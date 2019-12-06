"use strict";

function enviarRequest(id) {
  var xhttp = new XMLHttpRequest();
  var obj = {id};
  var os = JSON.stringify(obj);
  console.log(os);
  
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        alert(this.responseText);
    }
  };
  
  xhttp.open("POST", "http://localhost:9000/api/alocaros/" + id, true);
  xhttp.setRequestHeader("Content-Type", "application/json");
  xhttp.send(os);
}


