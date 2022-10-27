import React from 'react'
import axios from 'axios'
import { useLocation } from 'react-router-dom'


import { Table, Space, Button } from "antd";
import { Component } from "react";
import Edit from './Edit'



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
                title: "性别",
                dataIndex: "sex",
                key: "sex"
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
        return (
            <>
                <Table dataSource={this.state.list} columns={this.getColumns()} rowKey={record=>record.id} />
            </>
        );
    }
}


