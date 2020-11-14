package com.myfirstapplication.assignmentno2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Mcq1Activity2 extends AppCompatActivity {

    boolean[] CorrectedMCQs;
    String[] MCQsArray;

    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    TextView Question;


    int MCQ_NO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcq1);

        MCQsArray = getResources().getStringArray(R.array.MCQsData);
        CorrectedMCQs = new boolean[10];
        for(int i=0;i<10;i++)
        {
            CorrectedMCQs[i] = false;
        }
        MCQ_NO = 1;

        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        Question = findViewById(R.id.question);

        Question.setText("1) "+MCQsArray[0]);
        radioButton1.setText(MCQsArray[1]);
        radioButton2.setText(MCQsArray[2]);
        radioButton3.setText(MCQsArray[3]);
        radioButton4.setText(MCQsArray[4]);
    }

    public void GotoNextMCQ(View view) {
        String selcted_option = "";
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioButton:
                selcted_option = radioButton1.getText().toString();
                break;
            case R.id.radioButton2:
                selcted_option = radioButton2.getText().toString();
                break;
            case R.id.radioButton3:
                selcted_option = radioButton3.getText().toString();
                break;
            case R.id.radioButton4:
                selcted_option = radioButton4.getText().toString();
                break;
        }
        radioGroup.clearCheck();
        int index = ((MCQ_NO-1)*6)+5;
        if(MCQsArray[index].equals(selcted_option))
        {
            CorrectedMCQs[MCQ_NO-1]=true;
        }
        if(MCQ_NO==10)
        {
            Intent intent = new Intent(this,ResultActivity.class);
            intent.putExtra("result",CorrectedMCQs);
            startActivity(intent);
        }
        else
        {
            MCQ_NO++;
            index = (MCQ_NO-1)*6;
            Question.setText(MCQ_NO+") "+MCQsArray[index]);
            radioButton1.setText(MCQsArray[index+1]);
            radioButton2.setText(MCQsArray[index+2]);
            radioButton3.setText(MCQsArray[index+3]);
            radioButton4.setText(MCQsArray[index+4]);
        }
    }
}