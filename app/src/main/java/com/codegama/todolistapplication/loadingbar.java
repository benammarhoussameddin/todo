package com.codegama.todolistapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class loadingbar {
    Activity activity;
    AlertDialog alertdialog;
    loadingbar(Activity thisactivity){
        activity=thisactivity;
    }
    void showdialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        LayoutInflater linf=activity.getLayoutInflater();
        builder.setView(linf.inflate(R.layout.progressbar,null));
        alertdialog=builder.create();
        alertdialog.show();
    }
    void dism(){
        alertdialog.dismiss();
    }
}
