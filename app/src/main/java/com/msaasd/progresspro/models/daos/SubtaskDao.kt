package com.msaasd.progresspro.models.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.msaasd.progresspro.models.entities.Subtask

@Dao
interface SubtaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(subtask: Subtask)

    @Update
    suspend fun update(subtask: Subtask)

    @Delete
    suspend fun delete(subtask: Subtask)

    @Query("SELECT * FROM subtasks WHERE subtask_id = :subtaskId")
    suspend fun getSubtaskById(subtaskId: Int): Subtask

    @Query("SELECT * FROM subtasks WHERE task_id = :taskId")
    suspend fun getSubtasksForTask(taskId: Int): List<Subtask>
}