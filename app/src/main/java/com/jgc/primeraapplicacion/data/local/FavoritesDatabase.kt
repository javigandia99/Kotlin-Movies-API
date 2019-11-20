package com.jgc.primeraapplicacion.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoritesEntity::class], version = 2, exportSchema = false)
abstract class FavoritesDatabase: RoomDatabase() {
    abstract fun favoritesDao(): FavoritesDao
}

object DatabaseFactory {
    fun getDatabase(context: Context): FavoritesDatabase {
        return Room.databaseBuilder(context, FavoritesDatabase::class.java, "favoritesDatabases")
            .build()
    }

}