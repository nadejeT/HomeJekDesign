package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import com.homejek.ui.R;

import Adapter.HomeListViewAdapter;
import Models.HomeListView;


public class Home extends Fragment {

    private ListView listview;

    int number = 1;


    private int image;
    private String title;
    private String description;
    private String price;
    private Button myButton;

    public int[] IMAGE = {R.drawable.coif, R.drawable.course, R.drawable.reparateur, R.drawable.chauf, R.drawable.nettoyage, R.drawable.shop};
    public String[] TITLE = {"Coiffeur", "Courses", "Réparateur",
            "Chauffeur", "Nettoyage", "Babysitter"};
    public String[] DESCRIPTION = {"", "", "", "", "", ""};


    private ArrayList<HomeListView> beanClassArrayList;
    private HomeListViewAdapter listViewAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);



        listview = (ListView) v.findViewById(R.id.listview);
        beanClassArrayList = new ArrayList<HomeListView>();


        for (int i = 0; i < TITLE.length; i++) {

            HomeListView beanClass = new HomeListView(IMAGE[i], TITLE[i], DESCRIPTION[i]);
            beanClassArrayList.add(beanClass);

        }
        listViewAdapter = new HomeListViewAdapter(v.getContext(), beanClassArrayList);
        listview.setAdapter(listViewAdapter);

        return v;
    }

}
