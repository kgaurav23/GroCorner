package `in`.grocorner.ui.database.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name = "user_name")
    val userName: String,
    @ColumnInfo(name = "encrypted_token")
    val encryptedToken: String,
    @ColumnInfo(name = "mobile_number")
    @PrimaryKey
    val mobileNumber: String,
    @ColumnInfo(name = "email_id")
    val emailId: String
) {
    //We can make id also as a primary key like below
    /*@PrimaryKey(autoGenerate = true)
    var id: Long = 0*/
}