package my.edu.tarc.demo2.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.databinding.ActivitySearchBinding
import my.edu.tarc.demo2.ui.New_Inventory.NewInventory

class SearchActivity : AppCompatActivity(){

    //    private var buttons =  arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())
    private var buttons = arrayOf<Array<Button>>()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySearchBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var db: DatabaseReference

    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    interface MyInterface{
        fun myAction()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("inventory")

        // Write a message to the database
//        val database = Firebase.database
//        val myRef = database.getReference("inventory")
//
//        myRef.setValue("Hello, World!")

        binding = ActivitySearchBinding.inflate(layoutInflater)
//        binding = ActivitySearchBinding.inflate(inflater, container, false)
        setContentView(binding.root)
//
//        setSupportActionBar(binding.app_bar_search)
//
//        //Link to navigation
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

        //Toggle

//        populateButton()

//        actionBar.title = "Search"

        //Link frame into other fragment
        var fManager = supportFragmentManager
        var tx = fManager.beginTransaction()
        tx.add(R.id.frag, SearchFragDetails())
        tx.addToBackStack(null)
        tx.commit()

        //Declare contant
        var choice: String? = null
        var item_name: String?

        //Transfer valeu from activity to fragment
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = SearchFragDetails()

        //Radio Button Error Message
        binding.radioGroup.setOnCheckedChangeListener{radioGroup, i ->
            var rb = findViewById<RadioButton>(i)

            if (rb != null){
                choice = rb.text.toString()
            }
            else{
                Toast.makeText(this,"Please select Serial Number/ Part Number",Toast.LENGTH_SHORT).show();
            }
        }

        //setActivity with details
        binding.buttonDetails.setOnClickListener {

            //edittextName error message
            if(binding.editTextItemName1.text.isNotEmpty()){
                item_name = binding.editTextItemName1.text.toString()
            }else{
                binding.editTextItemName1.error = getString(R.string.error)
                return@setOnClickListener
            }

            //Pass chocie and item_name value
            val mBundle = Bundle()
            mBundle.putString("choice", choice)
            mBundle.putString("itemName", item_name)
            mFragment.arguments = mBundle
            mFragmentTransaction.add(R.id.frag, mFragment).commit()

            readData(item_name!!)

            var tx = fManager.beginTransaction()
            tx.replace(R.id.frag, SearchFragDetails())
            tx.addToBackStack(null)
            tx.commit()
        }

//        binding.buttonTransaction.setOnClickListener {
//            var tx = fManager.beginTransaction()
//            tx.replace(R.id.frag, SearchFragDetails())
//            tx.addToBackStack(null)
//            tx.commit()
//        }

        binding.buttonClear.setOnClickListener{
            binding.editTextItemName1.text.clear()
            binding.radioGroup.clearCheck()
            Toast.makeText(this,"Clear Successful!!",Toast.LENGTH_SHORT).show();
        }

//        //Toggle Bar Animation
//        val toggle = ActionBarDrawerToggle(this, drawerLayout, binding.appBarSearch.toolbar,
//            R.string.navigation_drawer_open, R.string.nav_drawer_close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
    }

    private fun readData(itemName: String) {
        val database: DatabaseReference
        database = Firebase.database.reference

        database.child("inventoryy").child(itemName)
    }

    @Override
    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else {
            super.onBackPressed()
        }
    }

    companion object{
        const val CHOICE = "my.edu.tarc.demo2.ui.search.choice"
        const val ITEM_NAME = "my.edu.tarc.demo2.ui.search.item_name"
    }



//    override fun myAction() {
//
//
//        fun setListener(listener: SearchFragDetails.MyInterface){
//            this.listener = listener
//        }
//    }

        //Place fragment details into search Activity
//        val detailsFragment: SearchFragDetails
//        val manager: FragmentManager = supportFragmentManager
//        manager.beginTransaction().replace(R.id.fragment_search_frag_details, detailsFragment, detailsFragment.tag()).commit()

        //Place fragment transaction into search Activity
//        val transFragment: SearchFragTransaction
//        manager.beginTransaction().replace(R.id.fragment_search_frag_transaction, transFragment, transFragment.tag()).commit()

    }

//    private fun populateButton() {
//        val table: TableLayout = findViewById<TableLayout>(R.id.map_layout)
//        var param: TableLayout.LayoutParams
//
//        for (row in 1..Companion.NUM_ROWS) {
//            val tableRow: TableRow = TableRow(this)
//            tableRow.setLayoutParams(
//                TableLayout.LayoutParams(
//                    TableLayout.LayoutParams.MATCH_PARENT,
//                    TableLayout.LayoutParams.MATCH_PARENT,
//                    1.0f
//                )
//            )
//            table.addView(tableRow)
//
//
//            for (col in 1..Companion.NUM_COLUMNS) {
//                val FINAL_COL = col
//                val FINAL_ROW = row
//
//
//                val button: Button = Button(this)
//                button.setLayoutParams(
//                    TableRow.LayoutParams(
//                        TableRow.LayoutParams.MATCH_PARENT,
//                        TableRow.LayoutParams.MATCH_PARENT,
//                        1.0f
//                    )
//                )
//
//
//                //Set button name
//                button.setText("" + row + "," + col)
//
//                //Make text not clip on small button
//                button.setPadding(0, 0, 0, 0)
//
//                button.setOnClickListener{ view ->
//                    //Does not scale image.
//                    button.setBackgroundResource(R.drawable.ic_menu_camera)
////                    gridButtonCLicked(FINAL_COL, FINAL_ROW)
//                }
//
//                tableRow.addView(button)
//                buttons[row][col] = button
//            }
//        }
//    }

//    companion object {
//        const val CHOICE: String? = null
//        const val ITEM_NAME: String? = null
//        const val NUM_ROWS: Int = 5
//        const val NUM_COLUMNS: Int = 5
//    }

//    fun gridButtonCLicked(col: Int, row: Int){
//        Toast.makeText(this, "Button cliecked: "+row+","+col, Toast.LENGTH_SHORT).show()
//        val button: Button = buttons[row][col]
//
//        //Lock Button Size
//        lockButtonSize()
//
//        //Does not scale image.
//        button.setBackgroundResource(R.drawable.ic_menu_camera)
//
//        //Scale image to button
//        var newWidth: Int = button.getWidth()
//        var newHeight: Int = button.getHeight()
//        val originalBitmap: Bitmap =  BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_pin_drop_24)
//        val scaledBitmap: Bitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true)
//        val resource: Resources = getResources()
//        button.setBackgroundResource(R.drawable.ic_baseline_pin_drop_24)
//        //button.background = ContextCompat.getDrawable(this, R.drawable.ic_baseline_pin_drop_24\)
//
//        //Change text in the button
//        button.setText(""+col)
//
//        //Disable click on button
//        button.isEnabled = false
//        button.isClickable = false
//    }
//
//    private fun lockButtonSize() {
//        for (i in 0..NUM_ROWS){
//            for (j in 0..NUM_COLUMNS){
//                val button:Button = buttons[i][j]
//
//                var width: Int = button.width
//                button.minWidth = width
//                button.maxWidth = width
//
//                var height: Int = button.height
//                button.minHeight = height
//                button.maxHeight = height
//            }
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_search)
//    return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }

//    Insert code to display and handle Menu
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.fragment_menu_profile, menu)
//    }
//}