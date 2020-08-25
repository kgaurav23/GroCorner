package `in`.grocorner.ui.launch.fragment

import `in`.grocorner.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

private const val POSITION = "position"

class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    companion object {
        fun newInstance(position: Int) = OnBoardingFragment().apply {
            arguments = Bundle().apply {
                putInt(POSITION, position)
            }
        }
    }

}