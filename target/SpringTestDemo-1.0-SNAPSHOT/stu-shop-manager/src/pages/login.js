import { LockOutlined, UserOutlined } from '@ant-design/icons';
import 'jquery/dist/jquery.min.js';
import 'bootstrap/dist/css/bootstrap.css'
import './login.css'
import React from 'react';
import axios from 'axios';
import QS from 'qs';
axios.defaults.withCredentials=true;



class App extends React.Component{
    constructor(props){
        super(props);
        this.state={
            str:"http://127.0.0.1:8080/demo/checkcode/getCheckcode?"
        }
    }

    submit(){
        const fd={};
        fd.username=document.getElementById('username').value
        fd.password=document.getElementById('password').value
        fd.checkcode=document.getElementById('checkcode').value

        console.log("上传的数据是"+QS.stringify(fd))
        // 将表单数据序列化上传
        axios.post("http://localhost:8080/demo/user/login",QS.stringify(fd)).then((response)=>{
            console.log("登录的返回值是"+ response)
            if(response.data==null||response.data==""){
                alert("用户名或密码错误")
            }else{

                window.localStorage.setItem("user",QS.stringify(response.data));

                window.location="/admin";
            }
        })

    }

    componentDidMount(){
        window.localStorage.removeItem("user");

    }

    randomCode=()=>{
        let code='123456789qwertyuiopasdfghjklzxcvbnm';
        let result='';
        for (let i = 0; i < 4; i++) {
            let number = Math.random()*code.length;
            result+=code.charAt(number)
        }
        return result;
    }






    render (){
        return(
            <>
            <div id="login_box">
                <h2>LOGIN</h2>
                <div id="input_box">
                    <input type="text" placeholder="请输入用户名" id="username"/>
                </div>
                <div className="input_box">
                    <input type="password" placeholder="请输入密码" id="password"/>
                </div>
                <div className="input_box">
                    <input type="text" placeholder="请输入验证码" id="checkcode"/>
                    <img src={this.state.str} onClick={()=>{
                        const str=this.state.str.split("?")[0]+"?num+"+Math.random();
                        this.setState({
                            str:str
                        })
                    }}/>
                </div>
                
                <button onClick={()=>{this.submit()}} id="login_btn">登录</button><br/>
                <button  onClick={()=>{window.location=window.location+'register'}} id="login_btn">注册</button><br/>
            </div>
                </>
        )
    }
};
export default App;

