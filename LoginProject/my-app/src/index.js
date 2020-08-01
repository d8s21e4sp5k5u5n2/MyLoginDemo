
import React, { Component } from 'react';
import * as $ from 'jquery';
// import logo from './logo.svg';
import './App.css';


class login extends Component {

  componentDidMount(){

    this.login=this.login.bind(this);

  }

  login(){
    let userAccount = $('#userAccount').val();
    let password = $('#password').val();
    var xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    var postUrl = "http://localhost:8080/Demo-web/user/toLogin?userAccount="+userAccount+"&password="+password;
    xhr.open('post', postUrl, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send();
    xhr.onreadystatechange = function() {
      if (xhr.readyState ===4 && xhr.status === 200) {
        alert(xhr.responseText);
      }
    };

  }



  render() {
    return (
        <div className="login">
          <div className="app-body">
            <form name="login-form" className="login-form">
              <div className="line-div">
                <label className="text">账号:</label>
                <input placeholder="请输入你的账号" type="text" id="userAccount" name="userAccount" className="content"/>
              </div>
              <div className="line-div">
                <label className="text">密码:</label>
                <input placeholder='请输入密码' type="password" id="password" name="password" className="content"/>
              </div>
              <div className="line-div btn">
                <div className="left-div login">
                  <input className="def-btn login" type="button" name="login" value="登录" onClick={this.login} />
                </div>
                <div className="left-div register">
                  <input className="def-btn register" type="button"  name="register" value="没有账号，点击注册"/>
                </div>
              </div>
              <div className="line-div btn">
                <input className="def-btn forget-pass" type="button" name="forget-pass" value="忘记密码"/>
              </div>
            </form>

          </div>
        </div>
    );
  }
}

export default login;