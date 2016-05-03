package ready.and.late.com.lateandready;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ready.and.late.com.lateandready.helpers.BiddingHelper;
import ready.and.late.com.lateandready.helpers.SearchResult;

public class BiddingActivity extends AppCompatActivity {

    private TextView countdown;
    private CountDownTimer biddingTimer;
    private SearchResult mSearchResult;
    private TextView textViewHighestBid;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding);

        if(getIntent()!=null) {
            mSearchResult = (SearchResult) getIntent().getSerializableExtra("key_search_results");


            final BiddingHelper biddingHelper = new BiddingHelper();

            final TextView bidTitle = (TextView) findViewById(R.id.bidTitle);
            final TextView countdownTextView = (TextView) findViewById(R.id.countdownTextView);
            final TextView textViewHighestBid = (TextView) findViewById(R.id.textViewHighestBid);
            final TextView editTextYourBid = (TextView) findViewById(R.id.editTextYourBid);
            final Button buttonCancelBid = (Button) findViewById(R.id.buttonCancelBid);
            final Button buttonSubmitBid = (Button) findViewById(R.id.buttonSubmitBid);


            bidTitle.setText(mSearchResult.getDepartureAirport() + " -> " + mSearchResult.getDestinationAirport());

            biddingTimer = new CountDownTimer(300000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {

                }
            };
            biddingTimer.start();


            // Button to cancel the bidding process
            Button cancelBid = (Button) findViewById(R.id.buttonCancelBid);
            cancelBid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openResultsActivity();
                }
            });

            Button submitBid = (Button) findViewById(R.id.buttonSubmitBid);
            submitBid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String bidString = String.valueOf(editTextYourBid.getText());
                }
            });

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

