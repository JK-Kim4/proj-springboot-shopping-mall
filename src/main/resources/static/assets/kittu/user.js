var main = {
    init: function () {
        var _this = this;

        //회원 탈퇴
        $("#btn-resign").on("click", function () {
            if (confirm("정말로 탈퇴하시겠습니까?")) {
                _this.resign();
            }
        });
    },
    resign: function () {
        var userId = $("#userId").val();
        $.ajax({
            url : "/user/delete/" + userId,
            type : "DELETE",
            // dataType : "application/json; charset=utf-8"
            dataType : "text"
        }).done(function (data){
            console.log(data);
            alert("탈퇴가 완료되었습니다.")
            window.location.href = "/";
        }).fail(function (err){
            console.log(err);
        })
    }
}

main.init();