package ru.skillbranch.phone_shop.overview

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.skillbranch.phone_shop.MAIN
import ru.skillbranch.phone_shop.R
import ru.skillbranch.phone_shop.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFirstBinding.inflate(layoutInflater)
        loading()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root

    }

    private fun loading(){

        object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                MAIN.navController.navigate(R.id.action_firstFragment_to_secondFragment)
            }
        }.start()

}}