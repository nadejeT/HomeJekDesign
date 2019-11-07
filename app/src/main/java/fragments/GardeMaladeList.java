package fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.homejek.ui.R;

import java.util.ArrayList;
import java.util.Calendar;

import Adapter.MaladeAdapter;
import Models.MaladeModelList;
import androidx.fragment.app.Fragment;


public class GardeMaladeList extends Fragment {

    private ArrayList<MaladeModelList> maladeList = new ArrayList<>();
    LinearLayout date_lay, from_lay, to_lay;
    TimePickerDialog from_heure, to_heure;
    TextView date_txt, from_txt, to_txt;
    private Spinner tranche_age_spinner;
    private int mMonth, mYear, mDay;
    private customfonts.MyTextView_SF_Pro_Display_Medium nextBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_garde_malade_list, container, false);
        /////////DATE + HEURE
        date_lay = v.findViewById(R.id.gm_date_lay);
        from_lay = v.findViewById(R.id.gm_from_lay);
        to_lay = v.findViewById(R.id.gm_to_lay);

        date_txt = v.findViewById(R.id.gm_date_txt);
        from_txt = v.findViewById(R.id.gm_from_txt);
        to_txt = v.findViewById(R.id.gm_to_txt);

        Calendar c = Calendar.getInstance();
        //Time
        int seconds = c.get(Calendar.SECOND);
        int minutes = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR);
        String mytime = hour + ":" + minutes + ":" + seconds;

        from_txt.setText(mytime);
        to_txt.setText(mytime);

        //Date
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        String mydate = day + "/" + month + "/" + year;
        date_txt.setText(mydate);

        date_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                final DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                date_txt.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
                int coMonth = c.get(Calendar.MONTH);
                int coDay = c.get(Calendar.DAY_OF_MONTH);
            }
        });

        from_lay.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View v) {
                    final Calendar cldr1 = Calendar.getInstance();
                    int hour = cldr1.get(Calendar.HOUR_OF_DAY);
                    int minutes = cldr1.get(Calendar.MINUTE);
                    final int secon = cldr1.get(Calendar.SECOND);
                    // time picker dialog
                    from_heure = new TimePickerDialog(getContext(),
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                    from_txt.setText(sHour + ":" + sMinute + ":"+secon);
                                }
                            }, hour, minutes, true);
                    from_heure.show();
            }

        });

        to_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr1 = Calendar.getInstance();
                int hour = cldr1.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr1.get(Calendar.MINUTE);
                final int seconds = cldr1.get(Calendar.SECOND);
                // time picker dialog
                to_heure = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                to_txt.setText(sHour + ":" + sMinute + ":"+seconds);
                            }
                        }, hour, minutes, true);
                to_heure.show();
            }
        });

        /////////////////////
        nextBtn = v.findViewById(R.id.next1malade);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction().addToBackStack("fragment")
                        .replace(R.id.container, new fragments.CoiffureDevis()).commit();
            }
        });

        //Spinner
        tranche_age_spinner = v.findViewById(R.id.gm_spinner);
        String[] tranch_age = {"1-3ans","4-7ans","8-12ans","13-16ans"};
        ArrayAdapter tranche_age_adapter = new ArrayAdapter(this.getContext(), R.layout.simple_spinner_item,tranch_age);
        tranche_age_adapter.setDropDownViewResource(R.layout.spinner_dropdown_design);
        tranche_age_spinner.setAdapter(tranche_age_adapter);
        //***********


        return v;
    }

    public void onAttach(Context context){
        super.onAttach(context);
    }


}