package com.example.user.myapp2.member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public MemberDAO(Context context) {
        super(context, null, null, 1);
        // DB_NAME, null, DB_VERSION
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String signup( MemberBean member ) {
   //     String id = member.getId();
   //     String pw = member.getPw();
   //     String name = member.getName();
   //     String email = member.getEmail();

     //   Log.i( "name", name );
     //   Log.i( "pw", pw );
     //   Log.i( "name", name );
     //   Log.i( "email", email );

        return "회원가입을 축하합니다.";
    }

    public MemberBean login(MemberBean member) {
        MemberBean mem  = new MemberBean();
        mem.setId(member.getId());
        mem.setPw(member.getPw());
        mem.setName(member.getName());
        mem.setEmail(member.getEmail());

        Log.i( "name", member.getId() );
        Log.i( "pw", member.getPw() );
        Log.i( "name", member.getName() );
        Log.i( "email", member.getEmail() );

        return mem;
    }

    public MemberBean update(MemberBean member) {
        MemberBean mem  = new MemberBean();
        mem.setId(member.getId());
        mem.setPw(member.getPw());
        mem.setName(member.getName());
        mem.setEmail(member.getEmail());

        Log.i( "name", member.getId() );
        Log.i( "pw", member.getPw() );
        Log.i( "name", member.getName() );
        Log.i( "email", member.getEmail() );

        return mem;
    }

    public String delete(MemberBean member) {
        return "삭제완료";
    }
}
