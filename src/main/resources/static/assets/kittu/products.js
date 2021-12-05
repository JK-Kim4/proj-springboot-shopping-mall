var main = {
    init : function(){
        var _this = this;
        console.log("init js file : " + _this);

        $("#btn-file-upload").on("click", function (){
            _this.upload();
        });

        //save button 클릭 시 save 함수 실행
        $("#btn-save").on("click", function (){
            _this.save();
        });
    },
    //file upload
    upload : function (){
        var result = 0;
        var data = new FormData($("#uploadFileForm")[0]);
        console.log("data : " + data);
        $.ajax({
            type : "POST",
            url : "/util/file/upload",
            data : new FormData($("#uploadFileForm")[0]),
            encrypt : "multipart/form-data",
            processData: false,
            contentType: false,
            cache : false,
            success : function (resultData){
                console.log("return data success : " + resultData);
                alert("이미지 업로드 성공");
                $("#fileId").val(resultData);
            },
            error : function (){

            }
        })
    },
    //save function
    save : function (uploadResult){
        //변수 초기화
        var data = {
            name : $("#name").val(),
            desc : $("#desc").val(),
            fileId : $("#fileId").val(),
            seller : $("#seller").val()
        };
        //ajax요청
        $.ajax({
            type : "POST",
            url : "/api/product/insert",
            dataType : "json",
            contentType : "application/json; charset=UTF-8",
            data : JSON.stringify(data)
        }).done(function (){
            alert("상품이 등록되었습니다.")
            window.location.href = "/";
        }).fail(function (){
            alert("상품 등록에 실패하였습니다. 다시 시도해주세요");
            window.location.href = "/";
        })
    }
}

main.init();