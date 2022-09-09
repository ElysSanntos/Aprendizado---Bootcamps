var numberInput = document.getElementById('numberInput'),
	sumButton = document.getElementById('sumButton'),
	myList = document.getElementById('myList');

numberInput.value = localStorage['myNumber'] || 0;

function incNumber(){
	var value = +numberInput.value;
	value++;
	numberInput.value = value;
	localStorage['myNumber'] = value;
}


function setList(nItems){
	var template = "";
	for(var i = 0; i < nItems; i++){
		//myList.innerHTML = myList.innerHTML + `<li>Item ${i+1}</li>`;
		template += `<li>Item ${i+1}</li>`;
	}
	myList.innerHTML = template;
}



setList(700);
