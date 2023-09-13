package com.app.cleanarch.di

import com.app.cleanarch.data.repository.UserRepositoryImpl
import com.app.cleanarch.data.storage.UserStorage
import com.app.cleanarch.data.storage.sharedprefs.SharedPrefUserStorage
import com.app.cleanarch.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}