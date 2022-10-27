import React, {Component} from 'react';
import {BrowserRouter as Router,Routes,Route} from 'react-router-dom';
import Login from './pages/login'
import Main from './main'
import List from "./pages/admin/products/List";
import Register from './pages/register'
import Error from './pages/error'



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
                    </Route>
                    <Route path='*' element={<Error/>}/>
                </Routes>
            </Router>


        );
    }
}

export default App;