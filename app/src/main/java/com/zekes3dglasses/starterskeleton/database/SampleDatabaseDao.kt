package com.zekes3dglasses.starterskeleton.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Defines methods for using the SampleEntry class with Room.
 */
@Dao
interface SampleDatabaseDao {
    @Insert
    fun insert(entity: SampleEntry)

    /**
     * When updating a row with a value already set in a column,
     * replaces the old value with the new one.
     *
     * @param entity new value to write
     */
    @Update
    fun update(entity: SampleEntry)

    /**
     * Selects and returns the row that matches the supplied start time, which is our key.
     *
     * @param key startTimeMilli to match
     */
    @Query("SELECT * from a_database_table WHERE primaryKey = :key")
    fun get(key: Long): SampleEntry?

    /**
     * Deletes all values from the table.
     *
     * This does not delete the table, only its contents.
     */
    @Query("DELETE FROM a_database_table")
    fun clear()

    /**
     * Selects and returns all rows in the table,
     *
     * sorted by start time in descending order.
     */
    @Query("SELECT * FROM a_database_table ORDER BY primaryKey DESC")
    fun getAllEntries(): LiveData<List<SampleEntry>>

    /**
     * Selects and returns the latest night.
     */
    @Query("SELECT * FROM a_database_table ORDER BY primaryKey DESC LIMIT 1")
    fun getLatestEntry(): SampleEntry?
}