package my.edu.tarc.demo2.ui.displayInventory

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.databinding.FragmentNewInventoryBinding
import my.edu.tarc.demo2.databinding.FragmentSearchFragDetailsBinding
import my.edu.tarc.demo2.ui.model.Inventory
import org.w3c.dom.Text

class DetailDisplay(val mCtx: Context, val layoutResId: Int, val inventoryList: List<Inventory>):ArrayAdapter<Inventory>(mCtx, layoutResId, inventoryList){

    private var _binding: FragmentSearchFragDetailsBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val textViewSerialNumber = view.findViewById<TextView>(R.id.textView9)
        val textViewPartNo = view.findViewById<TextView>(R.id.textView10)
        val textViewQty = view.findViewById<TextView>(R.id.textView11)
        val textViewRackIn = view.findViewById<TextView>(R.id.textView12)
        val textViewRackOut = view.findViewById<TextView>(R.id.textView13)
        val textViewRackId = view.findViewById<TextView>(R.id.textView14)

        val serial_number = inventoryList[position]
        val part_no = inventoryList[position+1]
        val qty = inventoryList[position+2]
        val rack_in = inventoryList[position+3]
        val rack_out = inventoryList[position+4]
        val rackId = inventoryList[position+5]

//        textViewSerialNumber.text = inventory.serial_number
//        textViewPartNo.text = Inventory.part_no
//        textViewQty.text = Inventory.qty
//        textViewRackIn.text = Inventory.rack_in
//        textViewRackOut.text = Inventory.rack_out
//        textViewRackId.text = Inventory.rackId

        return view;
    }


}