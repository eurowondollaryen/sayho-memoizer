/* GLOBAL VARS */
var global_quiz_list = [];
var global_question_list = [];

//insert questions for a quiz
const registQuestion = function(seq) {
	var inpQuestion = document.getElementById("inpQuestion").value;
	var inpAnswer = document.getElementById("inpAnswer").value;
	if(inpQuestion === "") {
		alert("질문을 입력해 주세요!");
		return;
	}
	if(inpAnswer === "") {
		alert("답변을 입력해 주세요!");
		return;
	}
	
	var requestData = {
		"quizSeq" : seq,
		"usrId" : "sehoakasayho",
		"question" : inpQuestion,
		"answer" : inpAnswer
	};
	
	$.ajax({
		type: "post",
		url: "/quiz/registQuestion",
		data: requestData,
		success: function(result) {
			console.log('insert question result : ' + result["data"]);
			alert("질문 등록에 성공했습니다!");
			//등록 후 refresh
			requestQuizList(global_quiz_list);
		},
		error : function(xhr, textStatus, errorThrown) {
			alert("failed to insert data...\n" + xhr.status + " " + xhr.statusText);
		}
	});
}

//insert quiz
const registQuiz = function() {
	var quizTitle = document.getElementById("inpTitle").value; 
	if(quizTitle === "") {
		alert("제목을 입력해 주세요!");
	} else {
		var requestData = {
			"usrId" : "sehoakasayho",
			"quizNm" : quizTitle
		};
		$.ajax({
			type: "post",
			url: "/quiz/regist",
			data: requestData,
			success: function(result) {
				console.log('insert result : ' + result["data"]);
				requestQuizList(global_quiz_list);
			},
			error : function(xhr, textStatus, errorThrown) {
				alert("failed to insert data...\n" + xhr.status + " " + xhr.statusText);
			}
		});
	}
};

//delete quiz
const deleteQuiz = function(seq) {
	$.ajax({
		type: "delete",
		url: "/quiz/delete",
		data: {
			   "usrId" : "sehoakasayho",
			   "seq" : seq
			   },
		success: function(result) {
			console.log('delete success');
			requestQuizList(global_quiz_list);
		},
		error : function(xhr, textStatus, errorThrown) {
			alert("delete request failed...\n" + xhr.status + " " + xhr.statusText);
		}
	});
};

//select quiz list
const requestQuizList = function(copy_arr) {
	$.ajax({
		type: "post",
		url: "/quiz/list",
		data: {"usrId" : "sehoakasayho"},
		success: function(result) {
			console.log('request success');
			console.log(result);
			for(var i = 0; i < result.data.length; ++i) {
				copy_arr[i] = result.data[i];
			}
			printQuizList(result.data);
		},
		error : function(xhr, textStatus, errorThrown) {
			alert("request failed...\n" + xhr.status + " " + xhr.statusText);
		}
	});
};

//select question list
const requestQuestionList = function(quizSeq) {
	$.ajax({
		type: "post",
		url: "/quiz/questionList",
		data: {
			   "usrId" : "sehoakasayho",
			   "quizSeq" : quizSeq
			   },
		success: function(result) {
			console.log('question list request success!');
			console.log(result);
			//function jsonArrayToTable is in index.html
			document.querySelector("#questionListArea").innerHTML = jsonArrayToTable(result.data);
			global_question_list = result.data;
			showQuestionModal();
			document.querySelector("#startQuizBtn").addEventListener("click", (e) => {
				//TODO : 새 탭을 띄워서 퀴즈를 진행하는 방식으로. 새 탭에 global_question_list 데이터를 넘겨준다.
			});
		},
		error : function(xhr, textStatus, errorThrown) {
			alert("request failed...\n" + xhr.status + " " + xhr.statusText);
		}
	});
};