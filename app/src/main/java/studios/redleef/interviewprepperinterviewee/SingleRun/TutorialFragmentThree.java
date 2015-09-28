package studios.redleef.interviewprepperinterviewee.SingleRun;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import studios.redleef.interviewprepperinterviewee.MainActivity;
import studios.redleef.interviewprepperinterviewee.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorialFragmentThree extends Fragment {


    public TutorialFragmentThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tutorial_three, container, false);

        Button getStarted = (Button)rootView.findViewById(R.id.gettingStartedButton);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent redirect = new Intent(getActivity(), MainActivity.class);
                startActivity(redirect);
            }
        });

        return rootView;
    }


}
