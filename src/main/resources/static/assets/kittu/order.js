var orderMain = {
    init : function (){
        var _this = this;

        $("#btn-order").on("click", function (){
            $("#orderCount").val($("#selectedAmount").val());
            $("#orderForm").submit();
        });

    },
    order : function (){
        var data = {
            userId : $("#userId").val(),
            productId : $("#productId").val(),
            orderCount : $("#orderCount").val(),
            address : $("#address").val()
        };

    }
}

orderMain.init();