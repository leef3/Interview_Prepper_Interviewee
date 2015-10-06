package studios.redleef.interviewprepperinterviewee.Helpers;

/**
 * Created by Fred Lee on 5/11/2015.
 */
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import studios.redleef.interviewprepperinterviewee.DataModels.Question;
import studios.redleef.interviewprepperinterviewee.EditDialogFragment;
import studios.redleef.interviewprepperinterviewee.MainActivity;
import studios.redleef.interviewprepperinterviewee.R;

public class QuestionListAdapter extends BaseAdapter
{
    Context context;
    protected ArrayList<Question> questionList;
    LayoutInflater inflater;
    FragmentManager fragManager;

    //Constructor
    public QuestionListAdapter(Context context, ArrayList<Question> questionList) {
        this.questionList = questionList;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        fragManager = ((MainActivity) context).getSupportFragmentManager();
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
            holder.editButton = (ImageView) convertView.findViewById(R.id.editButton);
            holder.favoriteButton = (ImageView) convertView.findViewById(R.id.favoriteButton);

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

        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int tempPosition = (Integer) v.getTag();
                int tempPosition = 1;
                if(questionList.get(tempPosition).GetAnswered())
                {
                    showDialog(questionList.get(tempPosition).GetQuestion(), questionList.get(tempPosition).GetAnswer());
                }
                else
                {
                    showDialog(questionList.get(tempPosition).GetQuestion());
                }

            }
        });



        return convertView;
    }


    private class ViewHolder {
        TextView questionText;
        TextView answerText;
        ImageView editButton;
        ImageView favoriteButton;
        LinearLayout answerLayout;
    }

    private void showDialog(String question)
    {
        EditDialogFragment newDialog = EditDialogFragment.newInstance(question);
        newDialog.show(fragManager, "edit_question_dialog");
    }

    private void showDialog(String question, String answer)
    {
        EditDialogFragment newDialog = EditDialogFragment.newInstance(question, answer);
        newDialog.show(fragManager, "edit_question_dialog");
    }

}