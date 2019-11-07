package Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import fragments.Appartement;
import fragments.Bureau;
import fragments.Villa;

public class Tab_adapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public Tab_adapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Appartement tab1 = new Appartement();
                return tab1;
            case 1:
                Villa tab2 = new Villa();
                return tab2;
            case 2:
                Bureau tab3 = new Bureau();
                return tab3;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
