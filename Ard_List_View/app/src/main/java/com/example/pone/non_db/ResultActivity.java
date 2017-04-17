package com.example.pone.non_db;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;


/**
 * Created by pone on 2017/4/12.
 */

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        tvResult = (TextView) findViewById(R.id.tvResult);

        showResult();
    }

    private void showResult() {
        Bundle bundle = getIntent().getExtras();
        Object pr_member = bundle.getSerializable("member");
        tvResult.setText(pr_member.toString());

//        tvResult.setText();


    }

    public void onBackClick(View view) {

        Member member = null;
        Bundle bundle = getIntent().getExtras();
        member = (Member) bundle.getSerializable("member");
//
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        bundle.putSerializable("member", member);
        intent.putExtras(bundle);

        startActivity(intent);
        ResultActivity.this.finish();
    }


}
