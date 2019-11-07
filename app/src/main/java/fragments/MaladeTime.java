package fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.homejek.ui.R;

import java.util.Calendar;


public class MaladeTime extends Fragment {

    TextView dateMalade, fromTime, toTime;
    TimePickerDialog fromTime_picker, toTime_picker;
    customfonts.MyTextView_SF_Pro_Display_Medium suivantMaladeToCmd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_malade_time, container, false);

        dateMalade = v.findViewById(R.id.choosedate);
        fromTime = v.findViewById(R.id.fromtxt);
        toTime = v.findViewById(R.id.totxt);
        suivantMaladeToCmd = v.findViewById(R.id.maladetime_suivant);
        suivantMaladeToCmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction().addToBackStack("fragment")
                        .replace(R.id.container, new fragments.CoiffureDevis()).commit();
            }
        });

        dateMalade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog datepicker = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateMalade.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datepicker.show();
            }

        });

        fromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr1 = Calendar.getInstance();
                int hour = cldr1.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr1.get(Calendar.MINUTE);
                // time picker dialog
                fromTime_picker = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                fromTime.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                fromTime_picker.show();
            }
        });

        toTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr2 = Calendar.getInstance();
                int hour = cldr2.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr2.get(Calendar.MINUTE);
                // time picker dialog
                toTime_picker = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                toTime.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                toTime_picker.show();
            }
        });


        return v;

    }


}
