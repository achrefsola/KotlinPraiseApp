package com.example.tpmobile

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class secondFragment : Fragment() {
    private lateinit var rest_button : Button
    private lateinit var button: Button
    private lateinit var textView: TextView
    private  var count =0
    private lateinit var text_under :TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_second, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tempspause = 300L
        val fragmentsecondtext =getString(R.string.fragment_second_text)

        button = view.findViewById(R.id.buttonf)
        textView = view.findViewById(R.id.counter)
        text_under = view.findViewById(R.id.textView3)


        textView.text = count.toString()


        button.setOnClickListener {
            count++
            textView.text = count.toString()
            text_under.text =fragmentsecondtext


            // Use a Handler to post a delayed action to hide the text
            android.os.Handler().postDelayed({ text_under.text = "" }, tempspause)

            if(count==100){
                Toast.makeText(requireContext(), "you reached 100", Toast.LENGTH_SHORT).show()
            }
        }
        rest_button=view.findViewById(R.id.reset1)
        rest_button.setOnClickListener{
            count=0
            textView.text = count.toString()

        }

    }






}