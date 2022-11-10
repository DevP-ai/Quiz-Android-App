package com.dev.android.quiz;

import static android.graphics.Color.WHITE;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView total_question;
    TextView question_view;
    Button ans_A,ans_B,ans_C,ans_D;
    Button submit_btn;


    int score=0;
    int totalQuestion=QuestionAnswer.question.length;
    int currentQuestionIndex=0;
    String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total_question=findViewById(R.id.total_question);
        question_view=findViewById(R.id.question_view);
        ans_A=findViewById(R.id.ans_A);
        ans_B=findViewById(R.id.ans_B);
        ans_C=findViewById(R.id.ans_C);
        ans_D=findViewById(R.id.ans_D);
        submit_btn=findViewById(R.id.submit_btn);

        ans_A.setOnClickListener(this);
        ans_B.setOnClickListener(this);
        ans_C.setOnClickListener(this);
        ans_D.setOnClickListener(this);
        submit_btn.setOnClickListener(this);

        total_question.setText("Total Questions: "+totalQuestion);


        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ans_A.setBackgroundColor(getColor(R.color.black));
        ans_B.setBackgroundColor(getColor(R.color.black));
        ans_C.setBackgroundColor(getColor(R.color.black));
        ans_D.setBackgroundColor(getColor(R.color.black));

        ans_A.setTextColor(getColor(R.color.white));
        ans_B.setTextColor(getColor(R.color.white));
        ans_C.setTextColor(getColor(R.color.white));
        ans_D.setTextColor(getColor(R.color.white));



        Button clickedButton=(Button) view;

        if(clickedButton.getId()==R.id.submit_btn)
        {

            if(selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex]))
            {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }
        else
        {
            selectedAnswer=clickedButton.getText().toString();
            clickedButton.setBackgroundColor(getColor(R.color.white));
            clickedButton.setTextColor(getColor(R.color.black));
        }
    }
    void loadNewQuestion()
    {
        if(currentQuestionIndex==totalQuestion)
        {
            finishQuiz();
            return;
        }
        question_view.setText(QuestionAnswer.question[currentQuestionIndex]);

        ans_A.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ans_B.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ans_C.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ans_D.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

    }

    void finishQuiz()
    {
       String Status="";

       if(score>totalQuestion*0.60)
       {
           Status="Passed";
       }else{
           Status="Failed";
       }

       new AlertDialog.Builder(this)
               .setTitle(Status)
               .setMessage("Score is: "+score+" out of "+totalQuestion)
               .setPositiveButton("Restart",(dialog, which) -> restartQuiz())
               .setNegativeButton("Quit",(dialog, which) -> QuitQuiz())
               .show();
    }
    void restartQuiz()
    {
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }
    void QuitQuiz()
    {
        finish();
    }
}