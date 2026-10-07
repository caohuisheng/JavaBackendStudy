var arr = [1,2,3];
arr[10] = 10;


arr.push(10);
arr.splice(0,1);
//alert(arr);

main();
function main(){
//    f1();
//f5();
}

function f6(){
}

function f5(){
    document.write("3秒后跳转到首页");
    setTimeout(function(){
        alert("确定");
        location.href = "https://www.baidu.com";
    },2000);
}

function f4(){
//    setTimeout(function(){
//        alert("abc");
//    },1000);
    var a = 1;
    setInterval(function(){
        document.write(a);
        a++;
    },1000);
}

function f3(){
    window.set

}

function f2(){
    var flag = window.confirm("确认取消？");
    document.write(flag);
}

function f1(){
    var str = "  bac  ";
    alert(1 + trim(str) + 4);
    aa
    a
    a
}

