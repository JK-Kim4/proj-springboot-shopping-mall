let main = {
    init : function (){
        let _this = this;

        $("#sendValidationNum").on('click', function (){
            let email = $("#inputEmail").val();
            if(email != undefined && email != ''){
                _this.sendValidationNum(email);
            }else{
                alert("인증번호를 전송받을 이메일을 입력해 주세요.");
                $("#inputEmail").focus();
                return;
            }
        });
    },
    sendValidationNum : function (email){

        $.ajax({
            url : "/member/api/send/validation",
            method : "post",
            dataType : "json",
            data : email,
            success : function (result){
                console.log(result);

                if(result == true){
                    alert(email + "로 인증번호를 전송하였습니다.");
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
    }
}

main.init();