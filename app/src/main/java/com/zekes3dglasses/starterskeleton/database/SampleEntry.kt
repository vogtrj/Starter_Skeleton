package com.zekes3dglasses.starterskeleton.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "a_database_table")
data class SampleEntry(
    @PrimaryKey(autoGenerate = true)
    var primaryKey: Long = 0L,

    @ColumnInfo(name = "first_column")
    val firstColumn: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "more_data")
    var moreData: String = "There's a snake in my boot.",

    @ColumnInfo(name = "YAC")
    // Set an initialized column to -1 to hint that actual data hasn't been entered here.
    var yetAnotherColumn: Int = -1
)