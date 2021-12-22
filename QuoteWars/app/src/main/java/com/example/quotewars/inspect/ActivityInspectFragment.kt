package com.example.quotewars.inspect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quotewars.R
import com.example.quotewars.database.ActivityDatabase
import com.example.quotewars.databinding.FragmentQuoteInspectBinding

class ActivityInspectFragment : Fragment() {

    val args: ActivityInspectFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentQuoteInspectBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_quote_inspect,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = ActivityDatabase.getInstance(application).activityDatabaseDao
        val viewModelFactory = ActivityInspectViewModelFactory(dataSource, application)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(ActivityInspectViewModel::class.java)
        viewModel.getQuote(args.quoteId)
        binding.viewModel = viewModel
        binding.textQuoteToInspect.text = args.activity
        binding.buttonDeleteQuote.setOnClickListener {
            viewModel.deleteQuote()
            findNavController().navigate(ActivityInspectFragmentDirections.navigateBackToRecyclerView())
        }
        return binding.root
    }
}