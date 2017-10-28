package com.swing.app.hearme;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.swing.app.hearme.tabs.TabAcademy;
import com.swing.app.hearme.tabs.TabLetras;
import com.swing.app.hearme.tabs.TabNum;
import com.swing.app.hearme.tabs.TabPhrases;
import com.swing.app.hearme.tabs.TabTranslate;
import com.swing.app.hearme.utils.SectionPageAdapter;


public class BasicActivity extends AppCompatActivity {

    private SectionPageAdapter _sectionPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        ViewPager _viewPager = (ViewPager) findViewById(R.id.containerBasic);
        setupPageAdapter(_viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsBasic);
        tabLayout.setupWithViewPager(_viewPager);
    }

    private void setupPageAdapter(ViewPager viewPager) {
        _sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        _sectionPageAdapter.addFragment(new TabLetras(), "Letras");
        _sectionPageAdapter.addFragment(new TabNum(), "Números");
        viewPager.setAdapter(_sectionPageAdapter);
    }

}
