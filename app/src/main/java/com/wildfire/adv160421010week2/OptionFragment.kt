package com.wildfire.adv160421010week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wildfire.adv160421010week2.databinding.ActivityMainBinding
import com.wildfire.adv160421010week2.databinding.FragmentOptionBinding

class OptionFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentOptionBinding
    private val LEVEL = arrayOf("Easy", "Medium", "Hard")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_dropdown_item_1line, LEVEL)
        binding.txtLevel.setAdapter(adapter)
    }


}