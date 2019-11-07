package fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.ListView;

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

    public int[] IMAGE = {R.drawable.bannercoiffure1, R.drawable.bannercourse1, R.drawable.bannerreparateur1, R.drawable.bannerchauffeur1, R.drawable.bannernettoyage1, R.drawable.bannerbabysitting1, R.drawable.bannergardemalade1};
    public String[] TITLE = {"Coiffure", "Courses", "Réparateur",
            "Chauffeur", "Nettoyage", "Babysitting","Garde Malade"};
    public String[] DESCRIPTION = {"Besoin d'une \n nouvelle coupe?", "Laissez nous faire vos \n courses à votre place", "Ne vous soucier plus \n de vos objets cassés", "On vous conduit ou \n vous voulez", "En un clic c'est propre", "Un enfant à garder? \n C'est pour nous!","Un malade à garder? \n On s'en charge!"};
    public String[] STATE = {"En cours", "Pas disponible", "Disponible", "En cours", "Disponible", "Disponible","Disponible"};
    public int[] STATEICON = {R.drawable.ic_en_cours, R.drawable.ic_not_available, R.drawable.ic_available, R.drawable.ic_en_cours, R.drawable.ic_available, R.drawable.ic_available, R.drawable.ic_available};

    private ArrayList<HomeListView> HomeListViewArrayList;
    private HomeListViewAdapter listViewAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);



        listview = (ListView) v.findViewById(R.id.listview);
        HomeListViewArrayList = new ArrayList<HomeListView>();


        for (int i = 0; i < TITLE.length; i++) {

            HomeListView HomeCell = new HomeListView(IMAGE[i], TITLE[i], DESCRIPTION[i],STATE[i],STATEICON[i]);
            HomeListViewArrayList.add(HomeCell);

        }
        listViewAdapter = new HomeListViewAdapter(v.getContext(), HomeListViewArrayList);
        listview.setAdapter(listViewAdapter);

        return v;
    }



}
