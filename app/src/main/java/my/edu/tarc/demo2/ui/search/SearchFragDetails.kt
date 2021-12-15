package my.edu.tarc.demo2.ui.search

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import my.edu.tarc.demo2.MainActivity
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.databinding.FragmentSearchFragDetailsBinding

class SearchFragDetails : Fragment(), SearchActivity.MyInterface{

    //View Binding
    private var _binding: FragmentSearchFragDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: SearchActivity.MyInterface

    private var buttons = arrayOf<Array<Button>>()

    companion object {
        var CHOICE = ""
        var ITEM_NAME = ""
        const val NUM_ROWS: Int = 5
        const val NUM_COLUMNS: Int = 5

        fun newInstance(chocie: String?, item_name:String?): SearchFragDetails {
            val fragment = SearchFragDetails()

            val bundle = Bundle().apply {
                putString(CHOICE, chocie)
                putString(ITEM_NAME, item_name)
            }

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//
        Log.d("Search Activity", "Oncreate")
//
//        //Enable menu in this fragment
        setHasOptionsMenu(true)
//
////        populateButton()
    }
//
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchFragDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d("Search Details Fragment", "OnCreateView")
        val profilePreferences: SharedPreferences = activity?.getPreferences(Context.MODE_PRIVATE)!!

        val textView = binding.textView2
        // Gets the data from the passed bundle
        val bundle = arguments
        var message = bundle!!.getString("pass")

        // Sets the derived data (type String) in the TextView
        textView.text = String.format("%s", message)

//        val choice = arguments?.getString(CHOICE)
//        val item_name = arguments?.getString(ITEM_NAME)
//
//        binding.textView2.text = String.format("%s", item_name)
//        assignData(choice, item_name)
        return view
    }

    //Insert code to display and handle Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_menu_profile, menu)
    }

    override fun myAction() {
        fun setListener(listener: SearchActivity.MyInterface){
            this.listener = listener
        }
    }

//    fun assignData(chocie: String?, item_name: String?){
//        binding.textView2.text = String.format("%s", chocie)
//
//    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Profile Fragment", "OnDestroy")
        _binding = null

    }



//    fun setListener(listener: MyInterface){
//        this@SearchFragDetails.listener = this.listener
//    }
//
//    private fun populateButton() {
//        val table = binding.mapLayout
////        var param: TableLayout.LayoutParams
////
//        for (row in 1..SearchFragDetails.NUM_ROWS) {
//            val tableRow: TableRow = TableRow(context)
//            tableRow.setLayoutParams(
//                TableLayout.LayoutParams(
//                    TableLayout.LayoutParams.MATCH_PARENT,
//                    TableLayout.LayoutParams.MATCH_PARENT,
//                    1.0f
//                )
//            )
////            table.addView(tableRow)
//            binding.mapLayout.addView(tableRow)
////
//            for (col in 1..SearchFragDetails.NUM_COLUMNS) {
//                val FINAL_COL = col
//                val FINAL_ROW = row
//
//
//                val button: Button = Button(context)
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
//                    gridButtonCLicked(FINAL_COL, FINAL_ROW)
//                }
//
//                tableRow.addView(button)
//                buttons[row][col] = button
//            }
//        }
//    }
//
//    fun gridButtonCLicked(col: Int, row: Int){
//        Toast.makeText(context, "Button cliecked: "+row+","+col, Toast.LENGTH_SHORT).show()
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
//        for (i in 0..SearchActivity.NUM_ROWS){
//            for (j in 0..SearchActivity.NUM_COLUMNS){
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


//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}