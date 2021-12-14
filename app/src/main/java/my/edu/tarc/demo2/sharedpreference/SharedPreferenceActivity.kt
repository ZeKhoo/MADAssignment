package my.edu.tarc.demo2.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import my.edu.tarc.demo2.R
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {

    lateinit var  sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        sharedPreferences = getSharedPreferences("SHARE_PREF",Context.MODE_PRIVATE)

        isRemembered = sharedPreferences.getBoolean("CHECKBOX",false)

        if(isRemembered){

            val intent = Intent(this, AnotherActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonLogin.setOnClickListener {
            val email:String = editTextTextEmail.text.toString()
            val password:String = editTextTextPassword.text.toString()
            val checked: Boolean = checkBox.isChecked

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("EMAIL", email)
            editor.putString("PASSWORD",password)
            editor.putBoolean("CHECKBOX",checked)
            editor.apply()

            Toast.makeText(this,"Login Successfully",Toast.LENGTH_LONG).show()

            val intent = Intent(this, AnotherActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}