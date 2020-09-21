/* GLOBAL VARS */
var global_quiz_list = [];
//insert
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
				console.log('insert result : ' + result);
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
//select
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