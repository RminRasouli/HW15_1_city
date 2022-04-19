package com.armin.hw15_1_city.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.armin.hw15_1_city.R
import com.armin.hw15_1_city.databinding.FragmentTwoBinding
import com.armin.hw15_1_city.ui.adapter.SecendAdapter
import com.armin.hw15_1_city.ui.viewmodel.ViewModelCity

class TwoFragment : Fragment(R.layout.fragment_two) {
    private val viewModel: ViewModelCity by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentTwoBinding.bind(view)
        val secendAdapter = SecendAdapter()
        binding.apply {
            recyclerViewSecendList.apply {
                adapter = secendAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)

                viewModel.selectedCity.observe(viewLifecycleOwner) {
                    secendAdapter.submitList(it)
                }

                setOnClickListener {
                    viewModel.selectedCity.observe(viewLifecycleOwner) {
                        secendAdapter.submitList(it)
                    }
                }
            }
        }
    }
}