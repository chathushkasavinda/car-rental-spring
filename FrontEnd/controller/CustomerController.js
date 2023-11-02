
    $.ajax({
        url:baseURL + "login",
        method:"get",
        async:false,
        dataType:"json",
        contentType:"application/json",
        success:function (res){
            console.log("success");
        }
    })

    function manageHomePage() {

        $("#home").fadeIn();
        $("#home").attr("style", "display : block !important");
        $("#manageCar").attr("style", "display : none !important");
        $("#manageCart").attr("style", "display : none !important");
        $("#manageRent").attr("style", "display : none !important");
        $("#payments").attr("style", "display : none !important");

    }


