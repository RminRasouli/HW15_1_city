package com.armin.hw15_1_city.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.armin.hw15_1_city.R
import com.armin.hw15_1_city.databinding.FragmentOneBinding
import com.armin.hw15_1_city.ui.adapter.MainAdapter
import com.armin.hw15_1_city.ui.viewmodel.ViewModelCity


class OneFragment : Fragment(R.layout.fragment_one) {
    private val viewModel: ViewModelCity by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("CityStats", " Create Ragment one")
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentOneBinding.bind(view)
        val mainAdapter = MainAdapter()

        binding.apply {
            recyclerViewMainList.apply {
                adapter = mainAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)

                viewModel.citys.observe(viewLifecycleOwner) {
                    mainAdapter.submitList(it)
                }
            }
        }
        binding.febCheckOut.setOnClickListener {
            val transaction = getParentFragmentManager().beginTransaction()
            transaction.replace(R.id.nav_host_fragment, TwoFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }


    }
}