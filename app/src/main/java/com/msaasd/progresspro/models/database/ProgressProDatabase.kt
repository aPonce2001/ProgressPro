package com.msaasd.progresspro.models.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.msaasd.progresspro.models.converters.LocalDateConverter
import com.msaasd.progresspro.models.converters.LocalDateTimeConverter
import com.msaasd.progresspro.models.converters.LocalTimeConverter
import com.msaasd.progresspro.models.converters.TaskStateConverter
import com.msaasd.progresspro.models.daos.BadgeDao
import com.msaasd.progresspro.models.daos.SubtaskDao
import com.msaasd.progresspro.models.daos.TaskDao
import com.msaasd.progresspro.models.daos.UserBadgeCrossRefDao
import com.msaasd.progresspro.models.daos.UserDao
import com.msaasd.progresspro.models.entities.Badge
import com.msaasd.progresspro.models.entities.Subtask
import com.msaasd.progresspro.models.entities.Task
import com.msaasd.progresspro.models.entities.User
import com.msaasd.progresspro.models.entities.relations.UserBadgeCrossRef

@Database(
    version = 1,
    entities = [
        Badge::class,
        Subtask::class,
        Task::class,
        User::class
    ]
)
@TypeConverters(
    LocalDateConverter::class,
    LocalDateTimeConverter::class,
    LocalTimeConverter::class,
    TaskStateConverter::class,
    UserBadgeCrossRef::class
)
abstract class ProgressProDatabase: RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: ProgressProDatabase? = null

        fun getDatabase(context: android.content.Context): ProgressProDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ProgressProDatabase::class.java,
                    "progresspro_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

    abstract fun badgeDao(): BadgeDao

    abstract fun userDao(): UserDao

    abstract fun taskDao(): TaskDao

    abstract fun subtaskDao(): SubtaskDao

    abstract fun userBadgeCrossRefDao(): UserBadgeCrossRefDao
}