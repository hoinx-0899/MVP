package com.sun.mvp.presenter

import com.sun.mvp.model.User

open class LoginPresenter3 : ILogin.ILoginPresenter {

    open fun onSuccess(message: String) {}
    open fun onFail(message: String) {}

    override fun login(email: String, password: String) {
        val user = User(email, password)
        if (user.isValidate) {
            onSuccess("Login Success")
        } else {
            onFail("LoginFail")

        }
    }

}