package com.wildfire.adv160421010week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.wildfire.adv160421010week2.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var binding:FragmentGameBinding
    private var rand1 = 0;
    private var rand2 = 0;
    private var score = 0;

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        randomize()
        arguments?.let {
            val playerName =
                GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$playerName's Turn"
        }
        binding.btnAns.setOnClickListener {

            val answer = Integer.parseInt(binding.txtAns.text.toString())
//            println("answer = $answer")
//            println(rand1 + rand2)
            if(answer == (rand1 + rand2)){
                randomize()
                score += 1
            }
            else{
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }

    fun randomize(){
        rand1 = (0..69).random()
        rand2 = (0..69).random()
        binding.txtQuestion.text = "$rand1 + $rand2"
        binding.txtAns.text?.clear();
    }
}