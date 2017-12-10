package com.example.knot.easywallet;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.knot.easywallet.Helper.income;
import com.example.knot.easywallet.Helper.expense;

public class MainActivity extends AppCompatActivity {
    private Button inbutton;
    private Button exbutton;
    private ListView mListView;

    private  final indata inex = indata.getsInstance();

    private CardioDb mHelper;
    private SQLiteDatabase mDb;
    private CardioListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inbutton =findViewById(R.id.Income_Button);
        exbutton = findViewById(R.id.Expense_Button);
        mListView = findViewById(R.id.list_view);

        inbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,income.class);
                startActivity(intent);
            }
        });

        exbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,expense.class);
                startActivity(intent);
            }
        });

    }

}
