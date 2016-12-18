package com.cjava.sqliteexample.data;

import java.io.Serializable;

/**
 * Created by mobile7 on 18/12/2016.
 */

public class TaskEntity  implements Serializable{
    private String id;
    private String mTaskDetail;
    private int mStatus;

    public TaskEntity(int mStatus, String mTaskDetail) {
        this.mStatus = mStatus;
        this.mTaskDetail = mTaskDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getmStatus() {
        return mStatus;
    }

    public void setmStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public String getmTaskDetail() {
        return mTaskDetail;
    }

    public void setmTaskDetail(String mTaskDetail) {
        this.mTaskDetail = mTaskDetail;
    }
}
