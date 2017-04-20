function move() {
	goAction("move");
}

function update() {
	goAction("update");
}

function goAction(mode) {
	var obj  = document.getElementById("aMode");
	obj.value = mode;
	document.forms[0].submit();
}