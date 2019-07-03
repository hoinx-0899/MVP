package com.sun.mvp.presenter

import android.util.Log
import com.sun.mvp.model.User

open class LoginPresenter2 : ILogin.ILoginPresenter {

    private lateinit var onLoginSuccess: (message: String) -> Unit
    fun setOnSuccess(onLoginSuccess: (message: String) -> Unit) {
        this.onLoginSuccess = onLoginSuccess
    }

    private lateinit var onLoginFail: (message: String) -> Unit
    fun setOnFail(onLoginFail: (message: String) -> Unit) {
        this.onLoginFail = onLoginFail
    }

    override fun login(email: String, password: String) {
        val user = User(email, password)
        if (user.isValidate) {
            if (::onLoginSuccess.isInitialized) {
                Log.d("PRESENTER", "SUCEES")
                onLoginSuccess.invoke("Login Success")
            }
        } else {
            if (::onLoginFail.isInitialized) {
                onLoginFail.invoke("Login fail")
            }

        }
    }

}