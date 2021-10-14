package com.udev.exampleapp.injection.data.source.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.udev.exampleapp.injection.data.source.local.model.MovieDB

@Dao
interface MovieDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: MovieDB)

    @Update
    suspend fun update(movie: MovieDB)

    @Query("SELECT * from movies")
    fun getAllMovies(): LiveData<List<MovieDB>>

}