package my.edu.tarc.demo2.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
import my.edu.tarc.demo2.R
//import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
//
//    var auth : FirebaseAuth? = null
//    var databaseReference :  DatabaseReference? = null
//    var database: FirebaseDatabase? = null
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
//
//        auth = FirebaseAuth.getInstance()
//        database = FirebaseDatabase.getInstance()
//        databaseReference = database?.reference!!.child("profile")
//
//        loadProfile()
    }

//    private fun loadProfile() {
//
//        buttonLogout.setOnClickListener {
//            auth?.signOut()
//            startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
//            finish()
//        }
//    }
}