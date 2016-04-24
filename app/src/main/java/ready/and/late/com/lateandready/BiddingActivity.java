package ready.and.late.com.lateandready;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import ready.and.late.com.lateandready.helpers.SearchResult;

public class BiddingActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding);

        // Button to cancel the bidding process
        Button cancelBid = (Button) findViewById(R.id.buttonCancelBid);
        cancelBid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultsActivity();
            }
        });

        Button submitBid = (Button) findViewById(R.id.buttonSubmitBid);
        submitBid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCongratsActivity();
            }
        });

        if(getIntent()!=null){
            SearchResult searchResult = (SearchResult) getIntent().getSerializableExtra("key_search_results");
        }

    }
    private void openResultsActivity(){
        Intent intent = new Intent(BiddingActivity.this, ResultsActivity.class);
        startActivity(intent);
    }

    private void openCongratsActivity() {
        Intent intent = new Intent(BiddingActivity.this, CongratsActivity.class);
        startActivity(intent);
    }



}

