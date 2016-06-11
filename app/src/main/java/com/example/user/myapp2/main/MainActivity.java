package com.example.user.myapp2.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapp2.R;
import com.example.user.myapp2.calc.CalcActivity;
import com.example.user.myapp2.kaup.KaupActivity;
import com.example.user.myapp2.login.LoginActivity;
import com.example.user.myapp2.signup.SignupActivity;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("안드로이드교육 다운엑티비티");
        setContentView(R.layout.activity_main);

//        btn4 = (Button) findViewById(R.id.btn4);
//        tvName = (TextView) findViewById(R.id.tvName);

        findViewById(R.id.btKaup).setOnClickListener(this);
        findViewById(R.id.btCalc).setOnClickListener(this);
 //       ((Button) findViewById(R.id.btnCalc)).setOnClickListener(this);
        findViewById(R.id.btLogin).setOnClickListener(this);
        findViewById(R.id.btSignup).setOnClickListener(this);
//        Calc.setOnClickListener(this);
//        Login.setOnClickListener(this);
//        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast tMsg;
//        Intent intent;
        switch (v.getId()){
            case R.id.btKaup :
                //setContentView(R.layout.activity_kaup);
//                tMsg = Toast.makeText(this, "btKaup", Toast.LENGTH_LONG);
//                tMsg.show();
//                intent = new Intent(this, KaupActivity.class);
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btCalc :
//                setContentView(R.layout.activity_calc);
//                tMsg = Toast.makeText(this, "btCalc", Toast.LENGTH_LONG);
//                tMsg.show();
                startActivity(new Intent(this, CalcActivity.class));
                break;
            case R.id.btLogin :
//                setContentView(R.layout.activity_calc);
//                tMsg = Toast.makeText(this, "btLogin", Toast.LENGTH_LONG);
//                tMsg.show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btSignup :
//                setContentView(R.layout.activity_calc);
//                tMsg = Toast.makeText(this, "btLogin", Toast.LENGTH_LONG);
//                tMsg.show();
                startActivity(new Intent(this, SignupActivity.class));
                break;
        }
    }
}