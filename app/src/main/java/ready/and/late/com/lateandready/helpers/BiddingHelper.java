package ready.and.late.com.lateandready.helpers;

import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

/**
 * Created by markf on 24/04/2016.
 */
public class BiddingHelper {

    private double currentBid;
    private CountDownTimer countDownTimer;
    private int secondsgone;

    public void addBid(String auctionID, double bid, BiddingResultsInterface biddingResultsInterface){
            if (bid < currentBid || bid == currentBid){
                biddingResultsInterface.bidFailed("Please enter a bid more than the current bid");
            }
            else {
                currentBid = bid;
                biddingResultsInterface.bidSucessful(currentBid);
            }
    }

        //the current bid as soon as the bidding screen opens
    public void getLatestBid(String auctionID, double flightCost, LatestBidInterface latestBidInterface){
            currentBid = flightCost; //update with the mock bid
            latestBidInterface.currentBidSucessful(currentBid); //calling bid successful method and passing through current bid
    }

    public void getTimeRemaining(String auctionID, final TimeRemainingInterface timeRemainingInterface){
            if (countDownTimer == null){
                // creating new countdown time, 2 minutes ticks every second
                countDownTimer = new CountDownTimer(120000, 1000) {
                    @Override

                    // changing time to make it look nice - run every second
                    public void onTick(long millisUntilFinished) {
                        secondsgone = secondsgone +1;
                        String time = "" + String.format("%d min, %d sec",
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                        timeRemainingInterface.countdownTime(time);
                        // fake bidding after 5 seconds, updating the current bid, fake user
                        if (secondsgone == 5){
                            currentBid = currentBid +10;
                            timeRemainingInterface.updateCurrentBid(currentBid, "mary123");
                        }
                    }

                    @Override
                    public void onFinish() {
                        timeRemainingInterface.countdownTimeFinished();
                    }
                };
                countDownTimer.start();
            }
    }



}
