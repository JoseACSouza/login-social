package com.betrybe.sociallogin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private val email:TextInputEditText by lazy { findViewById(R.id.email_text_input) }
    private val password:TextInputEditText by lazy { findViewById(R.id.password_text_input) }
    private val submit:Button by lazy { findViewById(R.id.login_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email.addTextChangedListener {
            submit.isEnabled = email.text.toString().isNotEmpty() && password.text.toString()
                .isNotEmpty()
        }

        password.addTextChangedListener {
            submit.isEnabled = email.text.toString().isNotEmpty() && password.text.toString()
                .isNotEmpty()
        }

    }

}
