package com.sun.mvp.presenter

import com.sun.mvp.model.User

class LoginPresenter(val loginView: ILogin.ILoginView) : ILogin.ILoginPresenter {

    override fun login(email: String, password: String) {
        val user = User(email, password)
        if (user.isValidate) {
            loginView.onLoginSuccess("Login Success")
        } else {
            loginView.onError("Login fail")


        }
    }

}