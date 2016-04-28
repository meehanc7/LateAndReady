package ready.and.late.com.lateandready.helpers;

/**
 * Created by markf on 28/04/2016.
 */
public interface BiddingResultsInterface {

    public void bidSucessful(double currentBid);
    public void bidFailed(String errorMessage);
}
