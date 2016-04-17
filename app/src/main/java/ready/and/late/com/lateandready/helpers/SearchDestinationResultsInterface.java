package ready.and.late.com.lateandready.helpers;


import java.util.List;

public interface SearchDestinationResultsInterface {

    public void searchSuccessful(List<String> airportList);

    public void searchFailed (String errorMessageAirports);

}
