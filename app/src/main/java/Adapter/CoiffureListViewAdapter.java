package Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.homejek.ui.MainActivity;
import com.homejek.ui.R;

import java.util.ArrayList;

import Models.CoiffuresList;
import fragments.CoiffureDevis;

public class CoiffureListViewAdapter extends BaseAdapter {

    Context context;

    ArrayList<CoiffuresList> bean;
    Typeface fonts1,fonts2;

    Activity main;


    public CoiffureListViewAdapter( Context context, ArrayList<CoiffuresList> bean) {


        this.context = context;
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        fonts1 =  Typeface.createFromAsset(context.getAssets(),
                "fonts/MavenPro-Regular.ttf");

        fonts2 = Typeface.createFromAsset(context.getAssets(),
                "fonts/MavenPro-Regular.ttf");

        final ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row,null);

            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.price = (TextView) convertView.findViewById(R.id.price);
            viewHolder.detail = (TextView) convertView.findViewById(R.id.detail);
            viewHolder.reserver = convertView.findViewById(R.id.reserver);
            viewHolder.title.setTypeface(fonts1);

            viewHolder.reserver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    CoiffureDevis coiffureDevis = new CoiffureDevis();
                    ((MainActivity)context).getSupportFragmentManager()
                            .beginTransaction().addToBackStack("fragment")
                            .replace(R.id.container, new fragments.CoiffureDevis()).commit();
                    Log.e("DEVIS","COIFFURE");

                }
            });

            convertView.setTag(viewHolder);

        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }


        CoiffuresList bean = (CoiffuresList)getItem(position);

        viewHolder.title.setText(bean.getTitle());
        viewHolder.price.setText(bean.getPrice());
        viewHolder.detail.setText(bean.getDetail());

        return convertView;
    }

    private class ViewHolder {
        TextView title;
        TextView price;
        TextView detail;
        customfonts.MyTextView reserver;
    }
}