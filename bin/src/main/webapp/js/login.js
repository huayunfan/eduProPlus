/**********************login页面的js****************************/ 
    var Slider = document.getElementsByClassName("slider")[0];
    var SliderA = Slider.getElementsByTagName("a");
    var SliderBar = Slider.getElementsByClassName("bar")[0];
    var register = document.getElementsByClassName("register")[0];
    var login = document.getElementsByClassName("login")[0];
    
    SliderA[0].onclick = function () {
      SliderBar.style.left = "0.69em";
      this.className = "active";
      SliderA[1].className = "";
      register.style.display = "block";
      login.style.display = "none";
    }
    
    SliderA[1].onclick = function () {
      SliderBar.style.left = "6.65em";
      this.className = "active";
      SliderA[0].className = "";
      register.style.display = "none";
      login.style.display = "block";
    }

            function toVaild(){
                var val = document.getElementById("name").value;
                var vcl = document.getElementById("password").value;
                if(val!="")
                { 
                	if (vcl!="")
                	{               
                        return true;
                	}
                	else{
                	alert("密码为空，提交失败！");
                    return false;
                   }
                	}
                else{
                	 alert("用户名为空，提交失败！");
                    return false;
                }
                
           }
     
     
     function Vaild()
     {
        	alert("你无法以超级管理员的身份登录！");
        	return false;       
     }
