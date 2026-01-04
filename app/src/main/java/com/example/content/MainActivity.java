package com.example.content;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

/**
* @author   Benjamin Rogachevsky
* @version   1.0
* @since  1/4/26
* This class is the main activity of the application.
*/
public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    TextView answer;
    TextView hint;


    /**
    * This method initializes the EditText and TextView fields.
    * <p>
    *
    */
    public void marriage(){
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        answer = findViewById(R.id.answer);
        hint = findViewById(R.id.hint);
        registerForContextMenu(hint);
    }

    /**
    * This method is called when the activity is first created.
    * <p>
    *
    * @param savedInstanceState A Bundle containing the activity's previously frozen state, if there was one.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marriage();
    }


    /**
    * This method checks if a string is a valid number.
    * <p>
    *
    * @param str The string to be checked.
    * @return boolean Returns true if the string is a valid number, false otherwise.
    */
    public boolean chek(String str){
        if (str == null) {
            return false;
        }
        String regex = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)([eE][+-]?\\d+)?$";

        // 3. Return the result of the match
        return str.matches(regex);
    }


    /**
    * This method is called when a context menu for the view is being built.
    * <p>
    *
    * @param menu The context menu that is being built.
    * @param v The view for which the context menu is being built.
    * @param menuInfo Extra information about the item for which the context menu should be shown.
    */
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


    /**
    * This method is called when a context menu item is selected.
    * <p>
    *
    * @param item The context menu item that was selected.
    * @return boolean Return false to allow normal context menu processing to proceed, true to consume it here.
    */
public boolean onContextItemSelected(MenuItem item){
        CharSequence title = item.getTitle();
        if (title == null) {
            return super.onContextItemSelected(item);
        }
        String s = title.toString();
        String a = num1.getText().toString();
        String b = num2.getText().toString();

        if (chek(a) && chek(b)) {
            double x = Double.parseDouble(a);
            double y = Double.parseDouble(b);

            switch (s) {
                case "add":
                    answer.setText(String.format(Locale.US, "%.3f", x + y));
                    break;
                case "mull":
                    answer.setText(String.format(Locale.US, "%.3f", x * y));
                    break;
                case "division":
                    if (y == 0) {
                        answer.setText("Error: Cannot divide by zero");
                    } else {
                        answer.setText(String.format(Locale.US, "%.3f", x / y));
                    }
                    break;

                case "minus":
                    answer.setText(String.format(Locale.US, "%.3f", x - y));
                    break;


                default:
                    answer.setText("");
                    num1.setText("");
                    num2.setText("");
                    break;
            }

        } else {
            answer.setText("error, please enter a real number, its 1st class in school i belive in you");
        }
        return super.onContextItemSelected(item);
    }
}
