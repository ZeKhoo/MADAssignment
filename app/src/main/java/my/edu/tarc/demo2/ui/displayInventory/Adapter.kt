package my.edu.tarc.demo2.ui.displayInventory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import my.edu.tarc.demo2.R
import my.edu.tarc.demo2.ui.model.Inventory

class Adapter(private val userList: ArrayList<Inventory>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.inventory_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.serial_no.text = currentItem.serial_number
        holder.part_no.text = currentItem.part_no
        holder.qty.text = currentItem.qty.toString()
        holder.date_rackIn.text = currentItem.date_rackin
        holder.date_rackOut.text = currentItem.date_rackout
        holder.rackId.text= currentItem.rack_id.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val serial_no: TextView = itemView.findViewById(R.id.displaySerialNo)
        val part_no: TextView = itemView.findViewById(R.id.displayPartNo)
        val qty: TextView = itemView.findViewById(R.id.displayQuantity)
        val date_rackIn: TextView = itemView.findViewById(R.id.displayRackIn)
        val date_rackOut: TextView = itemView.findViewById(R.id.displayRackOut)
        val rackId: TextView = itemView.findViewById(R.id.displayRackId)

    }
}