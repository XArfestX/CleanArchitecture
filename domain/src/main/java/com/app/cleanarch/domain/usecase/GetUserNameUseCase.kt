package com.app.cleanarch.domain.usecase

import com.app.cleanarch.domain.models.UserName
import com.app.cleanarch.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {


    fun execute(): UserName {
        return userRepository.getName()
    }

}