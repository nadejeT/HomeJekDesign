package fragments;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.homejek.ui.R;

import java.util.ArrayList;

import Adapter.BabyAdapter;
import Adapter.MaladeAdapter;
import Dialog.BabyDialog;
import Models.BabyModelList;
import Models.MaladeModelList;


public class GardeMaladeList extends Fragment {

    private ArrayList<MaladeModelList> maladeList = new ArrayList<>();
    private ListView MaladeListView;
    private MaladeAdapter adapter;
    private FloatingActionButton nextBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_garde_malade_list, container, false);
        MaladeListView = v.findViewById(R.id.maladetListViews);

        FloatingActionButton addMalade = v.findViewById(R.id.addmaladeFloatbtn);
        addMalade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ShowDialog();
                openDialog_addMalade();
            }
        });

        nextBtn = v.findViewById(R.id.next1malade);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction().addToBackStack("fragment")
                        .replace(R.id.container, new fragments.MaladeTime()).commit();
            }
        });

        return v;
    }

    public void onAttach(Context context){
        super.onAttach(context);
    }


    public void refreshList() {
        adapter.notifyDataSetChanged();
    }

    private Spinner tranche_age_spinner;
    private FloatingActionButton plus_btn, moins_btn;
    int counter=0;
    String[] tranch_age = {"1-3ans","4-7ans","8-12ans","13-16ans"};
    public void openDialog_addMalade(){


        final Dialog dialog = new Dialog(this.getContext(), android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.malade_dialog);

        final TextView nb_malade = (TextView) dialog.findViewById(R.id.nb_malade);
        plus_btn = dialog.findViewById(R.id.btn_plus_malade);
        moins_btn = dialog.findViewById(R.id.btn_moins_malade);
        tranche_age_spinner = dialog.findViewById(R.id.malade_spinner);
        //tranche_age_spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayAdapter tranche_age_adapter = new ArrayAdapter(this.getContext(), R.layout.simple_spinner_item,tranch_age);
        tranche_age_adapter.setDropDownViewResource(R.layout.spinner_dropdown_design);

        tranche_age_spinner.setAdapter(tranche_age_adapter);
        nb_malade.setText("0");


        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter + 1;
                nb_malade.setText(String.valueOf(counter));
            }
        });

        moins_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter - 1;
                nb_malade.setText(String.valueOf(counter));
            }
        });



        Button dialogButton1 = (Button) dialog.findViewById(R.id.malade_valider);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaladeModelList malade = new MaladeModelList(String.valueOf(nb_malade.getText()),tranche_age_spinner.getSelectedItem().toString());
                maladeList.add(malade);
                adapter = new MaladeAdapter(getContext(),maladeList);
                MaladeListView.setAdapter(adapter);
                Log.d("Added","BABY ADDED!");
                dialog.dismiss();
            }
        });

        Button dialogButton2 = (Button) dialog.findViewById(R.id.malade_annuler);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}