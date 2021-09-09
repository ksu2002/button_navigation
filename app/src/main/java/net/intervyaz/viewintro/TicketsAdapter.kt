package net.intervyaz.viewintro

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.intervyaz.viewintro.databinding.TicketItemBinding

class TicketsAdapter(
    context: Context,
    var tickets: List<Ticket>
) : RecyclerView.Adapter<TicketsAdapter.TicketsBinder>() {
    override fun getItemCount(): Int {
        return tickets.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsBinder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TicketItemBinding.inflate(inflater, parent, false)

        return TicketsBinder(binding)
    }

    override fun onBindViewHolder(holder: TicketsBinder, position: Int) {
        holder.bind(tickets[position])
    }

    class TicketsBinder(
        private val binding: TicketItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ticket: Ticket) {
            with(binding) {
                ticketNumber.text = ticket.flightNumber
                departureTime.text = ticket.startTime
                departurePlace.text = ticket.startPlace

                arrivalPlace.text = ticket.endPlace
                arrivalTime.text = ticket.endTime

                flightTime.text = ticket.flightTime
            }
        }
    }
}