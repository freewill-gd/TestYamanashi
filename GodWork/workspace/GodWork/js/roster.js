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
	formatTimeString(textObject);
		
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

// 時間補完関数
function formatTimeString(textObject) {
	var text = textObject.val();
	var ret = "";
	var ptr = /^[0-9][0-9][0-5][0-9]$/;
	if (ptr.test(text)) {
		ret = text.substr(0,2) + ":" + text.substr(2,2);
		textObject.val(ret);
		return;
	}
	
	ptr = /^[0-9]$/;
	if (ptr.test(text)) {
		ret = "0" + text + ":00";
		textObject.val(ret);
		return;
	}
	
	ptr = /^[0-9][0-9]$/;
	if (ptr.test(text)) {
		ret = text + ":00";
		textObject.val(ret);
		return;
	}
	
	ptr = /^[0-9][0-9][0-5]$/;
	if (ptr.test(text)) {
		ret = text.substr(0,2) + ":" + text.substr(2,1) + "0";
		textObject.val(ret);
		return;
	}

}

function getRoster(day, objName) {
	var index = day - 1;
	var baseSName = "[name='data[" + index + "].";
	var vaseEName = "']";
	
	var nameStr = baseSName +  objName + vaseEName;
	return $(nameStr);
}

function setRosterDefault(day) {
	getRoster(day, "workKind").val("1");
	getRoster(day, "startTime").val("09:00");
	getRoster(day, "endTime").val("18:00");
	getRoster(day, "breakTime").val("01:00");
	
}
