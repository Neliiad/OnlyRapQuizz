package com.onlyrap.quizz


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle

import com.example.quizz.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1 -> Toast.makeText(applicationContext,
                    "Website", Toast.LENGTH_SHORT).show()

                R.id.miItem2 -> Toast.makeText(applicationContext,
                    "Instagram", Toast.LENGTH_SHORT).show()

                R.id.miItem3 -> Toast.makeText(applicationContext,
                    "Twitter", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)




    }
    fun onClickBtnPlay(view:View){
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    fun onClickBtnPlayMedium(view:View){
        val intent = Intent(this, QuizMedium::class.java)
        startActivity(intent)
    }

    fun onClickBtnPlayHard(view:View){
        val intent = Intent(this, QuizHard::class.java)
        startActivity(intent)
    }
}

