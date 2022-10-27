import { Button, Modal } from 'antd';
import React, { useState } from 'react';
import axios from 'axios'
import QS from 'qs';

export default class  App extends React.Component{

    constructor(props){
        super(props);
        this.state={
            isModalOpen:false,
            user:this.props.message,
            changeUser:{}
        }
    }



    editOk=()=>{
        axios.post("http://127.0.0.1:8080/demo/user/edit",QS.stringify(this.state.user)).then((response)=>{
            this.setState({isModalOpen:false});
            if (response.data==0){
                alert("修改失败");
            } else {
            alert("修改成功")
            }
            window.location=window.location
        })
    }



    render(){
        return(
        <>
            <Button type="primary" onClick={()=>{this.setState({isModalOpen:true})}}>
                编辑
            </Button>
            <Modal cancelText="cancel" title="编辑" open={this.state.isModalOpen} onOk={()=>{this.editOk()}} onCancel={()=>{this.setState({isModalOpen:false})}}>
                姓名<input type="text" onChange={(e)=>{this.state.user.name=e.target.value}} defaultValue={this.state.user.name}/>
                <br/>
                性别<input type="radio" value="0" onChange={(e)=>{this.state.user.sex=e.target.value}} defaultChecked={this.state.user.sex=='0'?true:false} name="gender"/>女
                <input type="radio" value="1" onChange={(e)=>{this.state.user.sex=e.target.value}} defaultChecked={this.state.user.sex=='1'?true:false} name="gender"/>男
                <br/>
                用户名<input type="text" onChange={(e)=>{this.state.user.username=e.target.value}} defaultValue={this.state.user.username}/>
                <br/>
                密码<input type="password" onChange={(e)=>{this.state.user.password=e.target.value}} defaultValue={this.state.user.password}/>
            </Modal>
        </>
        )
    }
};
