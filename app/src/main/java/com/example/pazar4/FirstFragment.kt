package com.example.pazar4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pazar4.Adapters.OglasAdapter
import com.example.pazar4.Models.Oglas
import com.example.pazar4.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var adapter : OglasAdapter

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val oglas1 : Oglas = Oglas(10,"andrej",publisherID = "kiko",thumbnail = "https://gdb.voanews.com/BB0D17A2-D48D-49F1-9AF0-9B7BB7E2F378_cx0_cy7_cw0_w1023_r1_s.jpg",
            desc = "dsakdaskdjskahda",location = "Tetovo", price = "2300",telbroj = "098765321", email = "andreeski@kikoski.com")

        val oglas2 : Oglas = Oglas(3,"dareee",publisherID = "deko",thumbnail = "https://gdb.voanews.com/BB0D17A2-D48D-49F1-9AF0-9B7BB7E2F378_cx0_cy7_cw0_w1023_r1_s.jpg",
            desc = "epa taka sakam", location = "Ohrid", price = "5000",telbroj = "226589756", email = "vol@magare.com")

        adapter = OglasAdapter(listOf<Oglas>(oglas1,oglas2) as MutableList<Oglas>)
        /*binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/

        val recView : RecyclerView = view.findViewById(R.id.recycler_view)

        recView.layoutManager = LinearLayoutManager(this.context)

        recView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}