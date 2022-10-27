import React from 'react'
import axios from 'axios'
import { useLocation ,Navigate} from 'react-router-dom'
import qs from 'qs'
import {getReady} from "../../../auth";


import { Table, Space, Button } from "antd";
import { Component } from "react";
import Edit from './Edit'


// function getReady() { // 判断用户有无权限 权限列表在main中已经添加
//     let user = qs.parse(window.localStorage.getItem("user"));
//     let loca=window.location.origin
//     console.log(window.location)
//     if (!user.menus) {
//         return false
//     }
//     for (let i = 0; i < user.menus.length; i++) {
//         if(loca+user.menus[i].url==window.location.href){
//
//             return true
//         }
//
//     }
//     return false
// }
var uri="http://127.0.0.1:8080/demo/user/deleteUserById/";
export default class TableList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            list:[],

        };
    }

    componentDidMount(){

        axios.get("http://127.0.0.1:8080/demo/user/getUserList")
            .then((response)=>{
                console.log(window.location)
                console.log(response.data);
                console.log(qs.parse(window.localStorage.getItem("user")))
                this.setState({
                    list:response.data,
                })
            })
            .catch(function (error) {
                console.log(error);
            })
    }

    getColumns() {
        let self = this;
        return [
            {
                title: "姓名",
                dataIndex: "name",
                key: "name"
            },
            {
                title: "用户名",
                dataIndex: "username",
                key: "username"
            },
            {
              title:"性别",
              dataIndex:"sex",
              key:"sex",
              render:(record)=>{
                  if (record=='0'){
                      return '女'
                  } else if (record == '1') {
                      return '男'
                  }else {
                      return '未知'
                  }
              }
            },
            //  操作列
            {
                title: "操作",
                key: "action",
                render: (text, record) => (
                    <Space size="middle">
                        {/*<Button*/}
                            {/*type="primary"*/}
                            {/*onClick={() => {*/}
                                {/*self.edit(record);*/}
                            {/*}}>*/}
                            {/*编辑*/}
                        {/*</Button>*/}
                        <Edit message={record}/>
                        <Button
                            type="danger"
                            onClick={() => {
                                self.delete(record.id);
                            }}>
                            删除
                        </Button>
                    </Space>
                )
            }
        ];
    }
    // // 编辑
    // edit(data) {
    //     console.log("编辑", data);
    //
    // }
    // 删除
    delete(id) {
        axios.post(uri+id).then((response)=>{
            if(response.data==0){
                alert("删除失败");
            }else {
                console.log(response.data);
                alert("成功删除"+response.data+"个用户");
            }
            window.location=window.location
        })
    }
    render() {
        if(!getReady()){
            alert("没有权限")
           return <Navigate to='/admin'/>
        }
        return (
            <>
                <Table dataSource={this.state.list} columns={this.getColumns()} rowKey={record=>record.id} />
            </>
        );
    }
}

// var uri="http://127.0.0.1:8080/demo/user/deleteUserById/";
// class A extends React.Component{
//     constructor(props){
//         super(props);
//     }
//     delete(id){
//         console.log(id)
//         axios.post(uri+id).then((response)=>{
//             if(response.data==0){
//                 alert("删除失败");
//             }else {
//                 console.log(response.data);
//                 alert("成功删除"+response.data+"个用户");
//             }
//             window.location=window.location
//         })
//     }
//
//     render(){
//         return <button onClick={()=>{this.delete(this.props.id)}}>删除</button>
//     }
// }
// export default class List extends React.Component {
//     constructor(props){
//         super(props);
//         this.state= {
//             list:[]
//         }
//     }
//
//     componentDidMount(){
//         axios.get("http://127.0.0.1:8080/demo/user/getUserList")
//                 .then((response)=>{
//                     console.log(window.location)
//                     console.log(response.data);
//                     this.setState({
//                         list:response.data
//                     })
//                 })
//                 .catch(function (error) {
//                     console.log(error);
//                 })
//     }
//
//
//     render() {
//         return (
//             <ul>
//                 {
//                     this.state.list.map((v,k)=>{
//                         return(
//                             <li key={k}>
//                                 {v.id}==>{v.username}==>{v.password}
//                                 <A id={v.id}/>
//                             </li>
//
//                         )
//                     })
//                 }
//             </ul>
//         )
//     }
// }
