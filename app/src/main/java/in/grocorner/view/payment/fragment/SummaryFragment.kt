package `in`.grocorner.view.payment.fragment

import `in`.grocorner.R
import `in`.grocorner.view.payment.adapter.SummaryAdapter
import `in`.grocorner.model.network.pojo.SummaryModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_summary.*

class SummaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        next_button.setOnClickListener {
            val action =
                SummaryFragmentDirections.actionSummaryFragmentToOrderConfirmationFragment()
            findNavController().navigate(action)
        }

        val summaryItemList = mutableListOf<SummaryModel>()
        repeat(6) {
            summaryItemList.add(
                SummaryModel("")
            )
        }
        context?.let {
            val summaryAdapter = SummaryAdapter(it, summaryItemList)
            rv_summary_items.adapter = summaryAdapter
            rv_summary_items.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}