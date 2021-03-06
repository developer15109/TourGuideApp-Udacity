package com.example.jagat.tourguide.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jagat.tourguide.R;
import com.example.jagat.tourguide.customAdapter.ParkAdapter;
import com.example.jagat.tourguide.model.Parks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLaayoutManager;
    private ArrayList<Parks> mParkList;
    private ParkAdapter mAdapter;

    private static final HashMap<Integer,int[]> days=new HashMap<Integer, int[]>(){{
        put(0,new int[]{9,10});
        put(1,new int[]{9,10});
        put(2,new int[]{9,10});
        put(3,new int[]{9,10});
        put(4,new int[]{9,10});
        put(5,new int[]{9,10});
        put(6,new int[]{9,10}); }
    };

    private static final String[] names=new String[]{
            "Children's Park",
            "National Zoological Park",
            "Water Parks",
            "Amusement Park"
    };
    private static final int[] rating=new int[]{
            2,3,4,5
    };
    private static final String[] address=new String[]{
            "New Delhi",
            "New Delhi",
            "New Delhi",
            "New Delhi"
    };
    private static final int[] thumbnails=new int[]{
            R.drawable.childern_park,
            R.drawable.national_zoological_park,
            R.drawable.water_park,
            R.drawable.amusement_park
    };
    private static final int[] type=new int[]{
            1,1,1,1
    };
    private static final String[] des=new String[]{
            "Description",
            "Description",
            "Description",
            "Description"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mRecyclerView=findViewById(R.id.recycler_view);
        mParkList=new ArrayList<>();

        mAdapter=new ParkAdapter(getApplicationContext(),mParkList);
        mLaayoutManager=new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLaayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        prepareData();
    }

    private void prepareData(){
        for(int i=0;i<names.length;i++)
        {
            Parks object= new Parks(names[i],des[i],address[i],type[i],thumbnails[i],rating[i],days);
            mParkList.add(object);
        }
        mAdapter.notifyDataSetChanged();
    }
}
