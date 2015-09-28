package studios.redleef.interviewprepperinterviewee.SingleRun;


import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;


public class TutorialActivity extends com.blunderer.materialdesignlibrary.activities.ViewPagerActivity {

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(this)
                .addPage("Tutorial",
                        new TutorialFragmentOne())
                .addPage("Tutorial",
                        new TutorialFragmentTwo())
                .addPage("Tutorial",
                        new TutorialFragmentThree());
    }


    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }

    @Override
    public boolean showViewPagerIndicator() {
        return true;
    }

    @Override
    public boolean replaceActionBarTitleByViewPagerPageTitle() {
        return true;
    }

    @Override
    protected boolean enableActionBarShadow() {
        return false;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return null;
    }

}