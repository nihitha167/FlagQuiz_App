package com.nihitha.flagquiz.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.nihitha.flagquiz.R
import com.nihitha.flagquiz.databinding.FragmentHomeBinding
import com.techmania.flagquizwithsqlitedemo.DatabaseCopyHelper

class FragmentHome : Fragment() {

    lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentHomeBinding=FragmentHomeBinding.inflate(inflater,container,false)
        createAndOpenDatabase()
        fragmentHomeBinding.buttonStart.setOnClickListener {

            val direction = FragmentHomeDirections.actionFragmentHomeToFragmentQuiz()
            this.findNavController().navigate(direction)
            //it.findNavController()
            //requireActivity().findNavController()
        }

        return fragmentHomeBinding.root
    }

    private fun createAndOpenDatabase(){
        try {

            val helper = DatabaseCopyHelper(requireActivity())
            helper.createDataBase()
            helper.openDataBase()

        }catch(e:Exception){
            e.printStackTrace()

        }
    }

}