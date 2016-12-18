package com.cjava.sqliteexample.presentation.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cjava.sqliteexample.R;
import com.cjava.sqliteexample.data.TaskEntity;
import com.cjava.sqliteexample.presentation.contracts.TaskContracts;

/**
 * Created by mobile7 on 18/12/2016.
 */

public class AddTaskDialog extends AlertDialog {


    private TaskContracts.View mView;
    private Button button;
    private EditText editText;

    public AddTaskDialog(@NonNull Context context,TaskContracts.View contracView) {
        super(context);
        this.mView=contracView;
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        final View view = layoutInflater.inflate(R.layout.dialog_add_task,null);
        setView(view);

        button = (Button) view.findViewById(R.id.button);
        editText = (EditText) view.findViewById(R.id.et_task);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.addTaskFromDialog(new TaskEntity(0,
                        editText.getText().toString()));
                dismiss();
            }
        });
    }
}
