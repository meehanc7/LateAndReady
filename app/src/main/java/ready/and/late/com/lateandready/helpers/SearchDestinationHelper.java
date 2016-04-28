package ready.and.late.com.lateandready.helpers;


import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class SearchDestinationHelper {

    private List<String> airportsList;

    public void getAirports(SearchDestinationResultsInterface searchDestinationResultsInterface){

        airportsList = new ArrayList<String>();

        airportsList.add("Charles DE Gaulle");
        airportsList.add("JFK");
        airportsList.add("Heathrow");
        airportsList.add("LAX");
        airportsList.add("Beijing");
        airportsList.add("La Guardia");
        airportsList.add("Dublin");


        searchDestinationResultsInterface.searchSuccessful(airportsList);

    }


    public boolean isValidAirport(String airport){
        if(airport != null && airport.length() > 0 && airportsList.contains(airport)){
            return true;
        }
        else {
            return false;
        }
    }
}
