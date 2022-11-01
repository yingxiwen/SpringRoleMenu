import {
    AppstoreOutlined,
    BarChartOutlined,
    CloudOutlined,
    ShopOutlined,
    TeamOutlined,
    UploadOutlined,
    UserOutlined,
    VideoCameraOutlined,
} from '@ant-design/icons';
import {Button, Layout, Menu} from 'antd';
import React from 'react';
import ContentApp from './App';
import {BrowserRouter, Routes, Route, Outlet, Link, Navigate} from 'react-router-dom';
import axios from "axios";
import qs from 'qs'
import './main.css'


const {SubMenu} = Menu


const {Header, Content, Footer, Sider} = Layout;

// const item = [
//     {
//         url: "/admin",
//         name: "name",
//         child: []
//     }
// ]


export default class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            item: [
                {
                    url: "/",
                    name: "首页"
                }
            ]
        }

    }




    componentDidMount() {

        axios.post("http://127.0.0.1:8080/demo/user/getMenuList", window.localStorage.getItem("user")).then((response) => {
            if (response.data != null || response.data != "") {

            this.setState({
                item: response.data,
            });
        }

            console.log(response);
            console.log(window.localStorage.getItem("user"));
            let user = qs.parse(window.localStorage.getItem("user"));
            user.menus=response.data;
            window.localStorage.setItem("user",qs.stringify(user));//将权限列表加入用户对象中
            console.log(qs.parse(window.localStorage.getItem("user")))
        })
            .catch(function (error) {
                console.log(error);
            })
    }


    render() {
        if (!window.localStorage.getItem("user")) {
            alert("请先登录")
            window.location="/"
            return
        }


        return (
            <Layout hasSider>
                <Sider
                    style={{
                        overflow: 'auto',
                        height: '100vh',
                        position: 'fixed',
                        left: 0,
                        top: 0,
                        bottom: 0,
                        // backgroundColor: "#1890ff"
                    }}
                >
                    <div className="logo"/>
                    {/*<Menu theme="dark" mode="inline" defaultSelectedKeys={['4']} items={items} />*/}
                    <Menu
                        mode="inline" //导航栏列出来显示
                        // mode="horizontal"  //导航栏隐藏起来显示
                        defaultSelectedKeys={['home']}

                        // selectedKeys={[this.props.current]}
                        theme="dark"
                        id="navBarMenu"
                    >


                        {
                            this.state.item.map((v, k) => {
                                // console.log(v.child);

                                if (v.child == null || v.child.length == 0 || v.child == "") {
                                    return (
                                        <Menu.Item key={k} icon={<TeamOutlined/>}>
                                            <Link to={v.url}>{v.name}</Link>
                                        </Menu.Item>
                                    )
                                } else {
                                    return (
                                        <SubMenu key={k} title={v.name}>
                                            {
                                                v.child.map((value, key) => {
                                                    return (
                                                        <Menu.Item key={k+'item'+key}>
                                                            <Link to={value.url}>{value.name}</Link>
                                                        </Menu.Item>
                                                    )
                                                })
                                            }
                                        </SubMenu>
                                    )
                                }
                            })
                        }
                    </Menu>

                </Sider>
                <Layout
                    className="site-layout"
                    style={{
                        marginLeft: 200,
                    }}
                >
                    <Header
                        className="site-layout-background"
                        style={{
                            padding: 0,
                        }}
                    >
                        <Button
                            type="danger"
                            onClick={() => {
                                window.localStorage.clear();
                                window.location = "/"
                            }}>
                            退出登录
                        </Button>
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <Button
                            type="danger"
                            onClick={() => {
                                window.location = "/admin"
                            }}>
                            主页
                        </Button>
                    </Header>
                    <Content
                        style={{
                            margin: '24px 16px 0',
                            overflow: 'initial',
                        }}
                    >
                        <Outlet/>

                    </Content>

                </Layout>
            </Layout>
        )

    }
}

