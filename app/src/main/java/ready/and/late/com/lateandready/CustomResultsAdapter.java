package ready.and.late.com.lateandready;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ready.and.late.com.lateandready.helpers.SearchResult;

/**
 * Created by markf on 19/04/2016.
 */
public class CustomResultsAdapter  extends RecyclerView.Adapter<CustomResultsAdapter.DataObjectHolder>{

    private List<SearchResult> listOfResults;
    private OnItemClickListener listener;

    public CustomResultsAdapter(List<SearchResult> listOfResults, OnItemClickListener listener) {
        this.listOfResults = listOfResults;
        this.listener = listener;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override // this is where it binds the search result to the view
    public void onBindViewHolder(DataObjectHolder holder, final int position) {
        SearchResult result = listOfResults.get(position);
        holder.departureAirport.setText(result.getDepartureAirport());
        holder.departureTime.setText(result.getDepartureTime());
        holder.destinationAirport.setText(result.getDestinationAirport());
        holder.flightDuration.setText(result.getFlightDuration());
        holder.arrivalTime.setText(result.getArrivalTime());
        holder.cost.setText(result.getCost());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(listOfResults.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listOfResults.size();
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder{

        TextView departureAirport;
        TextView destinationAirport;
        TextView departureTime;
        TextView arrivalTime;
        TextView flightDuration;
        TextView cost;

        public DataObjectHolder(View itemView) {
            super(itemView);

            departureAirport = (TextView) itemView.findViewById(R.id.departureAirport);
            destinationAirport = (TextView) itemView.findViewById(R.id.destinationAirport);
            flightDuration = (TextView) itemView.findViewById(R.id.durationTime);
            arrivalTime = (TextView) itemView.findViewById(R.id.arrivalTime);
            cost = (TextView) itemView.findViewById(R.id.flightPrice);
            departureTime = (TextView) itemView.findViewById(R.id.departureTime);


        }
    }

    public interface OnItemClickListener{
        void onItemClick(SearchResult searchResult);
    }

}

