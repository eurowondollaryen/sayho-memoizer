/**
 * modal event
 */

//Quiz 추가 modal 출력
const showAdd = function() {
	document.getElementById("inpTitle").value = "";
	$("#inpTitleModal").modal();
};

//Quiz에 대한 Question 추가 modal 출력
const addQuestion = function(index) {
	document.getElementById("inpQuestion").value = "";
	document.getElementById("inpAnswer").value = "";
	document.getElementById("modalQuestionTitle").innerHTML = "질문 추가하기 - " + global_quiz_list[index]["quiz_nm"];
	document.getElementById("btnRegistQuestion").setAttribute("onClick", "registQuestion(" + global_quiz_list[index]["seq"] + ")");
	$("#inpQuestionModal").modal();
};

const showQuestionModal = function() {
	$("#questionListModal").modal();
};