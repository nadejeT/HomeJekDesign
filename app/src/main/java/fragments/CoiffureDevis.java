package fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.circulardialog.CDialog;
import com.example.circulardialog.extras.CDConstants;
import com.homejek.ui.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;


public class CoiffureDevis extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_coiffure_devis, container, false);
        final customfonts.MyTextView_SF_Pro_Display_Medium confirm_devis = v.findViewById(R.id.confirm_devis);

        final pl.droidsonroids.gif.GifImageView devis_gif = v.findViewById(R.id.devis_gif);
        final int TIME_OUT = 4000;


        confirm_devis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.e("Confirm","devis");
                    confirm_devis.setVisibility(View.INVISIBLE);
                    devis_gif.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        devis_gif.setVisibility(View.INVISIBLE);

                        new CDialog(getContext()).createAlert("Succès",
                                CDConstants.SUCCESS,   // Type of dialog
                                CDConstants.LARGE)    //  size of dialog
                                .setAnimation(CDConstants.SCALE_FROM_BOTTOM_TO_BOTTOM)     //  Animation for enter/exit
                                .setDuration(4000)   // in milliseconds
                                .setTextSize(CDConstants.LARGE_TEXT_SIZE)  // CDConstants.LARGE_TEXT_SIZE, CDConstants.NORMAL_TEXT_SIZE
                                .setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimary))
                                .show();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("fragment").replace(R.id.container, new fragments.Home()).commit();

                            }
                        }, 1000);

                    }
                }, TIME_OUT);


            }
        });












        return v;
    }


}
