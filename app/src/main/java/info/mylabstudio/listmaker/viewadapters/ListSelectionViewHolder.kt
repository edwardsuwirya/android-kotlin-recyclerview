package info.mylabstudio.listmaker.viewadapters

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import info.mylabstudio.listmaker.R

class ListSelectionViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val listPosition = v.findViewById(R.id.itemNumber) as TextView
    val listTitle = v.findViewById(R.id.itemString) as TextView
    val buttonDelete = v.findViewById(R.id.delete_button) as ImageButton
}
