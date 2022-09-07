let main = {
    init : function (){
        let _this = this;

        $("#sendValidationNum").on('click', function (){
            let email = $("#inputEmail").val().trim();
            if(email != undefined && email != ''){
                _this.sendValidationNum(email);
            }else{
                alert("인증번호를 전송받을 이메일을 입력해 주세요.");
                $("#inputEmail").focus();
                return;
            }
        });

        $("#signUpButton").on('click', function (){
            _this.signUp();
        })
    },
    sendValidationNum : function (){

        let email = $("#inputEmail").val().trim();

        $.ajax({
            url : "/member/send/validation",
            method : "post",
            dataType : "json",
            contentType: 'application/json; charset=utf-8',
            data : email,
            success : function (data){
                console.log(data);

                if(data.result == true){
                    alert(email + "로 인증번호를 전송하였습니다.");
                    $("#validNum").val(data.valid);
                    return;
                }else{
                    alert("이메일 전송 실패");
                    return;
                }
            },
            error : function (x, h, r){
                console.log(x);
                alert("인증번호 전송 실패 [시스템 오류]");
                return;
            }

        });
    },
    signUp : function (){

    }
}

main.init();