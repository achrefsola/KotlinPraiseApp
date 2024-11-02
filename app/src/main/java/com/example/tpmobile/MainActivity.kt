package com.example.tpmobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var leftMenu: NavigationView
    lateinit var bottommenu: BottomNavigationView
    val firstFragment = firstFragment()
    val secondFragment = secondFragment()
    val thirdFragment = thirdFragment()



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(this, "This app is developed by Sola Achref & Elghali Sami", Toast.LENGTH_SHORT).show()
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        leftMenu = findViewById(R.id.left_menu)
        bottommenu = findViewById(R.id.bottom_menu)

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        leftMenu.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.rate -> {
                    Toast.makeText(this, "rate clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.contact -> {
                    Toast.makeText(this, "contact clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.help -> {
                    Toast.makeText(this, "help clicked", Toast.LENGTH_SHORT).show()
                }
            }
            drawerLayout.closeDrawers()
            true
        }
        supportFragmentManager.beginTransaction() /// yafichi lpage loula sa3a
            .replace(R.id.framelayoutFragment, firstFragment)
            .commit()


        bottommenu.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayoutFragment,firstFragment)
                        .commit()

                    true
                }
                R.id.praise ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayoutFragment,secondFragment)
                        .commit()
                    true
            }
                R.id.prophet ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayoutFragment,thirdFragment)
                        .commit()
                    true
            }
                else -> false
            }



        }





           }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}


