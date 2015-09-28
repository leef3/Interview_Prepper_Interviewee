package studios.redleef.interviewprepperinterviewee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import studios.redleef.interviewprepperinterviewee.DataModels.Question;
import studios.redleef.interviewprepperinterviewee.SingleRun.TutorialActivity;


public class LandingPageActivity extends Activity {

    private SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //First time setup - Check
        boolean isFirstTime = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstTime", true);
        if(isFirstTime)
        {
            //Do This
            setContentView(R.layout.landing_page);

            //Set generic questions
            SetInitialData();

            Intent redirect = new Intent(this, TutorialActivity.class);
            startActivity(redirect);

            //Show viewpager tutorial

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstTime", false)
                    .commit();
        }
        else
        {
            //Not first time, skip and jump to main activity
            Intent redirect = new Intent(this, MainActivity.class);
            startActivity(redirect);
        }
    }

    private void SetInitialData()
    {
        //TEST
        DataSave testData = new DataSave("Test", "TEST_DATA", this);
        ArrayList<Question> testList = new ArrayList<Question>();
        for(int x = 0; x < 20; x++)
        {
            Question testItem = new Question("Question Text #" + x);
            if(x < 5 || x > 13)
            {
                testItem.SetAnswer("Test Answer For This Question Long Long" + x);
            }
            testList.add(testItem);
        }
        testData.SetAndSaveList(testList);
    }
}
