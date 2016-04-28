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
import android.widget.Toast;

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

        departureEditText = (AutoCompleteTextView)findViewById(R.id.departureEditText);
        destinationEditText = (AutoCompleteTextView) findViewById(R.id.destinationEditText);

        final SearchDestinationHelper searchDestinationHelper = new SearchDestinationHelper();
        searchDestinationHelper.getAirports(new SearchDestinationResultsInterface() {
            @Override
            public void searchSuccessful(List<String> airportList) {
                setUpAdapter(airportList);
            }

            @Override
            public void searchFailed(String errorMessageAirports) {
                showToast(errorMessageAirports);
            }
        });


        Button advancetoSearchResults = (Button) findViewById(R.id.buttonSearchFlight);
        advancetoSearchResults.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String departureText = String.valueOf(departureEditText.getText());
                String destinationText = String.valueOf(destinationEditText.getText());

                if (!searchDestinationHelper.isValidAirport(departureText)){
                    showToast("Departure airport not valid");
                }
                else if (!searchDestinationHelper.isValidAirport(destinationText)){
                    showToast("Destination airport not valid");
                }
                else
                {
                    openResultsActivity(departureText, destinationText);
                }


            }
        });

    }

    private void setUpAdapter(List<String> airports){           //creating a new adapter for our autocomplete textviews
        ArrayAdapter<String> airportsArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,airports);
        departureEditText.setAdapter(airportsArrayAdapter);
        destinationEditText.setAdapter(airportsArrayAdapter);
    }

    private void openResultsActivity(String departure, String destination){
        Intent intent = new Intent(SearchActivity.this, ResultsActivity.class);
        intent.putExtra("key_departure", departure);
        intent.putExtra("key_destination", destination); //carries to next activity
        startActivity(intent);
    }

    private void showToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
