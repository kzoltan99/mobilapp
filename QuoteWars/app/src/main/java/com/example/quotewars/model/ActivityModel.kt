package com.example.quotewars.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quotewars.MainActivity
import com.squareup.moshi.Json
import java.math.BigDecimal

/*@Entity(tableName = "favorite_quote_table")
data class ActivityModel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "quote")
    @Json(name = "starWarsQuote")val quote: String,
    @ColumnInfo(name = "faction")
    val faction: Int

)*/

@Entity(tableName = "favorite_activity_table")
data class ActivityModel (
    @ColumnInfo(name = "activity")
    val activity: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "participants")
    val participants: Int,
    @ColumnInfo(name = "price")
    val price: BigDecimal,
    @ColumnInfo(name = "link")
    val link : String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "key")
    val key: Int,
    @ColumnInfo(name = "accessibility")
    val accessibility: BigDecimal,
    @ColumnInfo(name = "faction")
    val faction: Int

)
