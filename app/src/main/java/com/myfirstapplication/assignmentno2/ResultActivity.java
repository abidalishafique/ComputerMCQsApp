package com.myfirstapplication.assignmentno2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        String[] MCQS = getResources().getStringArray(R.array.MCQsData);
        boolean[] result = getIntent().getBooleanArrayExtra("result");

        TextView textView = findViewById(R.id.myScore);
        final ArrayList<String> wrongMCQS = new ArrayList<String>();
        int count=0;
        for(int i=0;i<result.length;i++)
        {
            if(result[i])
            {
                count++;
            }
            else
            {
                String val =  "MCQ no"+String.valueOf(i+1) +":  ----> "+MCQS[(i*6)+5];
                wrongMCQS.add(val);
            }
        }
        textView.setText(count+"/10");
        ListView listView = findViewById(R.id.WrongMCQsList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,wrongMCQS);
        listView.setAdapter(arrayAdapter);
    }
}