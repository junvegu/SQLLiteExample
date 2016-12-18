package com.cjava.sqliteexample.presentation.presenter;

import android.content.Context;
import android.database.Cursor;

import com.cjava.sqliteexample.data.TaskEntity;
import com.cjava.sqliteexample.data.remote.TaskDB;
import com.cjava.sqliteexample.presentation.contracts.TaskContracts;

import java.util.ArrayList;

/**
 * Created by mobile7 on 18/12/2016.
 */

public class TaskPresenter implements TaskContracts.Presenter {


    private TaskContracts.View view;
    private Context context;
    private TaskDB taskDB;

    public TaskPresenter(TaskContracts.View view, Context context) {
        this.view = view;
        this.context = context;
        taskDB = new TaskDB(context);
        view.setPresenter(this);
    }

    @Override
    public void addTask(TaskEntity taskEntity) {

        taskDB.inserTask(taskEntity.getmTaskDetail(),"0");
        view.addTaskSuccess();
        view.showMessage("Tarea Agregada");
    }

    @Override
    public void loadTask() {
        Cursor cursor = taskDB.getTask();

        if(cursor!= null && cursor.getCount()>0){
            ArrayList<TaskEntity> taskEntities = new ArrayList<>();
            while(cursor.moveToNext()){
                TaskEntity taskEntity= new TaskEntity(Integer.valueOf(cursor.getString(2)),cursor.getString(1));
                taskEntities.add(taskEntity);
            }
            if(taskEntities.size()>0){
                view.showTask(taskEntities);
                view.showMessage("Carga Exitosa");
            }else{
                view.showMessage("Carga Fallida");
            }
        }


    }

    @Override
    public void start() {
        loadTask();
    }
}
