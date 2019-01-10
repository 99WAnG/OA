package com.example.charlie.sticky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends Activity {
    private  TextView  user;
    private TextView  pass;
    private EditText editText1;
    private EditText editText2;
    private Button button1;
    private  TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.editText1=(EditText) findViewById(R.id.editText1);
        this.editText2=(EditText) findViewById(R.id.editText2);
        this.button1=(Button) findViewById(R.id.login_btn);
        this.textView3=(TextView)findViewById(R.id.textView3);
        this.button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginActivity.this,StickyActivity.class);
                String user=editText1.getText().toString();
                String pass=editText2.getText().toString();
                if (user.equals("ahjzu")&&pass.equals("66668888")) {
                    Toast.makeText(loginActivity.this, "用户名密码正确",Toast.LENGTH_LONG).show();
                    //textView3.setText("用户名密码正确");
                    startActivity(intent);

                }
                else {

                    Toast.makeText(loginActivity.this, "用户名或密码错误",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

