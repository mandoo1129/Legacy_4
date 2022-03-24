const reply = document.querySelector("#reply");
const num = document.querySelector("#num");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const replyResult = document.querySelector("#replyResult");
const del = document.querySelectorAll(".del") //CSS 클래스명


//UPDATE

replyResult.addEventListener("click", function(event){
    if(event.target.classList.contains('update')){
        console.log("update");
    }

});


//DELETE


replyResult.addEventListener("click", function(event){

    if(event.target.classList.contains('del')){
        let replyNum = event.target.getAttribute("data-num");

        //url "/noticeReply/delete" method: post parameter: replyNum
        //delete

        const xhttp = new XMLHttpRequest();
        xhttp.open("POST, "../noticeReply/delete");

        //요청 header 정보
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("replyNum="+replyNum);
        xhttp.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){
                console.log
            }
        }
        
    }


});
getList();

function getList(){
    const xhttp = new XMLHttpRequest();

    xhttp.open("GET", "../noticeReply/list?num="+num.value);

    xhttp.send();

    xhttp.onreadystatechange = function(){
        if(this.readyState==4 && this.status==200){
            console.log(this.responseText);
            replyResult.innerHTML = this.responseText.trim();
        }
    }
}


reply.addEventListener("click", function(){
    
    //console에 num, writer, contents 출력
    console.log(num.value);
    console.log(writer.value);
    console.log(contents.value);

    //JS에서 요청 객체 생성(준비)
    const xhttp = new XMLHttpRequest();

 
    //요청 정보 입력
    //open('method형식', 'url주소')
    xhttp.open("POST", "../noticeReply/add");


    //요청 header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //요청 전송
    //post 요청시 파라미터
    //send("이름=값&이름2=값2...")
    xhttp.send("num="+num.value+"&writer="+writer.value+"&contents="+contents.value);

    //응답 처리
    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            console.log(this.responseText);
            let result = this.responseText.trim();
            if(result=='1'){
                alert('댓글이 등록 되었습니다');
                getList();
            }else {
                alert('댓글 등록이 실패');
            }
        }
    }



});