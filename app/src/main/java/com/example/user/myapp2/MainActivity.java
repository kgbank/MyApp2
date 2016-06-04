package com.example.user.myapp2;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {

    EditText edName;
    EditText edKg;
    EditText edCm;
    Button btRes;
    TextView tvRes;
    double Kg, Cm, Res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("카우프 프로그램");

        edName = (EditText) findViewById(R.id.idName);
        edKg = (EditText) findViewById(R.id.idKg);
        edCm = (EditText) findViewById(R.id.idCm);
        btRes = (Button) findViewById(R.id.btRes);
        tvRes = (TextView) findViewById(R.id.tvRes);


        btRes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Kg = Double.parseDouble(edKg.getText().toString());
                Cm = Double.parseDouble(edCm.getText().toString());
                Res = (Kg/(Cm*Cm))*10000;

                if ( Res > 24 )
                    tvRes.setText(edName.getText().toString()+" 과체중입니다.");
                else
                if ( Res > 20 )
                    tvRes.setText(edName.getText().toString()+" 정상입니다.");
                else
                if ( Res > 15 )
                    tvRes.setText(edName.getText().toString()+" 저체중입니다.");
                else
                if ( Res > 13 )
                    tvRes.setText(edName.getText().toString()+" 마름입니다.");
                else
                if ( Res > 10 )
                    tvRes.setText(edName.getText().toString()+" 영양실조입니다.");
                else
                    tvRes.setText(edName.getText().toString()+" 소모증입니다.");

                return false;
            }
        });
    }
}
