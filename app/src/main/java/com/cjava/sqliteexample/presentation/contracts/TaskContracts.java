package com.cjava.sqliteexample.presentation.contracts;

import com.cjava.sqliteexample.core.BasePresenter;
import com.cjava.sqliteexample.core.BaseView;
import com.cjava.sqliteexample.data.TaskEntity;

import java.util.ArrayList;

/**
 * Created by mobile7 on 18/12/2016.
 */

public interface TaskContracts {

    //Aqui definimos los metodos que tendra el fragment
    interface View extends BaseView<Presenter> {

        void showTask(ArrayList<TaskEntity> taskEntities);

        void addTaskSuccess();

        void addTaskFailed();

        void addTaskFromDialog(TaskEntity taskEntity);

    }

    //Aqui defines los metodos que tendra el presenter
    interface Presenter extends BasePresenter {

        void addTask(TaskEntity taskEntity);

        void loadTask();
    }
}
