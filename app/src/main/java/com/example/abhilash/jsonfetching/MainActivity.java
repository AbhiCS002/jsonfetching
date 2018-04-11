package com.example.abhilash.jsonfetching;

/**
 * Created by abhilash on 10/4/18.
 */
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends ListActivity implements FetchDataListener{
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        // show progress dialog
        dialog = ProgressDialog.show(this, "", "Loading...");

        String url = "http://10.0.2.2/areca.php";
        FetchDataTask task = new FetchDataTask(this);
        task.execute(url);
    }

    @Override
    public void onFetchComplete(List<Application> data) {
        // dismiss the progress dialog
        if(dialog != null)  dialog.dismiss();
        // create new adapter
        ApplicationAdapter adapter = new ApplicationAdapter(this, data);
        // set the adapter to list
        setListAdapter(adapter);
    }

    @Override
    public void onFetchFailure(String msg) {
        // dismiss the progress dialog
        if(dialog != null)  dialog.dismiss();
        // show failure message
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}