package com.biz.helloapp;

import android.content.Intent;
import android.os.Bundle;

import com.biz.helloapp.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);

        setContentView(R.layout.my_layout);

        // layout xml에서 선언한 객체 component를 사용할테니
        // 객체로 만들어 달라.
        txtInput = findViewById(R.id.txtInput);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);

        // btn1이 터치나 클릭됐을 때 할일을 지정해줄 수 있다.
        // 익명클래스 방식으로 클릭 이벤트를 설정
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = txtInput.getText().toString();

                // Toast
                // 클릭을 하여 이벤트를 주었을 때
                // 토스트처럼 작동이되면 툭 튀어나오는 것을 의미한다.
                Toast.makeText(MainActivity.this,
                        txt,
                        Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                // 문자열만 타이핑하면 text: 라는 속성이 나타난다.
                // Snack바는 본인을 포함하고 있는 Button(Btn이 부모)안에서 작동한다.
                Snackbar.make(v, "안녕하세요", Snackbar.LENGTH_LONG ).show();
            }
        });
        // btn2.setOnclickListener();

      //  Toolbar toolbar = findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                    새로운 Activity를 화면에 띄울때
                    Intent 클래스로 객체를 생성하고
                    startActivity() method에게 객체를 주입하면 된다.
                 */
                // 현재 화면(MainActivity.this)에서
                // 새로운 Activity가 보이도록 Intent를 생성하라
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);

                // 생성된 새로운 인텐트가 보이도록 하라
                startActivity(loginIntent);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pIntent = new Intent(Intent.ACTION_CALL_BUTTON);
                startActivity(pIntent);

            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
