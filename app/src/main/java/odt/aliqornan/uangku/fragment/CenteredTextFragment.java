package odt.aliqornan.uangku.fragment;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import odt.aliqornan.uangku.R;
import odt.aliqornan.uangku.ui.TransactionActivity;

public class CenteredTextFragment extends Fragment {
    private ImageView draw;
    private TextView current;
    private FloatingActionButton fab;
    private LinearLayout llin,llex,llstat,llvalue;

    public static CenteredTextFragment createFor(String text) {
        CenteredTextFragment fragment = new CenteredTextFragment();
        return fragment;
    }

    public CenteredTextFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_dashboard, container, false);

        draw = (ImageView)v.findViewById(R.id.draw);
        current = (TextView) v.findViewById(R.id.txt_current);
        fab = (FloatingActionButton)v.findViewById(R.id.fab);
        llin = (LinearLayout)v.findViewById(R.id.ll_income);
        llex = (LinearLayout)v.findViewById(R.id.ll_expense);
        llstat = (LinearLayout)v.findViewById(R.id.ll_current_stat);
        llvalue = (LinearLayout)v.findViewById(R.id.txt_value);

        Animate();
        /*
        HorizontalPicker picker= (HorizontalPicker)v.findViewById(R.id.datePicker);
        picker
                .setListener((DatePickerListener) this)
                .setDays(120)
                .setOffset(7)
                .init();
        picker.setDate(new DateTime());

        revealFAB = (RevealFAB) v.findViewById(R.id.reveal_fab);
        revealFAB.setIntent(new Intent(getActivity(),TransactionActivity.class));

        revealFAB.setOnClickListener(new RevealFAB.OnClickListener() {
            @Override
            public void onClick(RevealFAB button, View v) {
                button.startActivityWithAnimation();
            }
        });

        */

        FloatingActionButton floatingActionButton = (FloatingActionButton)v.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondActivity();
            }
        });

        return v;
    }

    private void Animate() {

        Animation popeup1 = AnimationUtils.loadAnimation(getActivity(), R.anim.popeup);
        Animation popeup2 = AnimationUtils.loadAnimation(getActivity(), R.anim.popeup);
        Animation popeup3 = AnimationUtils.loadAnimation(getActivity(), R.anim.showin);
        Animation popeup4 = AnimationUtils.loadAnimation(getActivity(), R.anim.showin);
        Animation popeup5 = AnimationUtils.loadAnimation(getActivity(),R.anim.show_text);
        Animation popeup6 = AnimationUtils.loadAnimation(getActivity(),R.anim.show_text);
        Animation popeup7 = AnimationUtils.loadAnimation(getActivity(),R.anim.show_text);


        popeup1.setStartOffset(300);
        popeup2.setStartOffset(350);
        popeup3.setStartOffset(500);
        popeup4.setStartOffset(600);
        popeup5.setStartOffset(200);
        popeup6.setStartOffset(300);
        popeup7.setStartOffset(400);

        draw.startAnimation(popeup1);
        fab.startAnimation(popeup2);
        llin.startAnimation(popeup3);
        llex.startAnimation(popeup4);
        current.startAnimation(popeup5);
        llstat.startAnimation(popeup6);
        llvalue.startAnimation(popeup7);
    }

    private void launchSecondActivity() {
        Intent intent = new Intent(getActivity(),TransactionActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
