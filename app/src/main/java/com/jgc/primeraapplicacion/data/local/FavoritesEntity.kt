package com.jgc.primeraapplicacion.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moviesFavorites")
data class FavoritesEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "image") val poster_path: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val release_date: String,
    @ColumnInfo(name = "adult") val adult: Boolean,
    @ColumnInfo(name = "popularity") val popularity: Float,
    @ColumnInfo(name = "average") val vote_average: Float,
    @ColumnInfo(name = "dateadded") val date_added: String
)