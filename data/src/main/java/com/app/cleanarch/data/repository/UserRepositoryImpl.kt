package com.app.cleanarch.data.repository

import com.app.cleanarch.data.storage.models.User
import com.app.cleanarch.data.storage.UserStorage
import com.app.cleanarch.domain.models.SaveUserNameParam
import com.app.cleanarch.domain.models.UserName
import com.app.cleanarch.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()

        return mapToDomain(user = user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User{
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

}