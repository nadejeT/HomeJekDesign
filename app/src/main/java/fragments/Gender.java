package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.homejek.ui.MainActivity;
import com.homejek.ui.R;


public class Gender extends Fragment {

    TextView title;
    ImageView iconfemme, iconhomme;
    customfonts.MyTextView_SF_Pro_Display_Medium gender_suivant;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gender, container, false);

        title = v.findViewById(R.id.titlegender);
        title.setText("Salut, " + "Nadeje" + "\n \n Sélectionnez votre sexe" );
        iconfemme = v.findViewById(R.id.iconfemme);
        iconhomme = v.findViewById(R.id.iconhomme);
        gender_suivant = v.findViewById(R.id.gender_suivant);



        iconfemme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setActivated(!v.isActivated());

               if(iconfemme.isActivated()){
                   iconfemme.setBackgroundResource(R.drawable.iconfemmecircleselected2);
                   iconhomme.setBackgroundResource(R.drawable.iconhommecircle);
                   iconhomme.setActivated(false);
                   DetailsCoiffure.gender = "femme";
               }
               if(iconfemme.isActivated() == false){
                   iconfemme.setBackgroundResource(R.drawable.iconfemmecircle);
                   iconhomme.setBackgroundResource(R.drawable.iconhommecircleselected2);
                   iconhomme.setActivated(true);
                   DetailsCoiffure.gender = "homme";
               }
            }
        });

        iconhomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setActivated(!v.isActivated());

                if(iconhomme.isActivated()){
                    iconhomme.setBackgroundResource(R.drawable.iconhommecircleselected2);
                    iconfemme.setBackgroundResource(R.drawable.iconfemmecircle);
                    iconfemme.setActivated(false);
                    DetailsCoiffure.gender = "homme";
                }
                if(iconhomme.isActivated() == false){
                    iconhomme.setBackgroundResource(R.drawable.iconhommecircle);
                    iconfemme.setBackgroundResource(R.drawable.iconfemmecircleselected2);
                    iconfemme.setActivated(true);
                    DetailsCoiffure.gender = "femme";
                }

            }
        });

        gender_suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction().addToBackStack("fragment")
                        .replace(R.id.container, new fragments.DetailsCoiffure()).commit();
            }
        });
        return v;
    }

}
