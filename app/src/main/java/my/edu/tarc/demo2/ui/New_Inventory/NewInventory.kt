package my.edu.tarc.demo2.ui.New_Inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.databinding.FragmentNewInventoryBinding
import java.text.SimpleDateFormat
import java.util.*

//import my.edu.tarc.demo2.databinding.FragmentGalleryBinding

class NewInventory : Fragment() {

    lateinit var editTextSerialNumber: EditText
    lateinit var editTextPartNo: EditText
    lateinit var edittextQty: EditText
    lateinit var editTextRackIn: EditText
    lateinit var editTextRackOut: EditText
    lateinit var editTextRackId: EditText
    private var format = SimpleDateFormat("dd MMM yyyy", Locale.US)

    //View Binding
    private var _binding: FragmentNewInventoryBinding? = null
    private val binding get() = _binding!!

    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    //check whether is Integer
    val integerChars = '0'..'9'

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewInventoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Gets the data from the passed bundle
//        val bundle = arguments
//        val choice = bundle!!.getString("choice")
//        val item_name = bundle!!.getString("item_name")

        //Sets the derived data (type String) in the TextView
//        if (message != null) {
//            binding.textView2.text = message
//        }

        storeData()


        return root
    }

    private fun storeData() {
        editTextSerialNumber = binding.editTextSerialNo
        editTextPartNo = binding.editTextPartNo
        edittextQty= binding.editTextQty
        editTextRackIn = binding.editTextRackIn
        editTextRackOut = binding.editTextRackOut
        editTextRackId = binding.editTextRackOut
        binding.button.setOnClickListener{
            saveInventory()

        }

    }

    private fun saveInventory() {


        if(editTextSerialNumber.text.toString().isEmpty()){
            editTextSerialNumber.error = getString(R.string.error)
            return
        }
        else if (editTextPartNo.text.toString().isEmpty()){
            editTextPartNo.error = getString(R.string.error)
            return
        }
        else if (edittextQty.text.toString().isEmpty()){
            edittextQty.error = getString(R.string.error)
            return
        }
        else if (!isNumber(edittextQty.text.toString()) || !isInteger(edittextQty.text.toString())){
            edittextQty.error = "Wrong type of values"
            return
        }
        else if (editTextRackIn.text.toString().isEmpty()){
            editTextRackIn.error = getString(R.string.error)
            return
        }
        else if (editTextRackOut.text.toString().isEmpty()){
            editTextRackOut.error = getString(R.string.error)
            return
        }
        else if (editTextRackId.text.toString().isEmpty()){
            editTextRackId.error = getString(R.string.error)
            return
        }
        else if (!isNumber(editTextRackId.text.toString()) || !isInteger(editTextRackId.text.toString())){
            editTextRackId.error = "Wrong type of values"
            return
        }
        else{

            val serial_number = editTextSerialNumber.text.toString()
            val part_no = editTextPartNo.text.toString()
            val qty = Integer.parseInt(edittextQty.text.toString())
            val rack_in = editTextRackIn.text.toString()
            val rack_out = editTextRackOut.text.toString()
            val rackId = Integer.parseInt(editTextRackId.text.toString())

            val database: DatabaseReference
            database = Firebase.database.reference

            database.child("inventory").child(serial_number).child("Serial Number").setValue(serial_number)
            database.child("inventory").child(serial_number).child("Part Number").setValue(part_no)
            database.child("inventory").child(serial_number).child("Quantity").setValue(qty)
            database.child("inventory").child(serial_number).child("Rack In date").setValue(rack_in)
            database.child("inventory").child(serial_number).child("Rack Out Date").setValue(rack_out)
            database.child("inventory").child(serial_number).child("Rack Id").setValue(rackId)
            Toast.makeText(context, R.string.add_success, Toast.LENGTH_SHORT).show()
        }
        return
    }

    fun isNumber(input: String): Boolean {
        var dotOccurred = 0
        return input.all { it in integerChars || it == '.' && dotOccurred++ < 1 }
    }

    fun isInteger(input: String) = input.all { it in integerChars }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
