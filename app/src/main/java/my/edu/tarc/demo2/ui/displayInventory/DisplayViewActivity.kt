package my.edu.tarc.demo2.ui.displayInventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.databinding.ActivityDisplayViewBinding
import my.edu.tarc.demo2.ui.model.Inventory

class DisplayViewActivity : AppCompatActivity() {
    private lateinit var dbref: DatabaseReference
    private lateinit var inventoryRecycleView: RecyclerView
    private lateinit var inventoryArrayList: ArrayList<Inventory>
    private lateinit var adapter: Adapter

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDisplayViewBinding

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_view)

        binding = ActivityDisplayViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inventoryRecycleView = binding.inventoryList
        inventoryRecycleView.layoutManager = LinearLayoutManager(this)
        inventoryRecycleView.setHasFixedSize(true)

        //Link to navigation
//        drawerLayout = binding.drawerLayout
//        val navController = findNavController(R.id.nav_host_fragment_content_search)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_searchActivity
//            ), drawerLayout
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

        inventoryArrayList = arrayListOf<Inventory>()

        getUserData()
    }

    private fun getUserData() {
//        dbref = FirebaseDatabase.getInstance().getReference("inventory")

        dbref = FirebaseDatabase.getInstance().getReference("inventory")

        dbref .addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (inventorySnapShot in snapshot.children){
                        val user = inventorySnapShot.getValue(Inventory::class.java)
                        inventoryArrayList.add(user!!)
                    }
                    inventoryRecycleView.adapter = Adapter(inventoryArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DisplayViewActivity, "Failed to read", Toast.LENGTH_SHORT).show()
            }

        })

    }


}