(function($) {
	let dictionaries = renderJson.dictionaries;
	if(dictionaries.length == 0){
		$("#regBtn").on("click", ()=>{
			let regKey = $("#regKey").val();
			let regVal = $("#regVal").val();
			let box = {};
			box.key = regKey;
			box.value = regVal;
			$.ajax({
				type : "POST",
				url : "/management/dic",
				contentType : "application/json",
				data : JSON.stringify(box),
				success : function(data){
					alert(data);
					window.location.href = "/management/view";
				},
				error : function (err){
					console.log(err);
				}
			})
		});
	}
	else{
		$(".mod_btn").on("click", function(){
			let $target = $(this).parent().parent().parent().find("input");
			let modKey = $target[0].value;
			let modVal = $target[1].value;
			let box = {};
			box.key = modKey;
			box.value = modVal;
			$.ajax({
				type : "POST",
				url : "/management/dic",
				contentType : "application/json",
				data : JSON.stringify(box),
				success : function(data){
					alert(data);
					window.location.href = "/management/view";
				},
				error : function (err){
					console.log(err);
				}
			})
		})
	}

})(jQuery);
