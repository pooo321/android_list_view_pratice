package com.example.pone.non_db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pone on 2017/4/12.
 */

public class getList {
    public static List<Member> memberList;


    public getList() {
        super();
    }

    public List<Member> initList(boolean first) {

        if ( first ) {
            memberList = new ArrayList<>();
            memberList.add(new Member("張三", "20", "男", "資管"));
            memberList.add(new Member("李四", "22", "男", "資工"));
            memberList.add(new Member("瑪麗", "18", "女", "企管"));
        }

        return memberList;
    }

    public void insertMember(Object member) {
        memberList.add((Member) member);
    }

}
