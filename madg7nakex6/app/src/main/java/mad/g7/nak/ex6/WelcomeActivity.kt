package mad.g7.nak.ex6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val fullName = intent.getStringExtra("fullname")
        val welcomeTextView = findViewById<TextView>(R.id.welcomeText)
        welcomeTextView.text = "Welcome $fullName to application"
    }
}