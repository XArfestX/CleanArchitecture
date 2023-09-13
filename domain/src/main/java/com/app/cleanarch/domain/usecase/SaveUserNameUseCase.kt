package com.app.cleanarch.domain.usecase

import com.app.cleanarch.domain.models.SaveUserNameParam
import com.app.cleanarch.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {


    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()

         if (oldUserName.firstName == param.name) {
             return true
         }

        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }

}