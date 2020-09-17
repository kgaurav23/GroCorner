package `in`.grocorner.ui.database

import `in`.grocorner.ui.cart.model.Cart
import `in`.grocorner.ui.login.model.User
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class, Cart::class], version = 1)
abstract class GroCornerDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun cartDao(): CartDao

    companion object {
        @Volatile
        private var instance: GroCornerDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            GroCornerDatabase::class.java,
            "groCornerDatabase"
        ).build()
    }
}