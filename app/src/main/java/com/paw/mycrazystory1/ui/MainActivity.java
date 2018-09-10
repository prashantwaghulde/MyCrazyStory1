package com.paw.mycrazystory1.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.paw.mycrazystory1.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.nameEditText);
        buttonStart = findViewById(R.id.startButton);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                startStory(name);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        editTextName.setText("");
    }

    private void startStory(String name) {
        Intent intent = new Intent(this,StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);
        intent.putExtra(key,name);
        startActivity(intent);
    }
}
