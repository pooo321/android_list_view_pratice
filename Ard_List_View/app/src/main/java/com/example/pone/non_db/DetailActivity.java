package com.example.pone.non_db;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pone on 2017/4/18.
 */

public class DetailActivity extends AppCompatActivity{
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        tv_result = (TextView) findViewById(R.id.tvResult);

        Bundle bundle = getIntent().getExtras();
        Object m = bundle.getSerializable("member");

        tv_result.setText(m.toString());

    }


    public void onBackClick(View view) {

        finish();

    }

}
