 
function searchDept() {
	
	alert("hello");
	
    $.ajax({
        url: "/department/search",
        type: "GET",
        data: {
            name: $("#sdata").val()
        },
        success: function(data) {
            let rows = "";
            for(let i = 0; i < data.length; i++) {
                rows += "<tr>";
                rows += "<td>" + data[i].deptId + "</td>";
                rows += "<td>" + data[i].deptName + "</td>";
                rows += "<td>" + data[i].deptPhone + "</td>";
                rows += "<td>" + data[i].deptHead + "</td>";
                rows += "</tr>";
            }
            $("#result").html(rows);
        }
    });
}



