package com.example.devfinalevaluation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.devfinalevaluation.model.Photos
import com.example.devfinalevaluation.repository.HomeActivityRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    lateinit var model: HomeViewModel

    @MockK
    lateinit var homeActivityRepository: HomeActivityRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()


    @Before
    fun setUp() {

        MockKAnnotations.init(this, relaxUnitFun = true)
        model = HomeViewModel()
        model.setHomeRepository(homeActivityRepository)
    }

    @Test
    fun `test API call`() {
        every { homeActivityRepository.getServicesAPICall() } returns MutableLiveData<List<Photos>>().apply {
            postValue(
                listOf(
                    Photos(
                        "76", "vbvhnfdsgf", "fnsjfsbn.com", "hbffhdbfsh.com"
                    )
                )
            )
        }
        model.getServicesAPICall()
        Assert.assertEquals(
            model.photoLiveData?.value, listOf(
                Photos(
                    "76", "vbvhnfdsgf", "fnsjfsbn.com", "hbffhdbfsh.com"
                )
            )
        )
    }
}