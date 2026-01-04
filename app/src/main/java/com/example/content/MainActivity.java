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



    public void merrage(){
        num1 = (EditText) findViewById(R.id.ed1);
        num2 = (EditText) findViewById(R.id.ed2);
        answer = (TextView) findViewById(R.id.txt);
        registerForContextMenu(answer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        merrage();
    }


    public boolean chek(){
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose action");
        menu.add(0, 1, 100, "Copy");
        menu.add(0, 2, 200, "Delete");
    }

public boolean onContextIteamSelected(MenuItem item){
    switch (item.getItemId()) {
        case 100:
            // Copy action
            return true;
        case 200:
            // Delete action
            return true;
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


