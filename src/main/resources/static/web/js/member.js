let main = {
    init : function (){
        let _this = this;

        $("#sendValidationNum").on('click', function (){
            let email = $("#inputEmail").val().trim();
            if(email != undefined && email != ''){
                $("#validationDiv").show();
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
                    $("#validFlag").val("Y");
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

        let validFlag = $("#validFlag").val();
        let userValid = $("#inputValidation").val();
        let validNum = $("#validNum").val();
        let email = $("#inputEmail").val();
        let name = $("#inputName").val();
        let password = $("#inputPassword").val();
        let data = {};

        if(validFlag == '' || validFlag == undefined || validFlag == 'N' || userValid == '' || userValid == undefined){
            alert("인증번호 확인을 완료해 주세요.");
            return;
        }
        if(userValid != validNum){
            alert("인증번호가 일치하지 않습니다. 확인 후 다시 시도해 주세요.");
            return;
        }

        data.email = email;
        data.password = password;
        data.name = name;

        $.ajax({
            url : "/member/signUp",
            method: "post",
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(data),
            success : function (result){
                console.log(result);
            },
            error : function (x,h,r){
                console.log(x);
                alert("시스템 에러 발생");
                return;
            }
        });
    }
}

main.init();