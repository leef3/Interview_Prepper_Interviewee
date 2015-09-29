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

import java.lang.reflect.Type;
import java.util.ArrayList;

import studios.redleef.interviewprepperinterviewee.DataModels.Question;
import studios.redleef.interviewprepperinterviewee.Helpers.QuestionListAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnsweredFragment extends Fragment {

    ArrayList<Question> answerList;

    public AnsweredFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootLayout = inflater.inflate(R.layout.fragment_answered, container, false);

        ListView answerListView = (ListView)rootLayout.findViewById(R.id.answerListView);

        LoadData();

        QuestionListAdapter mAdapter = new QuestionListAdapter(getActivity(), answerList);

        answerListView.setAdapter(mAdapter);

        return rootLayout;
    }

    public void LoadData()
    {
        answerList = new ArrayList<Question>();
        SharedPreferences settings = getActivity().getSharedPreferences("pref", 0);
        String objectData = settings.getString(getString(R.string.QUESTION_SAVE_NAME), "");
        if (!objectData.equals("")) {
            System.out.println("Object Data: " + objectData);
            Gson gson = new Gson();
            Type collectionType = new TypeToken<ArrayList<Question>>() {
            }.getType();
            JsonArray jArray = new JsonParser().parse(objectData).getAsJsonArray();
            for (JsonElement e : jArray) {
                Question c = gson.fromJson(e, Question.class);
                if(c.GetAnswered())
                {
                    answerList.add(c);
                }
            }
        }
    }


}
