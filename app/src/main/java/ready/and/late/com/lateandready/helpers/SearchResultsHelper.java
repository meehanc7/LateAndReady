package ready.and.late.com.lateandready.helpers;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markf on 19/04/2016.
 */
public class SearchResultsHelper {

    public void searchForFlights(final String departure, final String destination, int noOfPassengers, String date, final SearchResultsInterface searchResultsInterface){

        //Running code on background thread too simulate server contact
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<SearchResult> resultList = getListOfSearchResults(departure, destination); // passing this method into the list
                searchResultsInterface.searchSuccessfull(resultList);
            }
        };

        //delay by two seconds then display the information
        handler.postDelayed(runnable, 2000);
    }

    //creating a list called that takes SearchResult as a parameter
    private List<SearchResult> getListOfSearchResults(String departure, String destination){
        List<SearchResult> mockResult= new ArrayList<>();
        mockResult.add(new SearchResult(departure, destination, "11:00", "16:00", "5 hours", "$80")); // passing in parameters from the searchresult activity
        mockResult.add(new SearchResult(departure, destination, "13:00", "18:00", "5 hours", "$76"));
        mockResult.add(new SearchResult(departure, destination, "18:00", "16:00", "2 hours", "$65"));
        mockResult.add(new SearchResult(departure, destination, "14:25", "16:00", "3 hours", "$78"));
        mockResult.add(new SearchResult(departure, destination, "11:30", "14:00", "5 hours", "$49"));
        mockResult.add(new SearchResult(departure, destination, "12:15", "13:45", "2 hours", "$55"));
        return mockResult;
    }
}
