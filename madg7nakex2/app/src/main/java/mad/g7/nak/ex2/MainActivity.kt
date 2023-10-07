package mad.g7.nak.ex2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginTitle = findViewById<TextView>(R.id.loginTitle)
        val loginButton = findViewById<Button>(R.id.login)
        val userNameField = findViewById<EditText>(R.id.userName)
        val passWordField = findViewById<EditText>(R.id.passWord)

        loginButton.setOnClickListener{

            val username = userNameField.text.toString()
            val password = passWordField.text.toString()
            if(username == "admin" && password == "admin"){
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
//                Toast.makeText(this, "Login successfully" , Toast.LENGTH_SHORT).show()
            }else{
                val rootView = findViewById<View>(android.R.id.content)
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                Toast.makeText(this, "Wrong username or password" , Toast.LENGTH_SHORT).show()
            }
        }
    }




}