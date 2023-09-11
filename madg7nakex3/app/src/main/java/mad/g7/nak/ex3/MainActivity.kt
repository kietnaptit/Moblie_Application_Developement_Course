package mad.g7.nak.ex3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val geometrySpinner = findViewById<Spinner>(R.id.geometrySpinner)

        if(geometrySpinner != null){
            val geometryAdapter = ArrayAdapter.createFromResource(this, R.array.geometrys, android.R.layout.simple_spinner_item)
            geometryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            geometrySpinner.adapter = geometryAdapter
        }
        val colorSpinner = findViewById<Spinner>(R.id.colorSpinner)

        if(colorSpinner != null){
            val colorAdapter = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item)
            colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            colorSpinner.adapter = colorAdapter
        }

        //Method 1: Using submit button
//        val submitButton = findViewById<Button>(R.id.submit)
//        submitButton.setOnClickListener{
//            val geometry = geometrySpinner.selectedItem.toString()
//            val color = colorSpinner.selectedItem.toString()
//            val intent = Intent(this, OutputActivity::class.java)
//            intent.putExtra("geometry", geometry)
//            intent.putExtra("color", color)
//            startActivity(intent)
//
//        }

        //Method 2: NOT using Submit button
        geometrySpinner.setSelection(0)
        colorSpinner.setSelection(0)
        fun whenSelectionChange() {
            val selectedGeometry = geometrySpinner.selectedItem.toString()
            val selectedColor = colorSpinner.selectedItem.toString()

            if (selectedGeometry != "Select Geometry" && selectedColor != "Select Color") {
                val intent = Intent(this@MainActivity, OutputActivity::class.java)
                intent.putExtra("geometry", selectedGeometry)
                intent.putExtra("color", selectedColor)
                startActivity(intent)
            }
        }
        geometrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                whenSelectionChange()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        // Add a listener to the color spinner
        colorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                whenSelectionChange()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }




    }
}

