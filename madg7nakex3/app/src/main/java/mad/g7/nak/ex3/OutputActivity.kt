package mad.g7.nak.ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OutputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val geometry = intent.getStringExtra("geometry")
        val color = intent.getStringExtra("color")
        val outputTextView = findViewById<TextView>(R.id.outputTextView)
        outputTextView.text="This $geometry has color $color"
    }
}