package dev.lucassantana.apoiosolidario.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.lucassantana.apoiosolidario.model.User

@Database(entities = [User::class], version = 1)
abstract class NecessitiesDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private lateinit var instance: NecessitiesDatabase

        fun getDatabase(context: Context): NecessitiesDatabase {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    NecessitiesDatabase::class.java,
                    "db_necessities"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}