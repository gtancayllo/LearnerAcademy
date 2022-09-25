function selectClassroom(option){
	if(option.value !="0")
		document.location.href ="AssignClassroom.jsp?classroomId="+option.value;
}

function selectTeacher(option){
	if(option.value !="0")
		document.location.href ="AssignTeacher.jsp?classroomId="+option.value;
}