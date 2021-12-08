package com.example.androidonkotlinlesson1;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText editText = findViewById(R.id.input_text);
        Button btn = findViewById(R.id.button);
        TextView textView = findViewById(R.id.message);
        Button btnFragment = findViewById(R.id.btn_fragment);

        btn.setOnClickListener(v -> {
            Editable message = editText.getText();

            if (message == null) textView.setText("Введите текст");
            else if (message.length() > 5) textView.setText(message);
            else textView.setText("Введите более 5 символов");

        });

        btnFragment.setOnClickListener(v -> getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, BlankFragment.newInstance())
                .addToBackStack("1")
                .commit());
    }
}