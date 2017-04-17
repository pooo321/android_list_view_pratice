package com.example.pone.non_db;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Member> memberList;
    getList list = new getList();
    boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMember();

        Button bt_add = (Button) findViewById(R.id.add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 132);
                finish();
            }
        });

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ListAdapter(this));

        TextView result = (TextView) findViewById(R.id.result);
        result.setText("共" + list.getCount() + "筆資料");

    }

    private class ListAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;

        public ListAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);

            memberList = list.initList(first);

        }

        @Override
        public int getCount() { return memberList.size(); }

        @Override
        public Object getItem(int position) {
            return memberList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.list_view, parent, false);
            }

            Member member = memberList.get(position);

            TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            tv_name.setText(member.getName());

            TextView tv_age = (TextView) convertView.findViewById(R.id.tv_age);
            tv_age.setText(String.valueOf(member.getAge()));

            TextView tv_sex = (TextView) convertView.findViewById(R.id.tv_sex);
            tv_sex.setText(member.getSex());

            TextView tv_major = (TextView) convertView.findViewById(R.id.tv_major);
            tv_major.setText(member.getMajor());

            return convertView;
        }
    }

    private void getMember() {

        Bundle bundle = getIntent().getExtras();

        if (bundle != null ) {

            first = false;
            Object member = bundle.getSerializable("member");
            list.insertMember(member);
            bundle.clear();

        }

    }

}
