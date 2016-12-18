package com.cjava.sqliteexample.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by mobile7 on 18/12/2016.
 */

public class ActivityUtils {

    //Siempre importar los fragments y transctions de support-v4
    public static void addFragmentToActivity(FragmentManager fragmentManager,
                                             Fragment fragment,
                                             int idView){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(idView,fragment);
        fragmentTransaction.commit();


    }
}
