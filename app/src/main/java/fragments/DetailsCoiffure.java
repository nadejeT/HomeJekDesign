package fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;

import com.homejek.ui.ChildAnimationExample;
import com.homejek.ui.ExpandableHeightListView;
import com.homejek.ui.MainActivity;
import com.homejek.ui.R;
import com.homejek.ui.SliderLayout;

import Adapter.CoiffureListViewAdapter;
import Models.CoiffuresList;

public class DetailsCoiffure extends Fragment implements BaseSliderView.OnSliderClickListener{

    SliderLayout mDemoSlider;
    public static String gender = "homme";

    private ExpandableHeightListView listview;
    private ArrayList<CoiffuresList> Bean;
    private CoiffureListViewAdapter baseAdapter;


    private String[] TITLEC = {"Coupe courte", "Coiffure simple","Coupes longues"};
    private String[] PRICEC = {"30 TND", "29 TND","15 TND"};
    private String[] DETAILC = {"Carré, carré plongeant...", "Les pointes, raccourcissement","Dégradé, "};


    private String[] TITLES = {"Pose vernis", "Gel", "Nail Design"};
    private String[] PRICES = {"15 TND", "29 TND", "29 TND"};
    private String[] DETAILS = {"Vernis permanent", "Gel waterproof", "Dessin, perles..."};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_details_coiffure, container, false);

        //        /        ********LISTVIEW   HAIR CUT***********


        listview = (ExpandableHeightListView)v.findViewById(R.id.haircut_list);


        Bean = new ArrayList<CoiffuresList>();

        for (int i= 0; i< TITLEC.length; i++){

            CoiffuresList BeanclassList = new CoiffuresList(TITLEC[i], PRICEC[i], DETAILC[i]);
            Bean.add(BeanclassList);

        }

        baseAdapter = new CoiffureListViewAdapter(DetailsCoiffure.this.getContext(), Bean) {
        };

        listview.setAdapter(baseAdapter);



        //        /        ********LISTVIEW   HAIR STYLING***********


        listview = (ExpandableHeightListView)v.findViewById(R.id.hairstyling_list);


        Bean = new ArrayList<CoiffuresList>();

        for (int i= 0; i< TITLES.length; i++){

            CoiffuresList BeanclassList = new CoiffuresList(TITLES[i], PRICES[i], DETAILS[i]);
            Bean.add(BeanclassList);

        }

        baseAdapter = new CoiffureListViewAdapter(DetailsCoiffure.this.getContext(), Bean) {
        };

        listview.setAdapter(baseAdapter);



        //         ********Slider*********

        mDemoSlider = (SliderLayout)v.findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();

        if(gender.equals("femme")){
            file_maps.put("1", R.drawable.pic1);
            file_maps.put("2",R.drawable.pic);
            file_maps.put("3",R.drawable.pic2);
        }
        else if(gender.equals("homme")){
            file_maps.put("1", R.drawable.pichomme);
            file_maps.put("2",R.drawable.pichomme1);
            file_maps.put("3",R.drawable.pichomme2);
        }


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this.getActivity());
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener((MainActivity) this.getContext());
         return v;

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

}
