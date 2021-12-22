package com.example.quotewars.model

import androidx.databinding.adapters.Converters
import androidx.room.*
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

class Converters {
    @TypeConverter
    fun fromLong(value: Long?): BigDecimal? {
        return if (value == null) null else BigDecimal(value).divide(BigDecimal(100))
    }

    @TypeConverter
    fun toLong(bigDecimal: BigDecimal?): Long? {
        return bigDecimal?.multiply(BigDecimal(100))?.toLong()
    }
}

@Entity(tableName = "favorite_activity_table")
data class ActivityModel (
    @ColumnInfo(name = "activity")
    @Json(name = "boredActivity")val activity: String,
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


