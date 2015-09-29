package studios.redleef.interviewprepperinterviewee;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.melnykov.fab.FloatingActionButton;

import java.lang.reflect.Type;
import java.util.ArrayList;

import studios.redleef.interviewprepperinterviewee.DataModels.Question;
import studios.redleef.interviewprepperinterviewee.Helpers.QuestionListAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeaknessFragment extends Fragment {

    ArrayList<Question> weaknessList;

    public WeaknessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootLayout = inflater.inflate(R.layout.fragment_weakness, container, false);

        ListView weaknessListView = (ListView)rootLayout.findViewById(R.id.weaknessListView);

        LoadData();

        QuestionListAdapter mAdapter = new QuestionListAdapter(getActivity(), weaknessList);

        weaknessListView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) rootLayout.findViewById(R.id.fabWeakness);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rootLayout;
    }

    public void LoadData()
    {
        weaknessList = new ArrayList<Question>();
        SharedPreferences settings = getActivity().getSharedPreferences("pref", 0);
        String objectData = settings.getString(getString(R.string.WEAKNESS_SAVE_NAME), "");
        if (!objectData.equals("")) {
            System.out.println("Object Data: " + objectData);
            Gson gson = new Gson();
            Type collectionType = new TypeToken<ArrayList<Question>>() {
            }.getType();
            JsonArray jArray = new JsonParser().parse(objectData).getAsJsonArray();
            for (JsonElement e : jArray) {
                Question c = gson.fromJson(e, Question.class);
                weaknessList.add(c);
            }
        }
    }


}
