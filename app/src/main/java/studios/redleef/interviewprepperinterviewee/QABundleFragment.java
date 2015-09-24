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
public class QABundleFragment extends com.blunderer.materialdesignlibrary.fragments.ViewPagerWithTabsFragment {

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(getActivity())
                .addPage(R.string.fragment_question,
                        new QuestionFragment())
                .addPage(R.string.fragment_answered,
                        new AnsweredFragment());
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }

    public void setPage(int toSet)
    {
        this.selectPage(toSet);
    }

    @Override
    public boolean expandTabs() {
        return true;
    }
}