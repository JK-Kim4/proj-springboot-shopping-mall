var orderMain = {
    init : function (){
        var _this = this;

        $("#btn-order").on("click", function (){
            $("#orderCount").val($("#selectedAmount").val());
            $("#orderForm").submit();
        });

        $("#btn-pay").on("click", function (){
           $("#payForm").submit();
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