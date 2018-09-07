
/**
	热点问题统计查询
*/
function search(startDate, endDate) {
    if (!checkEndTime(startDate, endDate)) return;
    var keywds = $("#keyword").val();
    var categoryCode = $(".showP").attr("value");
    $("#hotques").datagrid('load', {
        "start_time": startDate + "",
        "end_time": endDate + "",
        "keywords": keywds == "这里是搜索" ? "" : keywds,
        "categoryCode": categoryCode,
    });
}
/**
	比较时间的大小
*/
function checkEndTime(startTime, endTime) {
    console.log(startTime + "====" + endTime);
    if (startTime == null || startTime == ""
        || endTime == null || endTime == "") {
        return false;
    }
    startTime = startTime + "";
    endTime = endTime + "";
    var start = new Date(startTime.replace("-", "/"));
    var end = new Date(endTime.replace("-", "/"));
    if (end < start) {
        return false;
    }
    return true;
}

/**
	自动生成分类下拉框
*/
function genSelectTag(id, text) {
    var category_p = $('<p></p>');
    category_p.attr("value", id);
    category_p.text(text);
    category_p.on('click', function () {
        $(this).siblings().removeClass('active');
        $(this).addClass('active');
        $('.showP').html($(this).text());
        $('.showP').attr("value", $(this).attr("value"));
        var choseTmp = document.getElementsByClassName('chose1')[0];
        choseTmp.style.display = "none";
        var startDate = $(".textShow").attr("startDate");
        var endDate = $(".textShow").attr("endDate");
        search(startDate, endDate);
    });
    category_p.appendTo($("#categorySelect"));
}
(function ($) {
    $(function () {
        $(".showUp").on('click', function () {
            var chose = document.getElementsByClassName('chose1')[0];
            chose.style.display = (chose.style.display == "none") ? "block" : "none";
        });
        function zidingyi() {
            var vDiv = document.getElementsByClassName("zidingyi")[0];
            vDiv.style.display = (vDiv.style.display == "none") ? "block" : "none";
        };
        function inDate() {
            var vDiv = document.getElementsByClassName("inDate")[0];
            vDiv.style.display = (vDiv.style.display == "none") ? "block" : "none";
        };
        //获取当前日期（年月日），如：2017-12-18
        function getNowDate() {
            var dd = new Date();
            console.log(dd);
            var y = dd.getFullYear();
            //获取当前月份的日期，不足10补0
            var m = (dd.getMonth() + 1) < 10 ? '0' + (dd.getMonth() + 1) : (dd.getMonth() + 1);
            //获取当前几号，不足10补0
            var d = dd.getDate() < 10 ? '0' + dd.getDate() : dd.getDate();
            return y + '-' + m + '-' + d;
        };
        //计算多少天前后的日期
        //addDayCount：前后要计算的天数
        //startDate：开始日期，为空则表示当前日期
        function getDateAdd(addDayCount, startDate) {
            var dd = startDate && startDate.length > 0 ? new Date(startDate) : new Date();
            //获取addDayCount天后的日期
            dd.setDate(dd.getDate() + addDayCount);
            var y = dd.getFullYear();
            //获取当前月份的日期，不足10补0
            var m = (dd.getMonth() + 1) < 10 ? '0' + (dd.getMonth() + 1) : (dd.getMonth() + 1);
            //获取当前几号，不足10补0
            var d = dd.getDate() < 10 ? '0' + dd.getDate() : dd.getDate();
            var sDate = stringToTime(y + '-' + m + '-' + d);
            console.log(sDate);
            return sDate;
        };
        function stringToTime(string) {
            var f = string.split(' ', 2);
            return f;
        };
        // 输入框获取焦点事件
        $("#keyword").on('focus', function () {
            $("#keyword").val("");
        });
        // 选择推荐时间
        $(".show").on('click', function () {
            var chose = document.getElementsByClassName('chose')[0];
            chose.style.display = (chose.style.display == "none") ? "block" : "none";
            var vDiv = document.getElementsByClassName("inDate")[0];
            vDiv.style.display = "none";
        });
        $('.chose p').on('click', function () {
            $(this).siblings().removeClass('active');
            $(this).addClass('active');
            $('.textShow').html($(this).text());
            Index = $(this).index();
            if (Index == 3) {
                inDate();
                return;
            } else if (Index == 2) {
                var endDate = getDateAdd(0)[0];
                var startDate = getDateAdd(-30)[0];
            } else if (Index == 1) {
                var endDate = getDateAdd(0);
                var startDate = getDateAdd(-7);
            } else if (Index == 0) {
                var endDate = getDateAdd(0);
                var startDate = getDateAdd(-1);
            } else {
                alert("时间操作有误");
            }
            $(".textShow").attr("startDate", startDate);
            $(".textShow").attr("endDate", endDate);
            var choseTmp = document.getElementsByClassName('chose')[0];
            choseTmp.style.display = "none";
            search(startDate, endDate);
        });
        function tblInit() {
            var endDate = getDateAdd(0);
            var startDate = getDateAdd(-1);
            $(".textShow").attr("startDate", startDate);
            $(".textShow").attr("endDate", endDate);
            var keywds = $("#keyword").val();
            var categoryCode = $(".showP").attr("value");
            $('#hotques').datagrid({
                url: "${pageContext.request.contextPath}/workRep/getHotQues.action",
                queryParams: {
                    "start_time": startDate + "",
                    "end_time": endDate + "",
                    "keywords": keywds == "这里是搜索" ? "" : keywds,
                    "categoryCode": categoryCode
                }
            });
        }
        categoryInit();
        tblInit();
    });
}(jQuery));