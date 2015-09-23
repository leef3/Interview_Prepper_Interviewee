package studios.redleef.interviewprepperinterviewee;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;


public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private MainActivity mContext;
    private ResideMenuItem itemScheduled;
    private ResideMenuItem itemAnswered;
    private ResideMenuItem itemExperience;
    private ResideMenuItem itemFavorite;
    private ResideMenuItem itemQuestion;
    private ResideMenuItem itemStrength;
    private ResideMenuItem itemWeakness;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mContext = this;
        setUpMenu();
        if( savedInstanceState == null )
            changeFragment(new ExperienceFragment());
    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.6f);

        // create menu items;
        itemAnswered    = new ResideMenuItem(this, R.drawable.ic_answered,   "Answered");
        itemExperience    = new ResideMenuItem(this, R.drawable.ic_experience,   "Experience");
        itemFavorite    = new ResideMenuItem(this, R.drawable.ic_favorite,   "Favorites");
        itemQuestion    = new ResideMenuItem(this, R.drawable.ic_question,   "Questions");
        itemScheduled    = new ResideMenuItem(this, R.drawable.ic_scheduled,   "Scheduled");
        itemStrength    = new ResideMenuItem(this, R.drawable.ic_strength,   "Strengths");
        itemWeakness    = new ResideMenuItem(this, R.drawable.ic_weakness,   "Weaknesses");

        itemAnswered.setOnClickListener(this);
        itemExperience.setOnClickListener(this);
        itemFavorite.setOnClickListener(this);
        itemQuestion.setOnClickListener(this);
        itemScheduled.setOnClickListener(this);
        itemStrength.setOnClickListener(this);
        itemWeakness.setOnClickListener(this);

        resideMenu.addMenuItem(itemAnswered, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemExperience, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemFavorite, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemQuestion, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemScheduled, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemStrength, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemWeakness, ResideMenu.DIRECTION_LEFT);


        // You can disable a direction by setting ->
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
    }

    //TODO:Could mess with ViewPager keep a lookout
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {

        if (view == itemAnswered){
            changeFragment(new AnsweredFragment());
        }else if (view == itemExperience){
            changeFragment(new ExperienceFragment());
        }else if (view == itemFavorite){
            changeFragment(new FavoriteFragment());
        }else if (view == itemQuestion){
            changeFragment(new QuestionFragment());
        }else if (view == itemScheduled){
            changeFragment(new ScheduledFragment());
        }else if (view == itemStrength){
            changeFragment(new StrengthFragment());
        }else if (view == itemWeakness){
            changeFragment(new WeaknessFragment());
        }

        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    // What good method is to access resideMenu?
    public ResideMenu getResideMenu(){
        return resideMenu;
    }
}