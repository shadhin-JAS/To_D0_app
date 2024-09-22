package com.cscomer.to_do_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cscomer.to_do_list.databinding.FragmentHomeBinding


class homeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentHomeBinding.inflate(layoutInflater,container,false)

        binding.addTV.setOnClickListener{

        findNavController().navigate(R.id.action_homeFragment_to_addFragment)

        }





        return binding.root
    }
}

