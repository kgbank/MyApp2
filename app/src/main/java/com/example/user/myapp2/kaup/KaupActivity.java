package com.example.user.myapp2.kaup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapp2.R;
import com.example.user.myapp2.main.MainActivity;

public class KaupActivity extends Activity implements View.OnClickListener {

    EditText etName,etWeight,etHeight;
    TextView resultCalc;
    String name,result;
    //    double weight,height;
    Double weight,height;
    int test;
    Button btnCalc, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaup);

        etName = (EditText) findViewById(R.id.name);
        etWeight = (EditText) findViewById(R.id.weight);
        etHeight = (EditText) findViewById(R.id.height);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnCalc.setOnClickListener(this);
        btnBack.setOnClickListener(this);
//        ((Button)findViewById(R.id.btBack)).setOnClickListener(this);
     }

    @Override
    public void onClick(View v) {
        Toast tMsg;
        tMsg = Toast.makeText(this, "getId: "+v.getId() + " 1:" + R.id.btCalc + " 2:" + R.id.btnBack, Toast.LENGTH_LONG);
        tMsg.show();

        switch (v.getId()){
            case R.id.btCalc :

                tMsg = Toast.makeText(this, "토스트연습", Toast.LENGTH_LONG);
                tMsg.show();
                Log.d(result,"카우푸지수");

                name = etName.getText().toString();

                weight = Double.parseDouble(etWeight.getText().toString());
                height = Double.parseDouble(etHeight.getText().toString());
                resultCalc = (TextView) findViewById(R.id.resultCalc);
                //  test = Integer.parseInt(etHeight.getText().toString());

                KaupService service = new KaupServiceImpl();
                result = service.getKaup(weight, height);

                resultCalc.setText(name+"님의 계산결과: " + result);

                break;
            case R.id.btnBack :
                tMsg = Toast.makeText(this, "뒤로가기", Toast.LENGTH_LONG);
                tMsg.show();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
