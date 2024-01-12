package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.note.databinding.ActivityDataInsert2Binding;

public class DataInsertActivity2 extends AppCompatActivity {
    ActivityDataInsert2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDataInsert2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("title",binding.title.getText().toString());
                intent.putExtra("disp",binding.dsip.getText().toString());
                setResult(RESULT_OK,intent);
                finish();

            }
        });
    }
}