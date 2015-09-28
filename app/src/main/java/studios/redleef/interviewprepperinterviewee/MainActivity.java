package studios.redleef.interviewprepperinterviewee;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsMenuHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerBottomHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerStyleHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerTopHandler;
import com.blunderer.materialdesignlibrary.models.Account;

public class MainActivity extends com.blunderer.materialdesignlibrary.activities.NavigationDrawerActivity {

    @Override
    public NavigationDrawerStyleHandler getNavigationDrawerStyleHandler() {
        return null;
    }

    @Override
    public NavigationDrawerAccountsHandler getNavigationDrawerAccountsHandler() {
        return null;
    }

    @Override
    public NavigationDrawerAccountsMenuHandler getNavigationDrawerAccountsMenuHandler() {
        return null;
    }

    @Override
    protected boolean enableActionBarShadow() {
        return true;
    }

    @Override
    public void onNavigationDrawerAccountChange(Account account) {
    }

    @Override
    public NavigationDrawerTopHandler getNavigationDrawerTopHandler() {

        QABundleFragment startQuestion = new QABundleFragment();


        QABundleFragment startAnswer = new QABundleFragment();


        SWBundleFragment startStrength = new SWBundleFragment();


        SWBundleFragment startWeakness = new SWBundleFragment();


        return new NavigationDrawerTopHandler(this)
                .addSection("User Specific")
                .addItem(R.string.fragment_experience, R.drawable.ic_experience, new ExperienceFragment())
                .addItem(R.string.fragment_scheduled, R.drawable.ic_scheduled, new ScheduledFragment())
                .addItem(R.string.fragment_favorite, R.drawable.ic_favorite, new FavoriteFragment())
                .addSection("Job Generic")
                .addItem(R.string.fragment_question, R.drawable.ic_question, startQuestion)
                .addItem(R.string.fragment_answered, R.drawable.ic_answered, startAnswer)
                .addItem(R.string.fragment_strength, R.drawable.ic_strength, startStrength)
                .addItem(R.string.fragment_weakness, R.drawable.ic_weakness, startWeakness);

    }

    @Override
    public NavigationDrawerBottomHandler getNavigationDrawerBottomHandler() {
        return new NavigationDrawerBottomHandler(this)
                .addSettings(null)
                .addHelpAndFeedback(null);
    }

    @Override
    public boolean overlayActionBar() {
        return false;
    }

    @Override
    public boolean replaceActionBarTitleByNavigationDrawerItemTitle() {
        return true;
    }

    @Override
    public int defaultNavigationDrawerItemSelectedPosition() {
        return 1;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

}