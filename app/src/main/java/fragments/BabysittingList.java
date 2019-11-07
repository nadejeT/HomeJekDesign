package fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
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
import Dialog.BabyDialog;
import Models.BabyModelList;


public class BabysittingList extends Fragment implements BabyDialog.AddBabyDialogListener {

    private ArrayList<BabyModelList> babyList = new ArrayList<>();
    private ListView BabysittingListView;
    private BabyAdapter adapter;
    private FloatingActionButton nextBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_babysitting_list, container, false);
        BabysittingListView = v.findViewById(R.id.babytListViews);

        FloatingActionButton addBaby = v.findViewById(R.id.addBabyFloatbtn);
        addBaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ShowDialog();
                openDialog_addBaby();
            }
        });

        nextBtn = v.findViewById(R.id.next1baby);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction().addToBackStack("fragment")
                        .replace(R.id.container, new fragments.BabyTime()).commit();
            }
        });

        return v;
    }

    public void ShowDialog(){
        BabyDialog dialog = new BabyDialog();
        dialog.show(getFragmentManager(), "Adding Dialog");
    }
    public void onAttach(Context context){
        super.onAttach(context);
    }
    @Override
    public void refreshList() {
        adapter.notifyDataSetChanged();
    }

    private Spinner tranche_age_spinner;
    private FloatingActionButton plus_btn, moins_btn;
    int counter=0;
    String[] tranch_age = {"1-3ans","4-7ans","8-12ans","13-16ans"};
    public void openDialog_addBaby(){


        final Dialog dialog = new Dialog(this.getContext(), android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.babydialog);

        final TextView nb_enfants = (TextView) dialog.findViewById(R.id.nb_enfant);
        plus_btn = dialog.findViewById(R.id.btn_plus);
        moins_btn = dialog.findViewById(R.id.btn_moins);
        tranche_age_spinner = dialog.findViewById(R.id.baby_spinner);
        //tranche_age_spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayAdapter tranche_age_adapter = new ArrayAdapter(this.getContext(), R.layout.simple_spinner_item,tranch_age);
        tranche_age_adapter.setDropDownViewResource(R.layout.spinner_dropdown_design);

        tranche_age_spinner.setAdapter(tranche_age_adapter);
        nb_enfants.setText("0");


        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter + 1;
                nb_enfants.setText(String.valueOf(counter));
            }
        });

        moins_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter - 1;
                nb_enfants.setText(String.valueOf(counter));
            }
        });



        Button dialogButton1 = (Button) dialog.findViewById(R.id.baby_valider);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BabyModelList baby = new BabyModelList(String.valueOf(nb_enfants.getText()),tranche_age_spinner.getSelectedItem().toString());
                babyList.add(baby);
                adapter = new BabyAdapter(getContext(),babyList);
                BabysittingListView.setAdapter(adapter);
                Log.d("Added","BABY ADDED!");
                dialog.dismiss();
            }
        });

        Button dialogButton2 = (Button) dialog.findViewById(R.id.baby_annuler);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}
