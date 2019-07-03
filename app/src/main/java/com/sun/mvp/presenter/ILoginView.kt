package com.sun.mvp.presenter

interface ILogin {
    interface ILoginView{
        fun onLoginSuccess(message: String)
        fun onError(message: String)
    }

    interface ILoginPresenter{
        fun login(email:String,password:String)
    }

}