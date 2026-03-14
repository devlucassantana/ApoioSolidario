package dev.lucassantana.apoiosolidario.repository

import android.content.Context
import dev.lucassantana.apoiosolidario.dao.NecessitiesDatabase
import dev.lucassantana.apoiosolidario.model.User

class RoomUserRepository(context: Context) : UserRepository {

    private val necessityDatabase = NecessitiesDatabase.getDatabase(context).userDao()
    override fun saveUser(user: User) {
        necessityDatabase.save(user)
    }

    override fun getUser(): User {
        TODO("not yet implemented")
    }

    override fun getUser(id: Int): User {
        return necessityDatabase.getUserById(id=1)?: User()
    }

    override fun getUserByEmail(email: String?): User? {
        return necessityDatabase.getUserByEmail(email)
    }

    override fun login(email: String, password: String): Boolean {
        val user = necessityDatabase.login(email, password)
        return user != null

    }
}