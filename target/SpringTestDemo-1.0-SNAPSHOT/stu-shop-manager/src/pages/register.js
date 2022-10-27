import React, {Component} from 'react';
import './login.css'
import axios from "axios";
import QS from "qs";

class Register extends Component {
    constructor(props){
        super(props);
        this.state={
            user:{}
        }
    }

    submit=()=>{
        if (this.state.user.username == null || this.state.user.password == null) {
            alert("用户名或密码不能为空")
        }
        else {
            axios.post("http://127.0.0.1:8080/demo/user/register",QS.stringify(this.state.user)).then((response)=>{
                if (!response.data){
                    alert("用户名不可用")
                }else {
                    window.localStorage.setItem("user",QS.stringify(response.data));

                    window.location="/admin";
                }
            })
        }
    }

    render() {
        return (
            <div id="login_box">
                <h2>REGISTER</h2>
                <div id="input_box">
                    <input type="text" placeholder="请输入用户名" id="username" onChange={(e)=>{this.state.user.username=e.target.value}}/>
                </div>
                <div className="input_box">
                    <input type="password" placeholder="请输入密码" id="password" onChange={(e)=>{this.state.user.password=e.target.value}}/>
                </div>
                <div className="input_box">
                    <input type="radio" value='0' name='sex' onChange={(e)=>{this.state.user.sex=e.target.value}}/><span>女</span>
                    <input type="radio" value='1' name='sex' onChange={(e)=>{this.state.user.sex=e.target.value}}/><span>男</span>
                </div>
                <button onClick={()=>{this.submit()}} id="login_btn">注册</button><br/>
                <button onClick={()=>{window.history.back()}} id="login_btn">返回</button>
            </div>
        );
    }
}

export default Register;