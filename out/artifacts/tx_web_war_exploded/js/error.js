window.onload = function() {
    countDown(10);
    var jk = document.getElementById("jump");
    jk.onclick = function() {
        window.location.href= 'index.html';
    }
}

function countDown(secs) {
    var now = document.getElementById("secs_Now");
    now.innerText=secs;
    secs--;
    if(secs>0) {
        setTimeout("countDown("+secs+")",1000);
    }
}