package my.edu.tarc.demo2.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_another.*
import kotlinx.android.synthetic.main.activity_shared_preference.*
import my.edu.tarc.demo2.R

class AnotherActivity : AppCompatActivity() {

    lateinit var preferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        buttonLogout.setOnClickListener {

            val editor:SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, SharedPreferenceActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}