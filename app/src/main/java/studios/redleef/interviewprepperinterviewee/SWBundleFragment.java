package studios.redleef.interviewprepperinterviewee;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;


/**
 * A simple {@link Fragment} subclass.
 */
public class SWBundleFragment extends com.blunderer.materialdesignlibrary.fragments.ViewPagerWithTabsFragment {

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(getActivity())
                .addPage(R.string.fragment_strength,
                        new StrengthFragment())
                .addPage(R.string.fragment_weakness,
                        new WeaknessFragment());
    }

    @Override
    public boolean expandTabs() {
        return true;
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }

}