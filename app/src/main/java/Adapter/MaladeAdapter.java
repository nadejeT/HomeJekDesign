package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.homejek.ui.R;

import java.util.ArrayList;

import Models.MaladeModelList;

public class MaladeAdapter extends ArrayAdapter<MaladeModelList> {

    public MaladeAdapter(Context context, ArrayList<MaladeModelList> malades){
        super(context,0,malades);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        MaladeModelList malade = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_maladelist, parent, false);
        }

        TextView txtnbenfant = convertView.findViewById(R.id.txt_nbmalade);
        TextView txttrancheage = convertView.findViewById(R.id.txt_trancheage);

        txtnbenfant.setText(malade.getNb_malade());
        txttrancheage.setText(malade.getTranche_age());

        return convertView;
    }

}
