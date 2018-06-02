$(function () {
    var code = 9999;

    function codes() {
        // var ranColor = '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).slice(-6); //随机生成颜色
        // alert(ranColor)
        var ranColor = '#fff'
        var ranColor2 = '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).slice(-6);
        var num1 = Math.floor(Math.random() * 100);
        var num2 = Math.floor(Math.random() * 100);
        code = num1 + num2;

        $("#code").html(num1 + "+" + num2 + "=?");
        if ($("#code").hasClass("nocode")) {
            $("#code").removeClass("nocode");
            $("#code").addClass("code");

        }
        $("#code").css('background', ranColor);
        $("#code").css('color', ranColor2);

    }
    codes()
    $("#code").on('click', codes)

    $("#btn").click(function () {

        var adminName = $("#adminName").val();
        var adminPass = $("#adminPass").val();
        var cheCk = $("#cheCk").val();
        var result = true;
        if (adminName == null || adminName == '') {
            alert("请输入账号");
            result = false;
        } else if (adminPass == null || adminPass == '') {
            alert("请输入密码");
            result = false;
        } else if (cheCk == null || cheCk == '') {
            alert("请输入验证码");
            result = false;
        } else {
            if ($(".authcode").val() == code && code != 9999) {
                $.ajax({
                    type: "post",
                    url: 'http://localhost:8080/b/login',
                    data: $('#from1').serialize(),//
                    async: true,
                    success: function (data) {
                        if (data.errorCode == '200') {
                            var a_id = data.Item.a_id;
                            var a_uuid = data.Item.a_uuid;
                            localStorage.setItem("a_id",a_id);
                            localStorage.setItem("a_uuid",a_uuid);
                            localStorage.setItem("adminName",$("#adminName").val());
                            window.location.href = '../backstage/index.html';
                        } else {
                            alert("用户名或密码错误");
                            codes()
                            result = false;
                        }
                    }, error: function (data) {
                        alert("网络错误")
                    }
                });

            } else {
                alert("验证码输入有误!");
                codes()

                result = false;
            }
        }

        return result;


    });
});




