package studios.redleef.interviewprepperinterviewee.SingleRun;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import studios.redleef.interviewprepperinterviewee.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorialFragmentOne extends Fragment {


    public TutorialFragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tutorial_one, container, false);
    }


}
