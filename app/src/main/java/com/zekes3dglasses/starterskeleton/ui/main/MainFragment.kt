package com.zekes3dglasses.starterskeleton.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zekes3dglasses.starterskeleton.R
import com.zekes3dglasses.starterskeleton.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    // Declare the binding and viewModel objects for use later
    private lateinit var binding: MainFragmentBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Initialize the viewModel so it can be bound in the next step
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Set the viewModel for data binding - this allows the bound layout access to
        // all the data in the viewModel
        binding.viewModel = viewModel

        // Demonstration of setting a viewModel function to a fragment ClickListener
        binding.buttonAddDemo.setOnClickListener {
            viewModel.addToInt()
        }

        binding.buttonToDestination.setOnClickListener {
            this.findNavController().navigate(R.id.action_mainFragment_to_destinationFragment)
        }

        return binding.root
    }

}
