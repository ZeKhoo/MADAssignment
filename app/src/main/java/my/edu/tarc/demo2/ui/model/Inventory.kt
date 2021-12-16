package my.edu.tarc.demo2.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "inventory")
data class Inventory(
    @PrimaryKey val part_no: String,
    val serial_number: String,
    val qty: Int,
    val date_rackin: String,
    val date_rackout: String,
    val rack_id: Int
    ){

    constructor():this("", "", 0, "", "", 0)

    override fun toString(): String {
        return super.toString()
    }
}
