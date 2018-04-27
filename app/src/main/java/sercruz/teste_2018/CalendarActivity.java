package sercruz.teste_2018;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class CalendarActivity extends AppCompatActivity {
    private static final String TAB = "CalendarActivity";
    private CalendarView mCalendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mCalendar = (CalendarView)findViewById(R.id.calendarView);
        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year +"/"+month+"/"+dayOfMonth;
                Log.d(TAB,"onSelectChanged: date"+date);

            }
        });
    }
}
