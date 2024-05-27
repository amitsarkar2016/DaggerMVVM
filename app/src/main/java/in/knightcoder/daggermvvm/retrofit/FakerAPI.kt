package `in`.knightcoder.daggermvvm.retrofit

import `in`.knightcoder.daggermvvm.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}