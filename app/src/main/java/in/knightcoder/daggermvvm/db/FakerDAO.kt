package `in`.knightcoder.daggermvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import `in`.knightcoder.daggermvvm.models.Product

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products : List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>

}