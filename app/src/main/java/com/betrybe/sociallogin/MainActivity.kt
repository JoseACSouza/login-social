package com.betrybe.sociallogin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val email:TextInputEditText by lazy { findViewById(R.id.email_text_input) }
    private val emailError: TextInputLayout by lazy { findViewById(R.id.email_text_input_layout) }
    private val password:TextInputEditText by lazy { findViewById(R.id.password_text_input) }
    private val passwordError:TextInputLayout
        by lazy { findViewById(R.id.password_text_input_layout) }
    private val submit:Button by lazy { findViewById(R.id.login_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submit.setOnClickListener(this)
        email.addTextChangedListener {
            submit.isEnabled = email.text.toString().isNotEmpty() && password.text.toString()
                .isNotEmpty()
        }

        password.addTextChangedListener {
            submit.isEnabled = email.text.toString().isNotEmpty() && password.text.toString()
                .isNotEmpty()
        }
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.login_button -> {
                val emailRegex = "^[A-Za-z0-9.]+@[A-Za-z]+.[A-Za-z]+"
                val validateEmail = email.text.toString().matches(emailRegex.toRegex())
                val validatePassword = password.text.toString().length < 4
                if (!validateEmail){
                    emailError.error = "Email inválido"
                } else {
                    emailError.error = null
                }
                if (validatePassword){
                    passwordError.error = "Senha deve ter mais de 4 caracteres"
                } else {
                    passwordError.error = null
                }
                return
            }
        }
    }

}
