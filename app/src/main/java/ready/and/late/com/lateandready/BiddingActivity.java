package ready.and.late.com.lateandready;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class BiddingActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding);


        Button cancelBid = (Button) findViewById(R.id.buttonCancelBid);
        cancelBid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openResultsActivity();
            }

        });


    }
    private void openResultsActivity(){
        Intent intent = new Intent(BiddingActivity.this, ResultsActivity.class);
        startActivity(intent);



}
}
