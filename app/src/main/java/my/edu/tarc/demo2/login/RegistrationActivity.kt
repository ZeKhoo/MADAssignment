//package my.edu.tarc.demo2.login
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.text.TextUtils
//import android.widget.Toast
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
//import kotlinx.android.synthetic.main.activity_registration.*
//import my.edu.tarc.demo2.R
//
//class RegistrationActivity : AppCompatActivity() {
//
//    lateinit var auth: FirebaseAuth
//    var databaseReference :  DatabaseReference? = null
//    var database: FirebaseDatabase? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_registration)
//
//        auth = FirebaseAuth.getInstance()
//        database = FirebaseDatabase.getInstance()
//        databaseReference = database?.reference!!.child("profile")
//
//        register()
//    }
//
//    private fun register() {
//
//
//        buttonRegister.setOnClickListener {
//
//            if(TextUtils.isEmpty(editTextTextFirstName.text.toString())) {
//                editTextTextFirstName.setError("Please enter first name ")
//                return@setOnClickListener
//            } else if(TextUtils.isEmpty(editTextTextLastName.text.toString())) {
//                editTextTextLastName.setError("Please enter last name ")
//                return@setOnClickListener
//            }else if(TextUtils.isEmpty(editTextTextEmail.text.toString())) {
//                editTextTextEmail.setError("Please enter user name ")
//                return@setOnClickListener
//            }else if(TextUtils.isEmpty(editTextTextPassword.text.toString())) {
//                editTextTextPassword.setError("Please enter password ")
//                return@setOnClickListener
//            }
//
//
//            auth?.createUserWithEmailAndPassword(editTextTextEmail.text.toString(), editTextTextPassword.text.toString())
//                ?.addOnCompleteListener {
//                    if(it.isSuccessful) {
//                        val currentUser = auth?.currentUser
//                        val currentUSerDb = databaseReference?.child((currentUser?.uid!!))
//                        currentUSerDb?.child("firstname")?.setValue(editTextTextFirstName.text.toString())
//                        currentUSerDb?.child("lastname")?.setValue(editTextTextLastName.text.toString())
//
//                        Toast.makeText(this@RegistrationActivity, "Registration Success. ", Toast.LENGTH_LONG).show()
//                        finish()
//
//                    } else {
//                        Toast.makeText(this@RegistrationActivity, "Registration failed, please try again! ", Toast.LENGTH_LONG).show()
//                    }
//                }
//        }
//    }
//}