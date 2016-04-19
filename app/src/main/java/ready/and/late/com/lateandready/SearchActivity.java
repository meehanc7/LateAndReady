package ready.and.late.com.lateandready;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import ready.and.late.com.lateandready.helpers.SearchDestinationHelper;
import ready.and.late.com.lateandready.helpers.SearchDestinationResultsInterface;

public class SearchActivity extends AppCompatActivity {


    private AutoCompleteTextView departureEditText;
    private AutoCompleteTextView destinationEditText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        departureEditText = (AutoCompleteTextView)findViewById(R.id.departureEditText);
        destinationEditText = (AutoCompleteTextView) findViewById(R.id.destinationEditText);

        SearchDestinationHelper searchDestinationHelper = new SearchDestinationHelper();
        searchDestinationHelper.getAirports(new SearchDestinationResultsInterface() {
            @Override
            public void searchSuccessful(List<String> airportList) {
                setUpAdapter(airportList);
            }

            @Override
            public void searchFailed(String errorMessageAirports) {

            }
        });


        Button advancetoBid = (Button) findViewById(R.id.buttonSunAndSand);
        advancetoBid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openBiddingActivity();
            }
        });

    }



    private void setUpAdapter(List<String> airports){

        ArrayAdapter<String> airportsArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,airports);
        departureEditText.setAdapter(airportsArrayAdapter);
        destinationEditText.setAdapter(airportsArrayAdapter);



    }

    private void openBiddingActivity(){
        Intent intent = new Intent(SearchActivity.this, BiddingActivity.class);
        startActivity(intent);
    }

}
