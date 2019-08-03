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
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.ProfileAdapter;
import Models.ProfileModel;
import com.homejek.ui.R;

public class Profile extends Fragment {

    private ProfileAdapter profileAdapter;
    private RecyclerView recyclerview;
    private ArrayList<ProfileModel> profileModelArrayList;

    Integer inbox[]={R.drawable.ic_mot_de_passe,R.drawable.ic_mail,R.drawable.ic_telephone,R.drawable.ic_telephone,R.drawable.ic_date_naissance,R.drawable.ic_heart};
    Integer arrow[]={R.drawable.ic_chevron_right_black_24dp,R.drawable.ic_chevron_right_black_24dp,R.drawable.ic_chevron_right_black_24dp,R.drawable.ic_chevron_right_black_24dp,R.drawable.ic_chevron_right_black_24dp,R.drawable.ic_chevron_right_black_24dp};
    String txttrades[]={"Mon Mot de passe","Mon adresse mail","Mon numéro de telephone","Ma date de naissance","Mon Profil","Deconnexion"};
    String txthistory[]={"Modifier mon mot de passe","Modifier mon adresse mail","Modifier mon numéro de telephone","Modifier ma date de naissance","Modifier mon profil complet","Aurevoir HomeJek!"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        recyclerview = v.findViewById(R.id.recycler1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(v.getContext());
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        profileModelArrayList = new ArrayList<>();

        for (int i = 0; i < inbox.length; i++) {
            ProfileModel view = new ProfileModel(inbox[i],arrow[i],txttrades[i],txthistory[i]);
            profileModelArrayList.add(view);
        }
        profileAdapter = new ProfileAdapter(v.getContext(),profileModelArrayList);
        recyclerview.setAdapter(profileAdapter);


        return v;
    }

}
