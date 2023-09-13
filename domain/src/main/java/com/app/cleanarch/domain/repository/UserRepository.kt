package com.app.cleanarch.domain.repository

import com.app.cleanarch.domain.models.SaveUserNameParam
import com.app.cleanarch.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}