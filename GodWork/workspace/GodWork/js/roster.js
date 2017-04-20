function move() {
	goAction("move");
}

function update() {
	goAction("update");
}

function goAction(mode) {
	var obj  = document.getElementById("actionMode");
	obj.value = mode;
	document.forms[0].submit();
}