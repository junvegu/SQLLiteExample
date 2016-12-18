package com.cjava.sqliteexample.presentation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.cjava.sqliteexample.R;
import com.cjava.sqliteexample.presentation.fragments.TaskFragment;
import com.cjava.sqliteexample.utils.ActivityUtils;

public class TaskActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaskFragment  taskFragment =
                (TaskFragment) getSupportFragmentManager().findFragmentById(R.id.body);

        if(taskFragment==null){

            taskFragment= TaskFragment.newInstace();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    taskFragment,R.id.body);
        }
    }

}
