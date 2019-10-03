package Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.homejek.ui.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Models.BabyModelList;

public class BabyAdapter extends ArrayAdapter<BabyModelList> {

    public BabyAdapter(Context context, ArrayList<BabyModelList> Babies){
        super(context,0,Babies);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        BabyModelList baby = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_babylist, parent, false);
        }

        TextView txtnbenfant = convertView.findViewById(R.id.txt_nbenfant);
        TextView txttrancheage = convertView.findViewById(R.id.txt_trancheage);

        txtnbenfant.setText(baby.getNb_enfant());
        txttrancheage.setText(baby.getTranche_age());

        return convertView;
    }


}
