package ready.and.late.com.lateandready.helpers;

/**
 * Created by markf on 24/04/2016.
 */
public class BiddingHelper {

    private double currentBid;

    public void addBid(String auctionID, double bid, BiddingResultsInterface biddingResultsInterface){
            if (bid < currentBid || bid == currentBid){
                biddingResultsInterface.bidFailed("Please enter a bid more than the current bid");
            }
            else {
                currentBid = bid;
                biddingResultsInterface.bidSucessful(currentBid);
            }
    }

    public void getLatestBid(String auctionID, double flightCost, LatestBidInterface latestBidInterface){
            currentBid = flightCost;
            latestBidInterface.currentBidSucessful(currentBid);
    }



}
