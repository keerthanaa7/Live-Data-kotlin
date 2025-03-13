package com.anushka.viewmodeldemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var activityMainViewModel:ActivityMainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val resultTextView = binding.resultTextView
        var inputEditText = binding.inputCount
        val clickButton = binding.clickbutton

        activityMainViewModel = ViewModelProvider(this).get(ActivityMainViewModel::class.java)


        activityMainViewModel.totalData.observe(this, Observer {
            resultTextView.text = it.toString()
        } )

        clickButton.setOnClickListener {
            activityMainViewModel.setTotal(binding.inputCount.text.toString().toInt())
        }
    }
}

