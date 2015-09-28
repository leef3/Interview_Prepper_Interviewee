package studios.redleef.interviewprepperinterviewee.Helpers;

/**
 * Created by Fred Lee on 5/11/2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import studios.redleef.interviewprepperinterviewee.DataModels.Question;
import studios.redleef.interviewprepperinterviewee.R;

public class QuestionListAdapter extends BaseAdapter
{
    Context context;
    protected ArrayList<Question> questionList;
    LayoutInflater inflater;

    //Constructor
    public QuestionListAdapter(Context context, ArrayList<Question> questionList) {
        this.questionList = questionList;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    //Returns count,
    public int getCount() {
        return questionList.size();
    }
    public Question getItem(int position) {
        return questionList.get(position);
    }
    public long getItemId(int position)
    {
        return position;
    }

    //Method to add the information from each Ingredient into a row in the listview.
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.question_list_item, parent, false);

            //Find UI elements for Pay, Name, and Days
            holder.answerText = (TextView) convertView.findViewById(R.id.questionListItemAnswer);
            holder.questionText = (TextView) convertView.findViewById(R.id.questionListItemQuestion);
            holder.answerLayout = (LinearLayout) convertView.findViewById(R.id.questionListAnswerLayout);

            //Used to re-track the ingredient
            holder.questionText.setTag(position);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Get the current Employee Object
        Question questionItem = questionList.get(position);

        holder.questionText.setText(questionItem.GetQuestion());

        if(questionItem.GetAnswered())
        {
            //If true, show answer layout
            holder.answerText.setText(questionItem.GetAnswer());
            holder.answerLayout.setVisibility(View.VISIBLE);
        }
        else
        {
            //Show button to answer the question
            holder.answerLayout.setVisibility(View.GONE);
        }

        //Set the contents of the UI elements


        /*
        holder.itemBought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tempPosition = (Integer) v.getTag();
                Toast.makeText(context, "CheckBox Selected " + tempPosition, Toast.LENGTH_SHORT).show();
                ingredientList.get(tempPosition).toggleChecked();
            }
        });
        */


        return convertView;
    }


    private class ViewHolder {
        TextView questionText;
        TextView answerText;
        LinearLayout answerLayout;
    }

}