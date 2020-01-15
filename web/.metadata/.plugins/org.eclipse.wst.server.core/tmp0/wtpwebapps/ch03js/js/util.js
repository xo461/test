/**
 * 
 */

// ======================객체 선택 (id, class, tag) ==========================//
function get(objName) {
	// alert("get() :" + objName);
	// id에 대한 처리 - id앞에는 "#"을 붙여서 넣어 준다. 예) #deletdBtn
	if (objName.indexOf("#") == 0){
//		alert("id선택")
		return document.getElementById(removeFirstChar(objName));
	}
	if (objName.indexOf(".") == 0)
		return document.getElementsByClassName(removeFirstChar(objName));
	return document.getElementsByTagName(objName);
}

// ========================첫글자를 잘라내는 함수 ====================================
// dateToString(날짜객체, 년, 월, 일 사이에 들어갈 문자);
function removeFirstChar(objName) {
	return objName.substring(1);
}

function dateToString(date, ch) {
	// 객체가 null인 경우 처리
	if(date == null)return "객체가 null입니다.";
	// 날짜 type의 객체가 아니면 처리
	if(!(typeof date === "object" && date instanceof Date))
		return "객체가 Date Type이 아닙니다.";
	if(ch == null) ch = "-";
	return date.getFullYear()+ch+ (date.getMonth()+1)+ch+date.getDate();
}