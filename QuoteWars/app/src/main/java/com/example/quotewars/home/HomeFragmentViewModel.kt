package com.example.quotewars.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel

class HomeFragmentViewModel: ViewModel() {

    fun openGithub(context: Context){
        val pageURL="https://github.com/kzoltan99/mobilapp"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(pageURL))
        context.startActivity(browserIntent)
    }
}