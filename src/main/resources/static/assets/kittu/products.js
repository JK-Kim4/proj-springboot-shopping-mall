var main = {
    init : function(){
        var _this = this;
        console.log("init js file : " + _this);

        //save button 클릭 시 save 함수 실행
        $("#btn-save").on("click", function (){
            _this.save();
        });

        //상세보기 버튼
        $("#btn-detail").on("click", function (){
            _this.detail();
        });

        //구매하기 버튼
        $("#btn-buy").on("click", function (){
           _this.buy();
        });

        //장바구니
        $("#btn-cart-save").on("click", function (){
           _this.cartSave();
        });
    },
    cartSave : function (){

        $.ajax({
            type : "POST",
            url : "/api/cart/save",
            data : {
                productId : $("#productId").val()
            },
            contentType : "application/json; charset=utf-8"
        }).done(function (){
            alert("장바구니에 추가되었습니다.");
        }).fail(function (){
           alert("장바구니 추가에 실패하였습니다.");
        });
    },
    buy : function (){
      var data ={
          productId : $("#productId").val()
      };

      $.ajax({
          type : "POST",
          url : "/api/products/buy",
          data : data,
          contentType: "application/json; charset=utf-8"
      }).done(function (){
          alert("구매 목록 추가");
          location.href = "/"
      }).fail(function (){
          alert("구매 실패");
          window.location.reload();
      })


    },
    detail : function (){
        console.log($(this).prev().val());
    },
    //save function
    save : function (uploadResult){
        //변수 초기화
        /*var data = {
            name : $("#name").val(),
            desc : $("#desc").val(),
            fileId : $("#fileId").val(),
            seller : $("#seller").val()
        };*/

        var data = new FormData($("#uploadFileForm")[0]);
        //ajax요청
        $.ajax({
            type : "POST",
            url : "/api/product/insert",
            data : new FormData($("#uploadFileForm")[0]),
            encrypt : "multipart/form-data",
            processData: false,
            contentType: false,
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