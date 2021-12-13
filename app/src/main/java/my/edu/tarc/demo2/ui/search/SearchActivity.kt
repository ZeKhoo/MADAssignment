package my.edu.tarc.demo2.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import my.edu.tarc.demo2.MainActivity
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.databinding.ActivityMainBinding
import my.edu.tarc.demo2.databinding.ActivitySearchBinding
//import my.edu.tarc.demo2.ui.search.SearchActivity.Companion.NUM_ROWS

class SearchActivity : AppCompatActivity(){

//    private var buttons =  arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())
    private var buttons = arrayOf<Array<Button>>()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySearchBinding
    private lateinit var Mainbinding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        binding = ActivitySearchBinding.inflate(layoutInflater)
//        binding = ActivitySearchBinding.inflate(inflater, container, false)
        setContentView(binding.root)
//
//        setSupportActionBar(binding.app_bar_search)
//
//        //Link to navigation
//        drawerLayout = binding.drawerLayout
//        val navView: NavigationView = binding.navView
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

        var fManager = supportFragmentManager
//
        var tx = fManager.beginTransaction()
        tx.add(R.id.frag, SearchFragTransaction())
        tx.addToBackStack(null)
        tx.commit()

        binding.buttonTransaction.setOnClickListener{
            var tx = fManager.beginTransaction()
            tx.replace(R.id.frag, SearchFragDetails())
            tx.addToBackStack(null)
            tx.commit()
        }

        binding.buttonDetails.setOnClickListener {
            var tx = fManager.beginTransaction()
            tx.replace(R.id.frag, SearchFragDetails())
            tx.addToBackStack(null)
            tx.commit()
        }

//        //Toggle Bar Animation
//        val toggle = ActionBarDrawerToggle(this, drawerLayout, binding.appBarSearch.toolbar,
//            R.string.navigation_drawer_open, R.string.nav_drawer_close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
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
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_search)
    return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    //TODO: Insert code to display and handle Menu
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.fragment_menu_profile, menu)
//    }
//}