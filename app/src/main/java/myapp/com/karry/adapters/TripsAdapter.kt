package myapp.com.karry.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.trip_row.view.*
import myapp.com.karry.R
import myapp.com.karry.activities.TripDetails
import myapp.com.karry.entity.Trip

class TripViewHolder(val view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view)

class TripsAdapter(private val tripList: List<Trip>, val click: (trip: Trip) -> Unit) :
    androidx.recyclerview.widget.RecyclerView.Adapter<TripViewHolder>() {

    override fun getItemCount(): Int {
        return tripList.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.trip_row, parent, false)
        return TripViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        val trip = tripList[position]
        holder.view.tripDepartureCityDetails.text = trip.departureCity
        holder.view.tripDestinationCity.text = trip.destinationCity
        holder.view.userName.text = trip.owner.firstname + " " + trip.owner.lastname
        holder.view.userRate.text = trip.owner.ratings
        holder.view.searchEndDate.text = "TODO" // TODO: Get trip date

        holder.view.tripCard.setOnClickListener { click(trip) }
    }
}