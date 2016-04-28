package ready.and.late.com.lateandready.helpers;

import java.util.List;

/**
 * Created by markf on 19/04/2016.
 */
public interface SearchResultsInterface {

    public void searchSuccessfull(List<SearchResult> searchResults);
    public void searchFailed(String errorMessage);



}
