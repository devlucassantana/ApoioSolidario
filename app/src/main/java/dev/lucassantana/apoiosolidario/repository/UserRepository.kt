package dev.lucassantana.apoiosolidario.repository

import dev.lucassantana.apoiosolidario.model.User

interface UserRepository {

    fun saveUser(user: User)
    fun getUser(): User
    fun getUser(id: Int): User

    fun getUserByEmail(email: String): User?
    fun login(email: String, password: String): Boolean


}

