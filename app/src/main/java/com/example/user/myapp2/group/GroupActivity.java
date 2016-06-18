package com.example.user.myapp2.group;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapp2.R;

public class GroupActivity extends Activity implements View.OnClickListener{

    GroupDBHelper groupHelper = new GroupDBHelper(GroupActivity.this);
    public SQLiteDatabase db;

    EditText etName, etNum, etResult;
    Button btInit, btFind, btUpdate, btDelete, btList, btCount;
    TextView tvResult;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        etName = (EditText) findViewById(R.id.etName);
        etNum = (EditText) findViewById(R.id.etNum);
//        etResult = (EditText) findViewById(R.id.etResult);
        tvResult = (TextView) findViewById(R.id.tvResult);

        findViewById(R.id.btInit).setOnClickListener(this);
        findViewById(R.id.btInsert).setOnClickListener(this);
        findViewById(R.id.btUpdate).setOnClickListener(this);
        findViewById(R.id.btFind).setOnClickListener(this);
        findViewById(R.id.btDelete).setOnClickListener(this);
        findViewById(R.id.btList).setOnClickListener(this);
        findViewById(R.id.btCount).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String Id = null;
        String Name = null;
        String Num = null;

        switch (v.getId()){
            case R.id.btInit :  //초기화
                db = groupHelper.getWritableDatabase();
                groupHelper.onUpgrade(db, 1, 2);
                db.close();
                Toast.makeText(getApplicationContext(), "초기화성공", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btList :  //목록조회
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * from girl_group;", null);

                Id = "\n\nNO." + "\r\n" + "----------" + "\r\n";
                Name = "\n\n그룹 이름" + "\r\n" + "--------" + "\r\n";
                Num = "\n\n멤버수" + "\r\n" + "---------" + "\r\n";

                while (cursor.moveToNext()){
                    Id += cursor.getInt(0) + "\r\n";
                    Name += cursor.getString(1) + "\r\n";
                    Num += cursor.getInt(2) + "\r\n";
                }
//
                tvResult.setText(Id + Name + Num);
//                tvResult.setText(Name);
//                tvResult.setText(Num);

                cursor.close();
                db.close();

                Toast.makeText(getApplicationContext(), "목록성공", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btCount :  //그룹수 조회
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * from girl_group;", null);

                Num = String.valueOf(cursor.getCount());
                tvResult.setText("DB에 저장된 값 : " + Num );
//                etResult.setText("DB에 저장된 값 : " + Num);

                cursor.close();
                db.close();
//                tvResult.setText("그룹수 완료");
                Toast.makeText(getApplicationContext(), "건수조회성공"+Num, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btInsert :  // 등록
                db = groupHelper.getWritableDatabase();
                if( etName.getText().length() == 0 ){
                    Toast.makeText(getApplicationContext(), "입력값 확인필요", Toast.LENGTH_LONG).show();
                    db.close();
                    break;
                }
                db.execSQL( "INSERT INTO girl_group(name, num) VALUES('"+etName.getText()+"','"+etNum.getText()+"');");
                db.close();
                tvResult.setText("등록완료");
                Toast.makeText(getApplicationContext(), "입력성공", Toast.LENGTH_LONG).show();
                break;

            case R.id.btFind :  // 조회
                db = groupHelper.getReadableDatabase();
                if( etName.getText() == null){
                    Toast.makeText(getApplicationContext(), "입력값 확인필요", Toast.LENGTH_LONG).show();
                    db.close();
                    break;
                }
                cursor = db.rawQuery("SELECT * from girl_group WHERE name = '"+etName.getText()+"';", null);
                while(cursor.moveToNext()){
                    Id = String.valueOf(cursor.getInt(0));
                    Name = cursor.getString(1);
                    Num = String.valueOf(cursor.getInt(2));
                }

                tvResult.setText("NO" + Id + ", 그룹이름" + Name + ". 멤버수" + Num);

                cursor.close();
                db.close();
//                tvResult.setText("조회완료");
                Toast.makeText(getApplicationContext(), "조회성공", Toast.LENGTH_LONG).show();
                break;

            case R.id.btUpdate :  // 수정
                db = groupHelper.getWritableDatabase();

                try {
                    db.execSQL( "UPDATE girl_group set num = "+etNum.getText()+" WHERE name = '"+etName.getText()+"';");
                }
                catch (SQLiteException e){
                    Toast.makeText(getApplicationContext(), "입력값 확인필요", Toast.LENGTH_LONG).show();
                    db.close();
                    break;
                }

                db.close();
                tvResult.setText("수정완료");
                Toast.makeText(getApplicationContext(), "수정성공", Toast.LENGTH_LONG).show();
                break;

            case R.id.btDelete : // 삭제
                db = groupHelper.getWritableDatabase();
                if( etNum == null){
                    Toast.makeText(getApplicationContext(), "입력값 확인필요", Toast.LENGTH_LONG).show();
                    db.close();
                    break;
                }
                db.execSQL( "DELETE FROM girl_group WHERE _id = " + etNum.getText());
                db.close();
                tvResult.setText("삭제완료");
                Toast.makeText(getApplicationContext(), "삭제성공", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
