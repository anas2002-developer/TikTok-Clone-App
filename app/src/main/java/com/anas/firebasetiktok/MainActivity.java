package com.anas.firebasetiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    Adapter_Video adapter_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager2 = findViewById(R.id.viewPager2);

        FirebaseRecyclerOptions<Model_Video> options =
                new FirebaseRecyclerOptions.Builder<Model_Video>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Videos"), Model_Video.class)
                        .build();


        adapter_video = new Adapter_Video(options);
        viewPager2.setAdapter(adapter_video);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter_video.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter_video.stopListening();
    }
}