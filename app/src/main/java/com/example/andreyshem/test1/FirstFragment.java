package com.example.andreyshem.test1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.andreyshem.test1.adapters.CustomListAdapter;

import static com.example.andreyshem.test1.adapters.MyFragmentAdapter.imgID;
import static com.example.andreyshem.test1.adapters.MyFragmentAdapter.items;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private ViewPager fVPager;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Toolbar profile_toolbar = (Toolbar)view.findViewById(R.id.my_toolbar);
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        activity.setSupportActionBar(profile_toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        if(actionBar!= null) {
            actionBar.setTitle("First");
            actionBar.setIcon(R.drawable.ic_menu_slideshow);
        }

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), items, imgID);
        ListView list=(ListView)view.findViewById(R.id.my_listview);
        list.setAdapter(adapter);
        registerForContextMenu(list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPopupMenu(view);
            }
        });

        return view;
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popupmenu_f, popupMenu.getMenu());
        popupMenu.show();

        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu2:
                                fVPager = (ViewPager) getActivity().findViewById(R.id.mVPager);
                                fVPager.setCurrentItem(1);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }

}
