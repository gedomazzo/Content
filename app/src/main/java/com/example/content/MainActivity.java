package com.example.content;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    TextView answer;
    TextView txt2;



    public void merrage(){
        num1 = (EditText) findViewById(R.id.ed1);
        num2 = (EditText) findViewById(R.id.ed2);
        answer = (TextView) findViewById(R.id.txt);
        txt2 = (TextView) findViewById(R.id.txt2);
        registerForContextMenu(txt2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        merrage();
    }


    public boolean chek(String str){
        if (str == null) {
            return false;
        }
        String regex = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)([eE][+-]?\\d+)?$";

        // 3. Return the result of the match
        return str.matches(regex);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose action");
        menu.add(0, 1, 100, "add");
        menu.add(0, 2, 200, "mull");
        menu.add(0, 3, 300, "minus");
        menu.add(0, 4, 400, "division");
        menu.add(0, 5, 500, "clear");


    }

public boolean onContextItemSelected(MenuItem item){
        String s = item.getTitle().toString();
        String a = num1.getText().toString();
        String b = num2.getText().toString();


        if (chek(a) && chek(b)) {
            double x = Double.parseDouble(a);
            double y = Double.parseDouble(b);

            if (s.equals("add")) {
                answer.setText(String.format("%.3f", x+y));
            } else if (s.equals("mull")) {
                answer.setText(String.format("%.3f", x*y));
            } else if (s.equals("division")) {
                answer.setText(String.format("%.3f", x/y));
            } else if (s.equals("minus")){
                answer.setText(String.format("%.3f", x-y));
            } else {
                answer.setText("");
                num1.setText("");
                num2.setText("");
            }
        } else {
            answer.setText("error, please enter a real number, its 1st class in school i belive in you");
        }
    return super.onContextItemSelected(item);
}




//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
//
//
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        String s = item.getTitle().toString();
//        double x = Double.parseDouble(num1.getText().toString());
//        double y = Double.parseDouble(num2.getText().toString());
//
//        if (s.equals("clear")){
//            answer.setText("");
//            num1.setText("");
//            num2.setText("");
//        }
//
//        if (chek()) {
//
//            if (s.equals("add")) {
//                answer.setText(String.format("%.3f", x+y));
//            } else if (s.equals("mul")) {
//                answer.setText(String.format("%.3f", x*y));
//            } else if (s.equals("division")) {
//                answer.setText(String.format("%.3f", x/y));
//            } else {
//                answer.setText(String.format("%.3f", x-y));
//            }
//        }
//        return true;
//    }


}


