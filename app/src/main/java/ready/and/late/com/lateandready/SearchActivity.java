package ready.and.late.com.lateandready;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button advancetoBid = (Button) findViewById(R.id.buttonSunAndSand);
        advancetoBid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openBiddingActivity();
            }
        });

    }

    private void openBiddingActivity(){
        Intent intent = new Intent(SearchActivity.this, BiddingActivity.class);
        startActivity(intent);
    }

}
