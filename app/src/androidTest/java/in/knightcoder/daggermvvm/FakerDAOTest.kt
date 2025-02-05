package com.knightcoder.daggermvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import `in`.knightcoder.daggermvvm.db.FakerDAO
import `in`.knightcoder.daggermvvm.db.FakerDB
import `in`.knightcoder.daggermvvm.models.Product
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.*
import javax.inject.Inject

@HiltAndroidTest
class FakerDAOTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Inject
    lateinit var fakerDatabase: FakerDB
    private lateinit var fakerDAO: FakerDAO

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
        fakerDAO = fakerDatabase.getFakerDAO()
    }

    @Test
    fun insertProduct_returnsSingleProduct() = runTest {
        val product = Product("", "",1, "", 12.33, "Test Product")
        fakerDAO.addProducts(listOf(product))
        val result = fakerDAO.getProducts()
        Assert.assertEquals(1, result.size)
    }


    @After
    fun closeDatabase() {
        fakerDatabase.close()
    }
}