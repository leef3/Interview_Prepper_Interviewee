package studios.redleef.interviewprepperinterviewee;

import android.content.Intent;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsMenuHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerBottomHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerTopHandler;
import com.blunderer.materialdesignlibrary.models.Account;

public class MainActivity extends com.blunderer.materialdesignlibrary.activities.NavigationDrawerActivity {

    @Override
    public NavigationDrawerAccountsHandler getNavigationDrawerAccountsHandler() {
        return null;
    }

    @Override
    public NavigationDrawerAccountsMenuHandler getNavigationDrawerAccountsMenuHandler() {
        return null;
    }

    @Override
    public void onNavigationDrawerAccountChange(Account account) {
    }

    @Override
    public NavigationDrawerTopHandler getNavigationDrawerTopHandler() {
        return new NavigationDrawerTopHandler(this)
                .addSection(R.string.fragment)
                .addItem(R.string.fragment_listview, new ListViewFragment())
                .addItem(R.string.fragment_scrollview, new ScrollViewFragment())
                .addItem(R.string.fragment_viewpager, new ViewPagerFragment())
                .addItem(R.string.fragment_viewpager_with_tabs, new ViewPagerWithTabsFragment())

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