package com.kampusmerdeka.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.tb_addContact -> Toast.makeText(this, "Add Contact diklik", Toast.LENGTH_LONG).show()
            R.id.tb_favorit -> Toast.makeText(this, "Favorite diklik", Toast.LENGTH_LONG).show()
            R.id.tb_setting -> Toast.makeText(this, "Settings diklik", Toast.LENGTH_LONG).show()
            R.id.tb_feedback -> Toast.makeText(this, "Feedback diklik", Toast.LENGTH_LONG).show()
            R.id.tb_close -> finish()
        }
        return true
    }
}