import React, {Component} from 'react';
import {BrowserRouter as Router,Routes,Route} from 'react-router-dom';
import Login from './pages/login'
import Main from './main'
import List from "./pages/admin/products/List";
import Register from './pages/register'
import Error from './pages/error'
import RoleList from './pages/role/List'
import RoleMenu from './pages/menu/menutree'
import UserMenu from './pages/menu/userTree'



import { SmileOutlined } from '@ant-design/icons';
import { Button, Result } from 'antd';

const Index = () => (
    <Result
        icon={<SmileOutlined />}
        title="welcome to your lucky home"
        extra={<Button type="primary"
                       onClick={() => {
                          alert("welcome")
                       }}>Hello</Button>}
    />
);


class App extends Component {
    render() {
        return (

            <Router>
                <Routes>
                    <Route path='/' element={<Login/>}/>
                    <Route path='/register' element={<Register/>}/>
                    <Route path='/admin' element={<Main/>}>
                        <Route index element={<Index/>}/>
                        <Route path='list' element={<List/>}></Route>
                        <Route path='rolelist' element={<RoleList/>}/>
                        <Route path='usermenu' element={<UserMenu/>}/>
                        <Route path='rolemenu' element={<RoleMenu/>}/>
                    </Route>
                    <Route path='*' element={<Error/>}/>
                </Routes>
            </Router>


        );
    }
}

export default App;