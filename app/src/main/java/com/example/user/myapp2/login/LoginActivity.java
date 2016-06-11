package com.example.user.myapp2.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.user.myapp2.R;
import com.example.user.myapp2.member.MemberBean;
import com.example.user.myapp2.member.MemberService;
import com.example.user.myapp2.member.MemberServiceImpl;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements View.OnClickListener{

    EditText etID, etPW, etName, etMail;
    //    Button btSignup;
    TextView txResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        etName = (EditText) findViewById(R.id.etNAME);
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
        MemberService service = new MemberServiceImpl();
//        MemberDAO dao = new MemberDAO(this.getApplicationContext());

        member.setId(id);
        member.setPw(pw);
        member.setName(name);
        member.setEmail(email);

//        Log.d(this, "임시...");
//        String msg = service.signup(member);
        service.signup(member);
//        String msg = dao.signup(member);
//        txResult.setText( "회원가입 결과 : " + msg);
        txResult.setText( "회원가입 결과 ^^");
    }
}

