package com.swing.app.hearme;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.swing.app.hearme.tabs.TabLetras;
import com.swing.app.hearme.tabs.TabNum;
import com.swing.app.hearme.tabs.TabPronombres;
import com.swing.app.hearme.tabs.TabSustantivo;
import com.swing.app.hearme.tabs.TabVerbos;
import com.swing.app.hearme.utils.SectionPageAdapter;

public class MediumActivity extends AppCompatActivity {

    private SectionPageAdapter _sectionPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);

        ViewPager _viewPager = (ViewPager) findViewById(R.id.containerMedium);
        setupPageAdapter(_viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsMedium);
        tabLayout.setupWithViewPager(_viewPager);
    }

    private void setupPageAdapter(ViewPager viewPager) {
        _sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        _sectionPageAdapter.addFragment(new TabVerbos(), "Verbos");
        _sectionPageAdapter.addFragment(new TabPronombres(), "Pronombres");
        _sectionPageAdapter.addFragment(new TabSustantivo(), "Sustantivos");
        viewPager.setAdapter(_sectionPageAdapter);
    }
}
