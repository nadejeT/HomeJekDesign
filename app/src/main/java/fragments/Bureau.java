package fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.homejek.ui.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Bureau extends Fragment {

    Spinner spinner;
    LinearLayout calender1;
    TextView today1;
    customfonts.MyTextView_SF_Pro_Display_Medium confirmer;
    private int mMonth, mYear, mDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_bureau, container, false);

        today1 = view.findViewById(R.id.bureau_date_txt);
        confirmer = view.findViewById(R.id.confirmerbtn_bureau);
        calender1 =  view.findViewById(R.id.bureau_date_lay);
        calender1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                final DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                today1.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
                int coMonth = c.get(Calendar.MONTH);
                int coDay = c.get(Calendar.DAY_OF_MONTH);
            }
        });

        /*spinner code*/
        spinner = view.findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Société un étage");
        list.add("Société 2 étages");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_design);
        spinner.setAdapter(dataAdapter);


        confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (getActivity()).getSupportFragmentManager()
                        .beginTransaction().addToBackStack("fragment")
                        .replace(R.id.container, new fragments.CoiffureDevis()).commit();
            }
        });


        //Date today

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        String mydate = day + "/" + month + "/" + year;
        today1.setText(mydate);
        return view;
    }

}
