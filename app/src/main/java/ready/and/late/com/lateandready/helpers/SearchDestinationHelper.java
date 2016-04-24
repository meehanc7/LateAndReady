package ready.and.late.com.lateandready.helpers;


import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class SearchDestinationHelper {

    public void getAirports(SearchDestinationResultsInterface searchDestinationResultsInterface){

        List<String> airports = new ArrayList<String>();

        airports.add("Charles DE Gaulle");
        airports.add("JFK");
        airports.add("Heathrow");
        airports.add("LAX");
        airports.add("Beijing");
        airports.add("La Guardia");
        airports.add("Dublin");


        searchDestinationResultsInterface.searchSuccessful(airports);

    }


    public boolean isValidAirport(String airport){
            return airport!=null && airport!="";
    }
}
