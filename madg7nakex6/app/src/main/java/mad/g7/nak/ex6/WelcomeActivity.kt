package mad.g7.nak.ex6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import mad.g7.nak.ex6.model.Member

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val fullName = intent.getStringExtra("fullname")
        val role = intent.getStringExtra("role")
//        val member = intent.getParcelableExtra("loggedInMeber")

        val welcomeTextView = findViewById<TextView>(R.id.welcomeText)
        welcomeTextView.text = "Welcome user $fullName which role $role to application"
//        welcomeTextView.text = "Welcome user ${member.fullname} which role ${member.role} to application"
    }
}