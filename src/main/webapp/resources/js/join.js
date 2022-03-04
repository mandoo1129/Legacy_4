//전역 변수
//var

const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");
const pw2 = document.getElementById("pw2");
const pwResult2 = document.getElementById("pwResult2");
const idx = document.getElementById("idx");
const idResult = document.getElementById("idResult")
const frm = document.getElementById("frm")
const btn = document.getElementById("btn")

let idCheck = false; //check OK: True, check X: False
let pwCheck = false;
let nameCheck = false;
let phoneCheck = false;
let emailCheck = false;

pw.addEventListener("change", function(){
    pwCheck = false;
    pw2.value = '';
    pwResult2.innerHTML='';
    pw2.focus();
});

phone.addEventListener('blur', function(){
    if(phone.value == ''){
        phoneCheck = false;
    }else {
        phone.check = true;
    }
});

email.addEventListener('blur', function(){
    if(email.value == ''){
        emailCheck = false;
    }else {
        email.check = true;
    }
});

name.addEventListener('blur', function(){
    if(name.value == ''){
        nameCheck = false;
    }else {
        name.check = true;
    }
});


btn.addEventListener("click", function(){
    console.log(idCheck);
    console.log(pwCheck);
    console.log(nameCheck);
    console.log(phoneCheck);
    console.log(emailCheck);

    if(idCheck && pwCheck && nameCheck && phoneCheck && emailCheck) {
         frm.submit();
    }else {
        alert('필수 요건을 확인하세요')
    }
});

idx.addEventListener("blur", function(){
    idCheck = true;
    let v = idx.value;

    if(v == ''){ //v.length == 0
        idResult.innerHTML = '필수 입력'
        idCheck = false;
    }else{
        idCheck = true;
    }
});

pw2.addEventListener("blur", function(){
   let v1 = pw.value;
   let v2 = pw2.value;
    let message = "비번이 일치하지 않음"

    if(v1 == v2){
        message = "비번이 일치 함"
        pwCheck = true;
    }else {
        pwCheck = false;
    }

    pwResult.innerHTML=message;
});

pw.addEventListener("keyup", function(){
    let length = pw.value.length;
    let message = '잘못된 비번';
    if(length>= 8 && length<=12) {
        message = '정상 비번';
    }

    pwResult.innerHTML=message;
});