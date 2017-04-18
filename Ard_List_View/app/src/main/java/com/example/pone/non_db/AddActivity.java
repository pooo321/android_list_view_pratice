package com.example.pone.non_db;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by pone on 2017/4/12.
 */

public class AddActivity extends AppCompatActivity {
    private EditText etName, etAge, etSex, etMajor;
    private Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        btSubmit = (Button) findViewById(R.id.submit);
//        Intent intent = this.getIntent();

        addData();

    }


    private void addData() {
        etName = (EditText) findViewById(R.id.name_input);
        etAge = (EditText) findViewById(R.id.age_input);
        etSex = (EditText) findViewById(R.id.sex_input);
        etMajor = (EditText) findViewById(R.id.major_input);

    }

    private boolean isValid(EditText et) {
        String sexPattern = "[男|女]|[其][他]{1,2}";
        String text = et.getText().toString();

        if (!text.matches(sexPattern)) {
            et.setError("請輸入男、女或其他");
            return false;
        } else {
            return true;
        }
    }


    public void onSubmitClick(View view) {

        boolean isValid = isValid(etSex);
        if (!isValid) {
            return;
        }

        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String sex = etSex.getText().toString();
        String major = etMajor.getText().toString();

        Member member = new Member(name, age, sex, major);

        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable("member", member);
        intent.putExtras(bundle);

        startActivity(intent);
        finish();

    }
}
