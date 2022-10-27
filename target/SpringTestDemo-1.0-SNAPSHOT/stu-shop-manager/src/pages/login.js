import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Button, Checkbox, Form, Input } from 'antd';
import 'jquery/dist/jquery.min.js';
import 'bootstrap/dist/css/bootstrap.css'
import './login.css'
import React from 'react';
import axios from 'axios';
import QS from 'qs';


class App extends React.Component{
    constructor(props){
        super(props);
        this.state={
            checkcode:"http://127.0.0.1:8080/demo/checkcode/getCheckcode",
            str:""
        }
    }

    submit(){
        const fd={};
        fd.username=document.getElementById('username').value
        fd.password=document.getElementById('password').value

        console.log("上传的数据是"+QS.stringify(fd))
        //将表单数据序列化上传
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

    getCheck=()=> {
        // axios.get("http://127.0.0.1:8080/demo/checkcode/getCheckcodeStr").then((response) => {
        //     this.setState({
        //         checkcode: "http://127.0.0.1:8080/demo/checkcode/getCheckcode",
        //         str: response.data
        //     })
        //     console.log(this.state)
        // })
    }




    render (){
        return(
            <div id="login_box">
                <h2>LOGIN</h2>
                <div id="input_box">
                    <input type="text" placeholder="请输入用户名" id="username"/>
                </div>
                <div className="input_box">
                    <input type="password" placeholder="请输入密码" id="password"/>
                </div>
                <div className="input_box">
                    {/*<input type="text" placeholder="请输入验证码" id="checkcode"/>*/}
                    {/*<img src={this.state.checkcode} onClick={()=>{*/}
                        {/*this.getCheck()*/}
                    {/*}}></img>*/}
                </div>

                <button onClick={()=>{this.submit()}} id="login_btn">登录</button><br/>
                <button  onClick={()=>{window.location=window.location+'register'}} id="login_btn">注册</button><br/>
            </div>
        )
    }
};
export default App;