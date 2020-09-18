var register = function() {
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
				requestQuizList();
			},
			error : function(xhr, textStatus, errorThrown) {
				alert("failed to insert data...\n" + xhr.status + " " + xhr.statusText);
			}
		});
	}
};

//delete quiz
var deleteQuiz = function(seq) {
	$.ajax({
		type: "post",
		url: "/quiz/delete",
		data: {
			   "usrId" : "sehoakasayho",
			   "seq" : seq
			   },
		success: function(result) {
			console.log('delete success');
			requestQuizList();
		},
		error : function(xhr, textStatus, errorThrown) {
			alert("delete request failed...\n" + xhr.status + " " + xhr.statusText);
		}
	});
};
var requestQuizList = function() {
	$.ajax({
		type: "post",
		url: "/quiz/list",
		data: {"usrId" : "sehoakasayho"},
		success: function(result) {
			console.log('request success');
			console.log(result);
			printQuizList(result.data);
		},
		error : function(xhr, textStatus, errorThrown) {
			alert("request failed...\n" + xhr.status + " " + xhr.statusText);
		}
	});
};