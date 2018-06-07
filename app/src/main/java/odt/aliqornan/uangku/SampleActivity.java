package odt.aliqornan.uangku;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

import odt.aliqornan.uangku.fragment.CenteredTextFragment;
import odt.aliqornan.uangku.fragment.FragmentReport;
import odt.aliqornan.uangku.menu.DrawerAdapter;
import odt.aliqornan.uangku.menu.DrawerItem;
import odt.aliqornan.uangku.menu.SimpleItem;
import odt.aliqornan.uangku.ui.SettingsActivity;

public class SampleActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {

    private static final int POS_DASHBOARD = 0;
    private static final int POS_ACCOUNT = 1;
    private static final int POS_STATISTIC = 2;
    private static final int POS_SETTINGS = 3;

    private LinearLayout setting_btn;
    private String[] screenTitles;
    private Drawable[] screenBg;
    private Drawable[] screenLg;
    private Drawable[] screenIcons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uangku);

        new SlidingRootNavBuilder(this)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        setting_btn = (LinearLayout) findViewById(R.id.btn_settings);
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
                finish();
            }
        });

        screenIcons = loadScreenIcons();
        screenBg = loadScreenBg();
        screenLg = loadScreenLg();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(POS_ACCOUNT),
                createItemFor(POS_STATISTIC),
                createItemFor(POS_SETTINGS)));
        adapter.setListener(this);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_DASHBOARD);
    }

    // kalau pake onItemSelected cara gini gimana val biar pindah fragment tp dengan support.v4.Fragment nya ?

    @Override
    public void onItemSelected(int position) {
        if (position == POS_DASHBOARD) {
            Fragment selectedScreen = CenteredTextFragment.createFor(screenTitles[position]);
            showFragment(selectedScreen);
        }
        if (position == POS_ACCOUNT) {
            Fragment selectedScreen = CenteredTextFragment.createFor(screenTitles[position]);
            showFragment(selectedScreen);
        }
        if (position == POS_STATISTIC) {
            Fragment selectedScreen = FragmentReport.createFor(screenTitles[position]);
            showFragment(selectedScreen);
        }
    }

    private void showFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position],screenLg[position],screenBg[position],screenTitles[position])
                .withBgTint(View.INVISIBLE)
                .withSelectedBgTint(View.VISIBLE)
                .withLgTint(View.INVISIBLE)
                .withSelectedLgTint(View.VISIBLE)
                .withTextTint(color(R.color.textTint))
                .withSelectedTextTint(color(R.color.colorAccent));
    }

    private Drawable[] loadScreenBg() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenBg);
        Drawable[] bg = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                bg[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return bg;
    }

    private Drawable[] loadScreenLg() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenLg);
        Drawable[] lg = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                lg[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return lg;
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

}
