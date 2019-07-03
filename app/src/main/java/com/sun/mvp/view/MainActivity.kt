package com.sun.mvp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sun.mvp.R
import com.sun.mvp.presenter.ILogin
import com.sun.mvp.presenter.LoginPresenter
import com.sun.mvp.presenter.LoginPresenter2
import com.sun.mvp.presenter.LoginPresenter3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ILogin.ILoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerListner()
    }

    private fun registerListner() {
        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        //Cach 1 call back using interface
        val loginPresenter = LoginPresenter(this)
        loginPresenter.login(edtEmail.text.toString(), edtPassword.text.toString())

        //Cach 2 using higher order function
        val loginPresenter2 = LoginPresenter2()
        loginPresenter2.setOnSuccess {
            Toast.makeText(this, it + "2", Toast.LENGTH_LONG).show()

        }
        loginPresenter2.setOnFail {
            Toast.makeText(this, it + "2", Toast.LENGTH_LONG).show()

        }
        loginPresenter2.login(edtEmail.text.toString(), edtPassword.text.toString())

        //cach 3 using open function
        val loginPresenter3 = object : LoginPresenter3() {
            override fun onSuccess(message: String) {
                Toast.makeText(applicationContext, message + "3", Toast.LENGTH_LONG).show()

            }

            override fun onFail(message: String) {
                Toast.makeText(applicationContext, message + "3", Toast.LENGTH_LONG).show()

            }
        }
        loginPresenter3.login(edtEmail.text.toString(), edtPassword.text.toString())

    }


    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }

}
