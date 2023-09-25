package mad.g7.nak.ex5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar;


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.submenu_item1_1 -> Toast.makeText(this, "Add Player", Toast.LENGTH_SHORT).show()
            R.id.submenu_item1_2 -> Toast.makeText(this, "Edit Player", Toast.LENGTH_SHORT).show()
            R.id.submenu_item1_3 -> Toast.makeText(this, "Delete Player", Toast.LENGTH_SHORT).show()
            R.id.submenu_item2_1 -> Toast.makeText(this, "Personal Scoreboard", Toast.LENGTH_SHORT).show()
            R.id.submenu_item2_2 -> Toast.makeText(this, "Team Scoreboard", Toast.LENGTH_SHORT).show()
            R.id.submenu_item2_3 -> Toast.makeText(this, "Elo Scoreboard", Toast.LENGTH_SHORT).show()
            R.id.menu_item3 -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragmentContainer, SettingFragmentragment())
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
                return true
            }
        }
        return true
    }

}