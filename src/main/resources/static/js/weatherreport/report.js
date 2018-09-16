/**
 *
 */

$(function(){
	$("#selectcityID").change(function(){
		var cityID=$("#selectcityID").val();
		var url = "/weatherreport/cityID/"+cityID;
		window.location.href=url;
	});
	
	
});