package com.vlad.chart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LineChart chart;
    EditText A,B,foo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = findViewById(R.id.editText);
        B = findViewById(R.id.editText2);
        foo = findViewById(R.id.editText3);
        chart = (LineChart) findViewById(R.id.chart);
        ProcessingData();
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessingData();
            }
        });
    }
    void ProcessingData(){
        List<Entry> entries = new ArrayList<Entry>();

        for (float data = Float.parseFloat(A.getText().toString());data<Float.parseFloat(B.getText().toString());data++) {
            float Y = (float) (Math.sin(data)/data);
            entries.add(new Entry(data, Y));
        }
        LineDataSet dataSet = new LineDataSet(entries, "y=sin(x)/x"); // add entries to dataset
        dataSet.setColor(Color.BLUE);
        LineData lineData = new LineData(dataSet);
        dataSet.setValueTextColor(Color.GREEN); // styling, ...
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}
