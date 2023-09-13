package com.app.cleanarch.data.storage

import com.app.cleanarch.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}