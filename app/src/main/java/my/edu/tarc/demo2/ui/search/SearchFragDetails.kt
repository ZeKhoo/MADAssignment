package my.edu.tarc.demo2.ui.search

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.common.collect.Sets
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.databinding.FragmentNewInventoryBinding
import my.edu.tarc.demo2.databinding.FragmentSearchFragDetailsBinding
import my.edu.tarc.demo2.ui.model.Inventory
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.AbstractList

class SearchFragDetails : Fragment(){

    //View Binding
//    private var _binding: FragmentSearchFragDetailsBinding? = null
//    private val binding get() = _binding!!
//
//    lateinit var editTextSerialNumber: TextView
//    lateinit var editTextPartNo: TextView
//    lateinit var edittextQty: TextView
//    lateinit var editTextRackIn: TextView
//    lateinit var editTextRackOut: TextView
//    lateinit var editTextRackId: TextView
//    lateinit var inventoryList: MutableList<Inventory>
//
//    var databaseReference :  DatabaseReference? = null
//    lateinit var ref: DatabaseReference
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentSearchFragDetailsBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        inventoryList = mutableListOf()
//        ref = FirebaseDatabase.getInstance().getReference("inventory")
//
//        //Gets the data from the passed bundle
//        val bundle = arguments
//        val choice = bundle!!.getString("choice")
//        val item_name = bundle!!.getString("itemName")
//
//
//        //Sets the derived data (type String) in the TextView
////        if (message != null) {
////            binding.textView2.text = message
////        }
//        if (choice != null) {
//            if (item_name != null) {
//                readData(choice, item_name)
//            }
//        }
//        return root
//    }
//
//    private fun readData(choice: String, item_no: String) {
//
//        val database: DatabaseReference
//        database = Firebase.database.reference
//
//        val dbase = Firebase.database
//        val myRef = dbase.getReference("inventory")
//
////        dataSnapshot.child("Serial Number").getValue().toString()
//
//        val reference = FirebaseDatabase.getInstance().getReference("inventory")
//        // Read from the database
//        reference.child(item_no).get().addOnCompleteListener(){
//            fun onComplete(task: Task<DataSnapshot>){
//                if (task.isSuccessful){
//                    val dataSnapShot: DataSnapshot = task.getResult()
//                    binding.textView9.setText(dataSnapShot.child("Serial Number").getValue().toString())
//                    binding.textView10.setText(dataSnapShot.child("Part Number").getValue().toString())
//                    binding.textView11.setText(dataSnapShot.child("Quantity").getValue().toString())
//                    binding.textView12.setText(dataSnapShot.child("Rack in date").getValue().toString())
//                    binding.textView13.setText(dataSnapShot.child("Rack Out Date").getValue().toString())
//                    binding.textView13.setText(dataSnapShot.child("Serial Number").getValue().toString())
//                }
//            }
//        }
//
//
////        reference.get().addOnCompleteListener(OnCompleteListener<DataSnapshot> {
////            fun onComple(task: Task<DataSnapshot>){
////                if(task.isSuccessful){
////                    if (task.getResult().exists()){
////                        Toast.makeText(context, "Read Successful", Toast.LENGTH_SHORT).show()
////                        val dataSnapshot = task.getResult()
////
////                        val serial_no = dataSnapshot.child("Serial Number").getValue().toString()
////                        //                            val part_no = binding.textView10
////                        //                            val qty = binding.textView11
////                        //                            val date_rackin = binding.textView12
////                        //                            val date_rackout = binding.textView13
////                        //                            val rackId = binding.textView14
////                        binding.textView9.setText(serial_no)
////
////
////                    }
////                    else{
////                        Toast.makeText(context, "Part Number doesn't exist", Toast.LENGTH_SHORT).show()
////                    }
////                }
////                else{
////                    Toast.makeText(context, "Failed to read", Toast.LENGTH_SHORT).show()
////                }
////
////            }
////        })
//
//
//
////        if (choice == "Serial Number"){
////
////
////        }
//
//        val textViewSerialNumber = binding.textView9
//        val textViewPartNo = binding.textView10
//        val textViewQty = binding.textView11
//        val textViewRackIn = binding.textView12
//        val textViewRackOut = binding.textView13
//        val textViewRackId = binding.textView14
//
//        ref.addValueEventListener(object: ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if (snapshot!!.exists()){
//                    inventoryList.clear()
//                    for (i in snapshot.children){
//                        val value = i.getValue(Inventory::class.java)
//                        inventoryList.add(value!!)
//                    }
//
//
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Log.w("Failed to read value.", error.toException())
//            }
//
//        })
//
//
//
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}