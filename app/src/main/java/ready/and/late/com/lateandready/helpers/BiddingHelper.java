package ready.and.late.com.lateandready.helpers;

import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

/**
 * Created by markf on 24/04/2016.
 */
public class BiddingHelper {

    private double currentBid;
    private CountDownTimer countDownTimer;

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

    public void getTimeRemaining(String auctionID, final TimeRemainingInterface timeRemainingInterface){
            if (countDownTimer != null){
                // creating new countdown time, 2 minutes ticks every second
                countDownTimer = new CountDownTimer(120000, 1000) {
                    @Override

                    // changing time to make it look nice (got online)
                    public void onTick(long millisUntilFinished) {
                        String time = "" + String.format("%d min, %d sec",
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                        timeRemainingInterface.countdownTime(time);
                    }

                    @Override
                    public void onFinish() {

                    }
                };
            }
    }



}
