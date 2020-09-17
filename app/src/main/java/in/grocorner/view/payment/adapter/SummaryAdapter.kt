package `in`.grocorner.view.payment.adapter

import `in`.grocorner.R
import `in`.grocorner.model.network.pojo.SummaryModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SummaryAdapter(
    val context: Context,
    private val summaryItemsList: List<SummaryModel>
) :
    RecyclerView.Adapter<SummaryItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryItemVH {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_summary, parent, false)
        return SummaryItemVH(view)
    }

    override fun getItemCount() = summaryItemsList.size

    override fun onBindViewHolder(holder: SummaryItemVH, position: Int) {
        val summaryItemHolder = holder as SummaryItemVH
        summaryItemHolder.apply {

        }
    }
}

class SummaryItemVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

}