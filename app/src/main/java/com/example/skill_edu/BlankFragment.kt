package com.example.skill_edu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.skill_edu.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = FragmentBlankBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener { Toast.makeText(activity, "ViewBinding in Fragments", Toast.LENGTH_SHORT).show() }
        return binding.root
    }

}