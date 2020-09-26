package `in`.grocorner.view.launch.fragment

import `in`.grocorner.R
import `in`.grocorner.model.network.pojo.OnBoardingData
import `in`.grocorner.view.navigator.AppNavigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_onboarding.*

private const val POSITION = "position"
private const val LOGO_RESOURCE_ID = "logoResourceId"
private const val HEADER_TEXT = "headerText"
private const val SUB_HEADER_TEXT = "subHeaderText"

class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments.let {
            onBoardingLogo.setImageResource(it!!.getInt(LOGO_RESOURCE_ID))
            onBoardingHeader.text = it.getString(HEADER_TEXT)
            onBoardingSubHeader.text = it.getString(SUB_HEADER_TEXT)
        }

        get_started_layout.setOnClickListener {
            AppNavigator.navigateToHomeActivity(requireContext())
        }
    }

    companion object {
        fun newInstance(position: Int, onBoardingData: OnBoardingData) =
            OnBoardingFragment().apply {
                arguments = Bundle().apply {
                    putInt(POSITION, position)
                    putInt(LOGO_RESOURCE_ID, onBoardingData.logoResource)
                    putString(HEADER_TEXT, onBoardingData.headerText)
                    putString(SUB_HEADER_TEXT, onBoardingData.subHeaderText)
                }
            }
    }

}