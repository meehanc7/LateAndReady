package ready.and.late.com.lateandready.helpers;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markf on 19/04/2016.
 */
public class SearchResultsHelper {

    public void searchForFlights(final String depature, String destination, int noOfPassengers, String date, final SearchResultsInterface searchResultsInterface){

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<SearchResult> resultList = getMockData(depature);
                searchResultsInterface.searchSuccessfull(resultList);
                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);
    }

    private List<SearchResult> getMockData(String departure){
        List<SearchResult> mockResult= new ArrayList<>();
        mockResult.add(new SearchResult(departure, "New York", "11:00", "16:00", "5 hours", "$700"));
        mockResult.add(new SearchResult(departure, "New York", "11:00", "16:00", "5 hours", "$700"));
        return mockResult;
    }
}
