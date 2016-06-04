package com.example.user.myapp2.calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapp2.R;
import com.example.user.myapp2.main.MainActivity;

public class CalcActivity extends Activity implements View.OnClickListener{

    EditText etVal1, etVal2;
    Button btn1, btn2, btn3, btn4, btnBack;
    TextView tvName;
    int num1, num2, rtn;
    CalcService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        setTitle("개산기");
        service = new CalcServiceImpl();

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btnBack = (Button) findViewById(R.id.btnBack);
        tvName = (TextView) findViewById(R.id.tvName);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnBack.setOnClickListener(this);

//        btn1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
////            num1 = Integer.parseInt(etVal1.toString());
////            num2 = Integer.parseInt(etVal2.toString());
////                rtn = Integer.parseInt(etVal1.getText().toString()) + Integer.parseInt(etVal2.getText().toString());
////            result = num1 + num2;
//                tvName.setText("계산결과 : " + etVal1.getText().toString());
//
//                return false;
//            }
//
//        });
    }

    @Override
    public void onClick(View v) {

        Toast tMsg = Toast.makeText(this, "getId: "+v.getId() + " 1:" + R.id.btnBack, Toast.LENGTH_LONG);
        tMsg.show();

        if( v.getId() == R.id.btnBack ){
            startActivity(new Intent(this, MainActivity.class));
        }
        else {
            etVal1 = (EditText) findViewById(R.id.etVal1);
            etVal2 = (EditText) findViewById(R.id.etVal2);
            num1 = Integer.parseInt(etVal1.getText().toString());
            num2 = Integer.parseInt(etVal2.getText().toString());

            switch (v.getId()){
                case R.id.btn1:
                    rtn = service.plus(num1, num2);
                    break;
                case R.id.btn2:
                    rtn = service.minus(num1, num2);
                    break;
                case R.id.btn3:
                    rtn = service.mult(num1, num2);
                    break;
                case R.id.btn4:
                    rtn = service.divide(num1, num2);
                    break;
            }

            tvName.setText("계산결과 : " + rtn );
        }

    }
}
