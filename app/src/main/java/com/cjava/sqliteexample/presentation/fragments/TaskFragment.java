package com.cjava.sqliteexample.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.cjava.sqliteexample.R;
import com.cjava.sqliteexample.data.TaskEntity;
import com.cjava.sqliteexample.presentation.adapters.TaskAdapter;
import com.cjava.sqliteexample.presentation.contracts.TaskContracts;
import com.cjava.sqliteexample.presentation.dialogs.AddTaskDialog;
import com.cjava.sqliteexample.presentation.presenter.TaskPresenter;

import java.util.ArrayList;

/**
 * Created by mobile7 on 18/12/2016.
 */

public class TaskFragment extends Fragment implements TaskContracts.View {


    private TaskContracts.Presenter presenter;


    private TaskAdapter taskAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView listTask;
    private Button button;


     //Constructor es requerido
    public TaskFragment(){

    }

    public static TaskFragment newInstace(){
        return new TaskFragment();
    }


    //Instanciar Objetos, ProgressDialogs, Presenter, Intents
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TaskPresenter(this,getContext());

    }


    //Este método siempre se llama cuando la pantalla se pone en focus, aqui se cargan listas
    @Override
    public void onResume() {
        super.onResume();
        presenter.start();


    }


    //Inflar el layout que le vamos a proporcionar
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task,container,false);

        listTask = (RecyclerView) view.findViewById(R.id.list_task);
        button = (Button) view.findViewById(R.id.btn_add);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        return view;
    }


    private void showDialog(){
        AddTaskDialog addTaskDialog = new AddTaskDialog(getContext(),this);
        addTaskDialog.show();
    }
    //Inicilizar se trabaja casi todas las vistas cargadas
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        taskAdapter = new TaskAdapter(getContext(),new ArrayList<TaskEntity>());
        linearLayoutManager = new LinearLayoutManager(getContext());

        listTask.setAdapter(taskAdapter);
        listTask.setLayoutManager(linearLayoutManager);


    }




    //Opcional
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showTask(ArrayList<TaskEntity> taskEntities) {
        taskAdapter.setItems(taskEntities);
    }

    @Override
    public void addTaskSuccess() {
        presenter.loadTask();
    }

    @Override
    public void addTaskFailed() {

    }

    @Override
    public void addTaskFromDialog(TaskEntity taskEntity) {
            presenter.addTask(taskEntity);
        //941 720 994 - juniorquegu@gmail.com
      //  Toast.makeText(getContext(),taskEntity.getmTaskDetail(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(TaskContracts.Presenter presenter) {

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageError(String msg) {

    }
}
