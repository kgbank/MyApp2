package com.example.user.myapp2.signup;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp2.R;
import com.example.user.myapp2.member.MemberBean;
import com.example.user.myapp2.member.MemberDAO;
import com.example.user.myapp2.member.MemberService;
import com.example.user.myapp2.member.MemberServiceImpl;

public class SignupActivity extends Activity implements View.OnClickListener{

    EditText etID, etPW, etName, etMail;
//    Button btSignup;
    TextView txResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        etName = (EditText) findViewById(R.id.etNAME);
        etMail = (EditText) findViewById(R.id.etMail);
        etMail = (EditText) findViewById(R.id.etMail);
        txResult = (TextView) findViewById(R.id.txResult);

//        btSignup.setOnClickListener(this);
        findViewById(R.id.btSignup).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String id = etID.getText().toString();
        String pw = etPW.getText().toString();
        String name = etName.getText().toString();
        String email = etMail.getText().toString();
        MemberBean member = new MemberBean();
        MemberService service2 = new MemberServiceImpl();
//        MemberDAO dao = new MemberDAO(this.getApplicationContext());

        member.setId(id);
        member.setPw(pw);
        member.setName(name);
        member.setEmail(email);

//        Log.d(this, "임시...");
        String msg = service2.signup(member);
//        String msg = dao.signup(member);
//        txResult.setText( "회원가입 결과 : " + msg);
        txResult.setText( "회원가입 결과 ^^");
    }
}
