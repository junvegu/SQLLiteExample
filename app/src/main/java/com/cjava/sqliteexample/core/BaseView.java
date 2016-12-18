package com.cjava.sqliteexample.core;

/**
 * Created by mobile7 on 18/12/2016.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void showMessage(String msg);

    void showMessageError(String msg);


}
