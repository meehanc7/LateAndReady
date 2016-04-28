package ready.and.late.com.lateandready;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import ready.and.late.com.lateandready.helpers.SearchDestinationHelper;
import ready.and.late.com.lateandready.helpers.SearchDestinationResultsInterface;

public class SearchActivity extends AppCompatActivity {


    private AutoCompleteTextView departureEditText;
    private AutoCompleteTextView destinationEditText;
    private EditText departureDate;
    private EditText noOfPassengers;
    private DatePickerDialog datePickerDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        departureEditText = (AutoCompleteTextView)findViewById(R.id.departureEditText);
        destinationEditText = (AutoCompleteTextView) findViewById(R.id.destinationEditText);
        departureDate = (EditText)findViewById(R.id.departureDate);
        noOfPassengers = (EditText)findViewById(R.id.noOfPassengers);


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

        Calendar newCalendar = Calendar.getInstance();
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        //set todays date
        departureDate.setText(dateFormatter.format(new Date().getTime()));
        departureDate.setInputType(InputType.TYPE_NULL);
        departureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        //date picker when the user clicks the date
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                departureDate.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


                Button advancetoSearchResults = (Button) findViewById(R.id.buttonSearchFlight);
        advancetoSearchResults.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String departureText = String.valueOf(departureEditText.getText());
                String destinationText = String.valueOf(destinationEditText.getText());
                String date = String.valueOf(departureDate.getText());
                String passengers = String.valueOf(noOfPassengers.getText());

                if (!searchDestinationHelper.isValidAirport(departureText)){
                    showToast("Departure airport not valid");
                }
                else if (!searchDestinationHelper.isValidAirport(destinationText)){
                    showToast("Destination airport not valid");
                }
                else
                {
                    openResultsActivity(departureText, destinationText, date, Integer.valueOf(passengers));
                }


            }
        });

    }

    private void setUpAdapter(List<String> airports){           //creating a new adapter for our autocomplete textviews
        ArrayAdapter<String> airportsArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,airports);
        departureEditText.setAdapter(airportsArrayAdapter);
        destinationEditText.setAdapter(airportsArrayAdapter);
    }

    private void openResultsActivity(String departure, String destination, String date, int noOfPassengers){
        Intent intent = new Intent(SearchActivity.this, ResultsActivity.class);

        //carries to next activity
        intent.putExtra("key_departure", departure);
        intent.putExtra("key_destination", destination);
        intent.putExtra("key_date", date);
        intent.putExtra("key_noOfPassengers", noOfPassengers);
        startActivity(intent);
    }

    private void showToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
