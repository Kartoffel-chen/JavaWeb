window.onload = function () {
    //获取图片对象
    var img = document.getElementById("checkCode");
    var a = document.getElementById("checkCodeA");


    //鼠标点击事件
    img.onclick = function () {
        imgChange();
    }
    a.onclick = function () {
        imgChange();
    }

    function imgChange() {
        var date = new Date().getTime();
        img.src = "/test/CheckCode?" + date;
    }

}