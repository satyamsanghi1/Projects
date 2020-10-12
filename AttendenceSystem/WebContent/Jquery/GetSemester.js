$(document).ready(
function(){
	$.getJSON("GetAllSemesterJSON",{ajax:true},function(data)
		{
			$('#semester').append($('<option>').val('-Select-').text('-Select-'));
			$.each(data,function(i,item)
			{
				$('#semester').append($('<option>').val(item.SEMESTERID).text(item.SEMESTERNAME));
			});
		});
});