package mad.g7.nak.ex6

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mad.g7.nak.ex6.db.DbHandler
import mad.g7.nak.ex6.model.Member

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginTitle = findViewById<TextView>(R.id.loginTitle)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val userNameField = findViewById<EditText>(R.id.passwordInput)
        val passWordField = findViewById<EditText>(R.id.usernameInput)

        loginButton.setOnClickListener{

            val username = userNameField.text.toString()
            val password = passWordField.text.toString()

            val dbHandler = DbHandler(this)
            val loggedInMeber = dbHandler.checkLogin(username, password)
            if(loggedInMeber != null){
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("fullname", loggedInMeber.fullname)
                intent.putExtra("role", loggedInMeber.role)
//                intent.putExtra("loggedInMeber", loggedInMeber)
                startActivity(intent)
            }else{
                val rootView = findViewById<View>(android.R.id.content)
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0)
                Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }




}

