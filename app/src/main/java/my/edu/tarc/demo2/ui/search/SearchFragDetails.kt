package my.edu.tarc.demo2.ui.search

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.common.collect.Sets
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.databinding.FragmentNewInventoryBinding
import my.edu.tarc.demo2.databinding.FragmentSearchFragDetailsBinding
import java.text.SimpleDateFormat
import java.util.*

class SearchFragDetails : Fragment(){

    //View Binding
    private var _binding: FragmentSearchFragDetailsBinding? = null
    private val binding get() = _binding!!

    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchFragDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //Gets the data from the passed bundle
        val bundle = arguments
        val choice = bundle!!.getString("choice")
        val item_name = bundle!!.getString("item_name")

        //Sets the derived data (type String) in the TextView
//        if (message != null) {
//            binding.textView2.text = message
//        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}