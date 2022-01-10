package com.leandroid.system.teammanagement.ui.view.tournament

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.leandroid.system.teammanagement.R
import com.leandroid.system.teammanagement.model.TableItem
import com.leandroid.system.teammanagement.adapters.ViewPagerAdapter
import com.leandroid.system.teammanagement.databinding.ActivityTournamentsBinding

class TournamentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTournamentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTournamentsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2){tab,position->
            when(position){
                0->{
                    tab.text = "FIXTURE"
                }
                1->{
                    tab.text = "POSICIONES"
                }
            }

        }.attach()

        spinnerAdapter()
        itemAdapter()
    }

    private fun spinnerAdapter(){
        val list = resources.getStringArray(R.array.Divisiones)

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,list)
        binding.spinnerDivTournaments.adapter = adapter

    }

    private fun itemAdapter() = listOf(
            TableItem(1,"ESTRELLA DEL SUR",5,1,2,0,3,1,2,5),
            TableItem(2,"CRUZ DEL SUR",5,1,2,0,3,1,2,5),
            TableItem(3,"SAN CAYETANO",5,1,2,0,3,1,2,5),
            TableItem(4,"ARCO IRIS",5,1,2,0,3,1,2,5)
        )
}