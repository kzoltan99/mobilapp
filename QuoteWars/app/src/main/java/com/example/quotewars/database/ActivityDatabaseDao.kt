package com.example.quotewars.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.quotewars.model.ActivityModel

@Dao
interface ActivityDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(activity: ActivityModel)
    @Query("SELECT * from favorite_activity_table WHERE `key` = :key")
    suspend fun get(key: Int): ActivityModel
    @Query("DELETE FROM favorite_activity_table")
    suspend fun clear()
    @Query("SELECT * FROM favorite_activity_table")
    fun getAllQuotes(): LiveData<List<ActivityModel>>
    @Delete
    suspend fun delete(quote: ActivityModel)
}