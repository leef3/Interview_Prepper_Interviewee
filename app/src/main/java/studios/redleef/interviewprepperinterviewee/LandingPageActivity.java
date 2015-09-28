package studios.redleef.interviewprepperinterviewee;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import studios.redleef.interviewprepperinterviewee.DataModels.Question;


public class LandingPageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

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

        Intent redirect = new Intent(this, MainActivity.class);
        startActivity(redirect);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_landing_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
