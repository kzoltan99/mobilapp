package com.example.quotewars.quote

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quotewars.R
import com.example.quotewars.database.ActivityDatabase
import com.example.quotewars.databinding.FragmentQuoteBinding

class ActivityFragment : Fragment() {
    private lateinit var binding: FragmentQuoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_quote,
                container,
                false
        )
        val application = requireNotNull(this.activity).application
        val dataSource = ActivityDatabase.getInstance(application).activityDatabaseDao
        val viewModelFactory = ActivityViewModelFactory(dataSource,application)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(ActivityViewModel::class.java)
        binding.activityViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.buttonNextQuote.setOnClickListener {
            viewModel.getStarWarsQuote()
        }
        binding.buttonAddToFavorites.setOnClickListener {
            viewModel.addToFavorite()
            viewModel.getStarWarsQuote()

            Toast.makeText(context,"Quote added to the Favorites", Toast.LENGTH_SHORT).show()
        }
        viewModel.response().observe(viewLifecycleOwner, Observer {
            binding.textQuote.text = it.activity
            Log.i("actualQuote",it.toString())
        })
        viewModel.allQuotes.observe(viewLifecycleOwner, Observer {
            Log.i("allQuotes",it.toString())
        })
        setHasOptionsMenu(true)
        return binding.root
    }

}