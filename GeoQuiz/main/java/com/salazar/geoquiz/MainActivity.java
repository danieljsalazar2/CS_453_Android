package com.salazar.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton,mFalseButton, mLeftButton, mRightButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
            new Question(R.string.question_australia, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_oceans, true)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView
        mQuestionTextView = (TextView)findViewById(R.id.textView);
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getTextResId());

        // True Button
        mTrueButton = (Button)findViewById(R.id.button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        // False Button
        mFalseButton = (Button)findViewById(R.id.button2);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        // Left Button
        mLeftButton = (Button)findViewById(R.id.left_button);
        mLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getTextResId());
            }
        });

        // Right Button
        mRightButton = (Button)findViewById(R.id.right_button);
        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getTextResId());
            }
        });
    }
    private void checkAnswer(boolean userInput){
        Toast t = Toast.makeText(MainActivity.this,
                (userInput == mQuestionBank[mCurrentIndex].isAnswerTrue()) ? (R.string.correct_toast) : (R.string.incorrect_toast),
                Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP, 0, 150);
        t.show();
    }
}
