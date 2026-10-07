var userNameInput = document.getElementById("username");
var checkUserName = function(){
    var username = userNameInput.value.trim();
    //var flag = username.length >= 6 && username.length <= 12;
    var reg = /^\w{6,12}$/;
    var flag = reg.test(username);
    alert(flag);
    if(flag){
        document.getElementById("username_err").style.display = 'none';
    }else{
        document.getElementById("username_err").style.display = '';
    }
    return flag;
}
userNameInput.onblur = checkUserName;

var passwordInput = document.getElementById("password");
var checkPassword = function(){
    var password = passwordInput.value.trim();
//    var flag = password.length >= 6 && password.length <= 12;
    var reg = /^\w{6,12}$/;
    var flag = reg.test(password);
    if(flag){
        document.getElementById("password_err").style.display = 'none';
    }else{
        document.getElementById("password_err").style.display = '';
    }
    return flag;
}
passwordInput.onblur = checkPassword;

var telInput = document.getElementById("tel");
var checkTel = function(){
    var tel = telInput.value.trim();
//    var flag = tel.length == 11;
    var reg = /^[1]\d{10}$/;
    var flag = reg.test(username);
    if(flag){
        document.getElementById("tel_err").style.display = 'none';
    }else{
        document.getElementById("tel_err").style.display = '';
    }
    return flag;
}
telInput.onblur = checkTel;

var regForm = document.getElementById("reg-form");
console.log(123);
regForm.onsubmit = function(){
    var flag = checkUserName() && checkPassword() && checkTel();
    return flag;
}



