package com.cjava.sqliteexample.presentation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cjava.sqliteexample.R;
import com.cjava.sqliteexample.data.TaskEntity;

import java.util.ArrayList;

/**
 * Created by mobile7 on 18/12/2016.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    private Context context;
    private ArrayList<TaskEntity> taskEntities;

    public TaskAdapter(Context context, ArrayList<TaskEntity> taskEntities) {
        this.context = context;
        this.taskEntities = taskEntities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =
                LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.item_task,parent,false);
        return new ViewHolder(view);
    }

    public void setItems(ArrayList<TaskEntity> items){
        this.taskEntities=items;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//
        TaskEntity taskEntity = taskEntities.get(position);

        holder.textView.setText(taskEntity.getmTaskDetail());

        if(taskEntity.getmStatus()==0){
            holder.checkBox.setChecked(false);
        }else{
            holder.checkBox.setChecked(true);
        }

    }

    @Override
    public int getItemCount() {
        return taskEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private CheckBox checkBox;


        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_detail);
            checkBox = (CheckBox) itemView.findViewById(R.id.cb_status);
        }
    }
}
