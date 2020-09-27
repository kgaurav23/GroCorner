package `in`.grocorner.view.home.activity

import `in`.grocorner.R
import `in`.grocorner.view.customviews.ProgressBarDialog
import `in`.grocorner.view.utility.AppUtility
import `in`.grocorner.viewmodel.EditProfileViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {

    private lateinit var editProfileViewModel: EditProfileViewModel
    private lateinit var progressBarDialog: ProgressBarDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        edit_profile_button.isEnabled = false
        progressBarDialog = ProgressBarDialog(this)
        editProfileViewModel = ViewModelProvider(this).get(EditProfileViewModel::class.java)
        observeDataChange()

        editProfileViewModel.saveUserInDBAsync()
        //editProfileViewModel.getUserFromDBAsync()

        edit_profile_button.setOnClickListener {
            val isValid = AppUtility.checkInputFieldForErrors(this)
            if (!isValid) return@setOnClickListener

            editProfileViewModel.updateProfile(
                email = user_email_et.text.toString(),
                name = user_name_et.text.toString()
            )
        }
    }

    private fun observeDataChange() {
        editProfileViewModel.userData.observe(this, Observer {
            edit_profile_button.isEnabled = true
            user_name_et.setText(it.userName)
            user_email_et.setText(it.emailId)
            user_phone_et.setText(it.mobileNumber)
        })
        editProfileViewModel.editProfileComplete.observe(this, Observer {

        })

        editProfileViewModel.userInserted.observe(this, Observer {
            editProfileViewModel.getUserFromDBAsync()
        })

        editProfileViewModel.loaderState.observe(this, Observer {
            if (it.isLoading) {
                progressBarDialog.show()
            } else {
                progressBarDialog.hide()
            }
        })
    }
}