package ready.and.late.com.lateandready;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;

import ready.and.late.com.lateandready.helpers.SearchResult;
import ready.and.late.com.lateandready.helpers.SearchResultsHelper;
import ready.and.late.com.lateandready.helpers.SearchResultsInterface;

public class ResultsActivity extends Activity {


    private RecyclerView resultsRecyclerView;           //new list view, makes for better performance
    private ProgressBar resultsProgressBar;
    private CustomResultsAdapter resultsAdapter;        //takes each result and displays how we say

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        resultsRecyclerView=(RecyclerView)findViewById(R.id.resultsRecyclerView);
        resultsProgressBar= (ProgressBar)findViewById(R.id.resultsProgressBar);

        //setting up recyeclerview
        resultsRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        resultsRecyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL); //divider
        resultsRecyclerView.addItemDecoration(itemDecoration);

        SearchResultsHelper searchResultsHelper = new SearchResultsHelper();

        if(getIntent()!=null){
            String departure = getIntent().getStringExtra("key_departure");
            String destination = getIntent().getStringExtra("key_destination");
            searchResultsHelper.searchForFlights(departure, destination, 1, "07/11/16", new SearchResultsInterface() {
                @Override
                public void searchSuccessfull(List<SearchResult> searchResults) {
                    resultsAdapter= new CustomResultsAdapter(searchResults, new CustomResultsAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(SearchResult searchResult) {
                                openBiddingScreen(searchResult);
                        }
                    });
                    resultsProgressBar.setVisibility(View.GONE);

                    resultsRecyclerView.setAdapter(resultsAdapter);
                }

                @Override
                public void searchFailed(String errorMessage) {
                }
            });
        }
    }

    private void openBiddingScreen(SearchResult searchResult){
        Intent intent = new Intent(ResultsActivity.this, BiddingActivity.class);
        intent.putExtra("key_search_results", searchResult);
        startActivity(intent);
    }

}

