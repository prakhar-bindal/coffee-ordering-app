package com.example.prakhar.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int teama=0;
    int teamb=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void firstpointer(View view)
    {
        teama=teama+3;
        displaya(teama);
    }
    public void secondpointer(View view)
    {
        teama=teama+2;
        displaya(teama);
    }
    public void thirdpointer(View view)
    {
        teama = teama+1;
        displaya(teama);
    }
    private void displaya(int a)
    {
        TextView scoreTextView = (TextView) findViewById(R.id.text_a);
        scoreTextView.setText(String.valueOf(a));
    }
    public void firstpointerb(View view)
    {
        teamb=teamb+3;
        displayb(teamb);
    }
    public void secondpointerb(View view)
    {
        teamb=teamb+2;
        displayb(teamb);
    }
    public void thirdpointerb(View view)
    {
        teamb = teamb+1;
        displayb(teamb);
    }
    private void displayb(int a)
    {
        TextView scoreTextView = (TextView) findViewById(R.id.text_b);
        scoreTextView.setText(String.valueOf(a));
    }
    public void reset(View view)
    {
        teama=0;
        teamb=0;
        displaya(teama);
        displayb(teamb);
    }
}
