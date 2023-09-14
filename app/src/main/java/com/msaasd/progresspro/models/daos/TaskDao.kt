package com.msaasd.progresspro.models.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.msaasd.progresspro.models.entities.Task
import com.msaasd.progresspro.models.entities.TaskState
import com.msaasd.progresspro.models.entities.relations.TaskWithSubtasks

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg tasks: Task)

    @Update
    suspend fun update(vararg tasks: Task)

    @Delete
    suspend fun delete(vararg tasks: Task)

    @Transaction
    @Query("SELECT * FROM tasks WHERE task_id = :taskId")
    suspend fun getTaskById(taskId: Int): Task

    @Transaction
    @Query("SELECT * FROM tasks WHERE user_id = :userId")
    suspend fun getTasksForUser(userId: Int): List<Task>

    @Transaction
    @Query("SELECT * FROM tasks WHERE task_id = :taskId")
    suspend fun getTaskWithSubtasks(taskId: Int): List<TaskWithSubtasks>

    @Transaction
    @Query("SELECT * FROM tasks WHERE user_id = :userId AND state = :createdState")
    fun getCreatedTasks(userId: Int, createdState: TaskState = TaskState.CREATED): List<Task>

    @Transaction
    @Query("SELECT * FROM tasks WHERE user_id = :userId AND state = :doneState")
    fun getDoneTasks(userId: Int, doneState: TaskState = TaskState.DONE): List<Task>
}