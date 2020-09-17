package `in`.grocorner.ui.database

import `in`.grocorner.ui.login.model.User
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM user")
    suspend fun getUser(): User

    @Query("UPDATE user SET user_name = :userName, email_id = :emailId")
    suspend fun updateUserDetails(userName: String, emailId: String)

    @Query("DELETE FROM user")
    suspend fun deleteUser()

    /*@Query("SELECT encrypted_token FROM user")
    suspend fun getUserEncryptedToken(): User

    @Query("SELECT user_name FROM user WHERE mobile_number = :mobileNumber")
    suspend fun getUserName(mobileNumber: String): User*/
}