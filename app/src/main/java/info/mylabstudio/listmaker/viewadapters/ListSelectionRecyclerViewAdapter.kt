package info.mylabstudio.listmaker.viewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.mylabstudio.listmaker.R
import info.mylabstudio.listmaker.models.Language

class ListSelectionRecyclerViewAdapter(private val lists: ArrayList<Language>) :
    RecyclerView.Adapter<ListSelectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_selection_view_holder, parent, false)
        return ListSelectionViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        holder.listPosition.text = (position + 1).toString()
        holder.listTitle.text = lists.get(position).name
        holder.buttonDelete.setOnClickListener {
            lists.removeAt(position)
            notifyDataSetChanged()
        }
    }

}
