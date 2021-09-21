package net.intervyaz.viewintro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import net.intervyaz.viewintro.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView
import net.intervyaz.viewintro.databinding.FragmentFirstBinding


//private lateinit var binding: FragmentFirstBinding

class FragmentFirst : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //  val view = binding.root
       // activity?.setContentView(view)
        val adapter = TicketsAdapter(this, fakeTickets)
        view.findViewById<RecyclerView>(R.id.recycler).adapter = adapter
        view.findViewById<RecyclerView>(R.id.recycler).layoutManager = LinearLayoutManager(activity)


    }
}

