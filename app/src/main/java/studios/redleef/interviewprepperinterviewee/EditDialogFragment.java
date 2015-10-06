package studios.redleef.interviewprepperinterviewee;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class EditDialogFragment extends DialogFragment {

    private static final String ARG_QUESTION = "question";
    private static final String ARG_ANSWER = "answer";

    Context context;

    // TODO: Rename and change types of parameters
    private String question;
    private String answer;

    // TODO: Rename and change types and number of parameters
    public static EditDialogFragment newInstance(String question) {
        EditDialogFragment fragment = new EditDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, question);
        fragment.setArguments(args);
        return fragment;
    }

    public static EditDialogFragment newInstance(String question,String answer) {
        EditDialogFragment fragment = new EditDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, question);
        args.putString(ARG_ANSWER, answer);
        fragment.setArguments(args);
        return fragment;
    }

    public EditDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = getArguments().getString(ARG_QUESTION);

            if(!getArguments().getString(ARG_ANSWER).equals(null))
            {
                answer = getArguments().getString(ARG_ANSWER);
            }

            context = getActivity();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {

        LayoutInflater li = LayoutInflater.from(context);
        final View promptsView = li.inflate(R.layout.question_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(promptsView);

        final TextView questionText = (TextView) promptsView.findViewById(R.id.questionDialogQuestion);
        questionText.setText(question);

        if(!answer.equals(null))
        {
            final TextView answerText = (TextView) promptsView.findViewById(R.id.questionDialogAnswer);
            answerText.setText(answer);
        }

        // Set up the buttons
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //Cancel if user selects cancel
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        //Show the dialog
        return builder.show();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

}