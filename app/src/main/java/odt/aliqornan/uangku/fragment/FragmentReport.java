package odt.aliqornan.uangku.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import odt.aliqornan.uangku.R;

/**
 * Created by Admin on 7/15/2017.
 */

public class FragmentReport extends Fragment {

    private ImageView draw;
    private CardView cv_a, cv_b;

    public static FragmentReport createFor(String text) {
        FragmentReport fragment = new FragmentReport();
        return fragment;
    }

    public FragmentReport() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_report, container, false);

        draw = (ImageView)v.findViewById(R.id.draw);
        cv_a = (CardView)v.findViewById(R.id.cv_static);
        cv_b = (CardView)v.findViewById(R.id.cv_categories);

        Animate();

        return v;
    }

    private void Animate() {

        Animation popeup1 = AnimationUtils.loadAnimation(getActivity(), R.anim.popeup);
        Animation popeup2 = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_up);
        Animation popeup3 = AnimationUtils.loadAnimation(getActivity(), R.anim.showin);
        Animation popeup4 = AnimationUtils.loadAnimation(getActivity(), R.anim.showin);

        popeup1.setStartOffset(300);
        popeup2.setStartOffset(350);
        popeup3.setStartOffset(250);
        popeup4.setStartOffset(350);

        draw.startAnimation(popeup1);
        cv_a.startAnimation(popeup3);
        cv_b.startAnimation(popeup4);

    }
}
