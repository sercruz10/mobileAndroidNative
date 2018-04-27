package sercruz.teste_2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAB = "MainActivity";
    private TextView theData;
    private Button goCalendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theData = (TextView) findViewById(R.id.data);
        goCalendar = (Button) findViewById(R.id.button);

     goCalendar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
             startActivity(intent);

         }
     });


    }
}
