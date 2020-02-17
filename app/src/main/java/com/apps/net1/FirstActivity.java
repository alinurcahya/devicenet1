package com.apps.net1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.apps.net1.Util.SessionManager;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";
    RadioGroup rg;
    RadioButton rb;
    Button btnPilih;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        sessionManager = new SessionManager(this);

        if (!sessionManager.isNew()){
            startActivity(new Intent(FirstActivity.this, MainActivity.class));
            finish();
            return;
        }

        rg = findViewById(R.id.rg1);
        btnPilih = findViewById(R.id.btnPilih);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Log.i(TAG, "onCheckedChanged: "+rg.indexOfChild(findViewById(checkedId)));
                rb = findViewById(checkedId);
                btnPilih.setEnabled(true);
            }
        });

        btnPilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sessionManager.updateDevice(rb.getText().toString());
                sessionManager.updateNew(false);
                startActivity(new Intent(FirstActivity.this, MainActivity.class));
                finish();
            }
        });

    }
}
