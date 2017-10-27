package com.swing.app.hearme;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import com.swing.app.hearme.tabs.TabPhrases;
import com.swing.app.hearme.tabs.TabTranslate;
import com.swing.app.hearme.utils.SectionPageAdapter;

public class MainActivity extends AppCompatActivity {
    private SectionPageAdapter _sectionPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager _viewPager = (ViewPager) findViewById(R.id.containerMain);
        setupPageAdapter(_viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(_viewPager);

    }

    private void setupPageAdapter(ViewPager viewPager) {
        _sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        _sectionPageAdapter.addFragment(new TabTranslate(), "Traductor");
        _sectionPageAdapter.addFragment(new TabPhrases(), "Frases Comunes");
        viewPager.setAdapter(_sectionPageAdapter);
    }
}
