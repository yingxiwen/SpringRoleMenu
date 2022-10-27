import React from 'react';
import {Button} from 'antd';
import "antd/dist/antd.css";
import logo from './logo.svg';
import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import Login from './pages/login';
import List from './pages/admin/products/List';
import Edit from './pages/admin/products/Edit';
import Tree from './pages/admin/tree'


function App() {
  return (

    <React.StrictMode>
  <BrowserRouter>
    <Routes>
      <Route path='/' element={<Login/>}></Route>
      <Route path='/list' element={<List/>}></Route>

    </Routes>
  </BrowserRouter>
  </React.StrictMode>
  );
}

export default App;
