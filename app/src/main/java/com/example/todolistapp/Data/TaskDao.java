package com.example.todolistapp.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todolistapp.Model.Task;

import java.util.List;

@Dao
public interface TaskDao {
   @Insert
    void insertTask(Task task);
   @Query("DELETE FROM task_table")
    void deleteAll();
   @Query("SELECT * FROM task_table")
   LiveData<List<Task>> getTasks();
   @Query("SELECT * FROM task_table WHERE task_id ==:id")
   LiveData<Task> get(long id);
   @Update
    void update(Task task);
   @Delete
    void delete(Task task);
}
