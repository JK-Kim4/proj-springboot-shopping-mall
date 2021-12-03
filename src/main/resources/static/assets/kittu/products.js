var main = {
    init : function(){
        var _this = this;
        console.log("init js file : " + _this);

        //save button 클릭 시 save 함수 실행
        $("#btn-save").on("click", function (){
            console.log("save btn clicked");
           _this.save();
        });


    },
    //save function
    save : function (){
        //변수 초기화
        var data = {
            name : $("#name").val(),
            desc : $("#desc").val(),
            picture : $("#picture").val(),
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