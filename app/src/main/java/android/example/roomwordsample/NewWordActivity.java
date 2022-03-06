package android.example.roomwordsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_REPLY_NAME = "com.example.android.wordlistsql.REPLY_name";
    public static final String EXTRA_REPLY_NUMBER = "com.example.android.wordlistsql.REPLY_number";
    private EditText mEditWordView;
    private EditText mEditNumView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.edit_word);
        mEditNumView = findViewById(R.id.edit_number);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent replyIntent = new Intent();
        if(TextUtils.isEmpty(mEditWordView.getText())){
            setResult(RESULT_CANCELED, replyIntent);
        }
        else{
            String name = mEditWordView.getText().toString();
            String number = mEditNumView.getText().toString();
            replyIntent.putExtra(EXTRA_REPLY_NAME, name);
            replyIntent.putExtra(EXTRA_REPLY_NUMBER, number);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
    }
}