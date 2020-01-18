function viewList() {
	var xlh = new XMLHttpRequest();
	xlh.open("GET", "/employee", true);
	xlh.onreadystatechange = function() {

		if (xlh.readyState === XMLHttpRequest.DONE && xlh.status === 200) {
			var data = JSON.parse(xlh.response);
		   
			var elements = document.getElementsByTagName('tbody')[0];
			elements.innerHTML="";
			    data.forEach(function(item, index) {
				var row = elements.insertRow(0);

				var c1 = row.insertCell(0);
				var c2 = row.insertCell(1);
				var c3 = row.insertCell(2);

				c1.innerHTML = item.id;
				c2.innerHTML = item.name;
				c3.innerHTML = item.email;

			});
		}
	}
	xlh.send();
}

console.log("Gui");



//hide and display

function displayFunction() {
	  var x = document.getElementById("view");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
		  viewList();
	  }
	}
