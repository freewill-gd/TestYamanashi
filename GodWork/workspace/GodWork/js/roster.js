$(document).ready(init);

// 月移動
function move() {
	goAction("move");
}

// 勤務表更新
function update() {
	var errorCount = $('.error_text').length;
	if (errorCount != 0) {
		alert('入力誤りがあります。修正後保存ボタンを押してください。')
		return;
	}
	goAction("update");
}

// エクセル
function excel() {
	goAction("excel");
}

// 押されたボタンを設定し送信
function goAction(mode) {
	var obj  = document.getElementById("actionMode");
	obj.value = mode;
	var  actionName = "Roster.do";
	if (mode == "excel") {
		actionName = "RosterExcelOut.do";
	}
	document.forms[0].action = actionName;
	document.forms[0].submit();
}


// ページ初期化
function init() {
	$('.time_text').blur(checkTime);
 }
 

//　時間フォーマットチェック後テキストボックスの背景を変更
function checkTime(){
	textObject = $(this);
	var text = textObject.val();
	if (checkTimeString(text)) {
		textObject.removeClass('error_text');
	}
	else {
		textObject.addClass('error_text');
	}

}

// 時間のフォーマットチェック
function checkTimeString(timestr) {
	if(timestr.length == 0) return true;
	var ptr = /^[0-9][0-9]:[0-5][0-9]$/;
	return ptr.test(timestr);
}
