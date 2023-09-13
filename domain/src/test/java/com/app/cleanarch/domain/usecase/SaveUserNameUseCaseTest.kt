package com.app.cleanarch.domain.usecase

import com.app.cleanarch.domain.models.SaveUserNameParam
import com.app.cleanarch.domain.models.UserName
import com.app.cleanarch.domain.repository.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SaveUserNameUseCaseTest {

    val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown() {
        Mockito.reset(userRepository)
    }

    @Test
    fun `should not save data if name was already saved`() {

        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val testParams = SaveUserNameParam(name = "test first name")
        val actual = useCase.execute(testParams)
        val expected = true

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.never()).saveName(saveParam = any())
    }

    @Test
    fun `should never use method`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val testParams = SaveUserNameParam(name = "test first name")
        useCase.execute(testParams)
        val actual = Mockito.verify(userRepository, Mockito.never()).saveName(saveParam = any())
        val expected = false
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should return true is save was successful`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val expected = true
        val testParams = SaveUserNameParam(name = "new first name")
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute(testParams)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }

    @Test
    fun `should using method 1 time`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val expected = false
        val testParams = SaveUserNameParam(name = "new first name")
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(true)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        useCase.execute(testParams)

        val actual = Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should return false is save was successful`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val expected = false
        val testParams = SaveUserNameParam(name = "new first name")
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute(testParams)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }


}
