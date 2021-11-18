package com.example.todolistapp.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.todolistapp.Model.Task;
import com.example.todolistapp.util.TaskRoomDatabase;

import java.util.List;

public class DoisterRepository {
    private final TaskDao taskDao;
    private final LiveData<List<Task>> allTasks;

    public DoisterRepository(Application application) {
        TaskRoomDatabase database = TaskRoomDatabase.getDatabase(application);
        this.taskDao = database.taskDao();
        this.allTasks = taskDao.getTasks();
    }
    public LiveData<List<Task>> getAllTasks(){
        return allTasks;
    }
    public void insert(Task task){
        TaskRoomDatabase.databaseWriteExecutor.execute(()->taskDao.insertTask(task));
    }
    public LiveData<Task> get(long id){return taskDao.get(id);}
    public void update(Task task){
        TaskRoomDatabase.databaseWriteExecutor.execute(()->taskDao.update(task));
    }
    public void delete(Task task){
        TaskRoomDatabase.databaseWriteExecutor.execute(()->taskDao.delete(task));
    }
}
