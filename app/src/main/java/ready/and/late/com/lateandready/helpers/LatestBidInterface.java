package ready.and.late.com.lateandready.helpers;

/**
 * Created by markf on 28/04/2016.
 */
public interface LatestBidInterface {

    public void currentBidSucessful(double latestBid);
    public void currentBidFailed(String errorMessage);
}
