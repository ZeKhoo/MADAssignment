package my.edu.tarc.demo2.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.databinding.ActivityDisplayViewBinding
import my.edu.tarc.demo2.ui.model.Inventory

class DisplayViewActivity : AppCompatActivity() {
    private lateinit var dbref: DatabaseReference
    private lateinit var inventoryRecycleView: RecyclerView
    private lateinit var inventoryArrayList: ArrayList<Inventory>

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDisplayViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_view)

        binding = ActivityDisplayViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inventoryRecycleView = binding.inventoryList
        inventoryRecycleView.layoutManager = LinearLayoutManager(this)
        inventoryRecycleView.setHasFixedSize(true)

        inventoryArrayList = arrayListOf<Inventory>()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("inventory")

//        dbref.addValueEventListener(object: ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if(snapshot.exists()){
//                    for (inventorySnapShot in snapshot.children){
//                        val user = inventorySnapShot.getValue(Inventory::class.java)
//                        inventoryArrayList.add(user!!)
//
//
//                    }
//
//                    inventoryRecycleView.adapter = Adapter(inventoryArrayList)
//                }
//            }

//        })

    }


}