package `in`.knightcoder.daggermvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import `in`.knightcoder.daggermvvm.models.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase() {

    abstract fun getFakerDAO() : FakerDAO

}