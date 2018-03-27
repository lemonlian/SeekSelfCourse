
$(function () {
    $("#seek").click(function () {
        $.ajax({
            type: "POST",
            url: "/ReptileCourse/ReptileCourseServlet",
            dataType: "json",
            data:{
           studentId:$("#studentId").val()
            },
            success: function (json) {
                if (json.code) {
                    alert("请求成功！");
                    let str = '';
                    str += "<tr><th style='text-align:center;'>教学班</th><th style='text-align:center;'>教学课程</th><th style='text-align:center;'>类别</th><th style='text-align:center;'>教学班分类</th>" +
                        "<th style='text-align:center;'>选课状态</th><th style='text-align:center;'>上课教师</th><th style='text-align:center;'>地点</th><th style='text-align:center;'>上课时间</th>" +
                        "<th style='text-align:center;'>学生名单</th><th style='text-align:center;'>备注</th></tr>";
                    for(var i=0; i < json.data.length; i++) {
                        str += "<tr>";
                        str += "<td >" + json.data[i].teachingClass + "</td>";
                        str += "<td>" + json.data[i].courseIdAndCourseName + "</td>";
                        str += "<td>" +json.data[i].courseCategory + "</td>";
                        str += "<td>" +json.data[i].classClassification + "</td>";
                        str += "<td >" +json[i].courseSelectionState + "</td>";
                        str += "<td>" +json.data[i].courseTeacher + "</td>";
                        str += "<td>" +json.data[i].courseAddress + "</td>";
                        str += "<td>" + json.data[i].courseTime + "</td>";
                        str += "<td >" + json.data[i].courseStudent + "</td>";
                        str += "<td>" + json.data[i].remark + "</td>";
                        str += "<tr>";
                    }
                    $("#result").append(str);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {

                alert("XMLHttpRequest.status:"+XMLHttpRequest.status);

                alert("XMLHttpRequest.readyState:"+XMLHttpRequest.readyState);

                alert("textStatus"+textStatus);

            }
        });
    });





});


