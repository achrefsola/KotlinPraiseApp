package com.example.tpmobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class thirdFragment : Fragment() {

    private lateinit var rest_button :Button
    private lateinit var button: Button
    private lateinit var textView: TextView
    private  var count =0
    private lateinit var text_under :TextView





    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("count",textView.toString())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_third, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tempspause = 400L
        val fragmentthirdtext =getString(R.string.fragment_third_text)


        button = view.findViewById(R.id.buttonf2)
        textView = view.findViewById(R.id.counter2)
        text_under = view.findViewById(R.id.textView4)

        textView.text = count.toString()
        button.setOnClickListener {
            count++
            textView.text = count.toString()
            text_under.text =fragmentthirdtext
            android.os.Handler().postDelayed({ text_under.text = "" }, tempspause)


        }

        rest_button=view.findViewById(R.id.reset2)
        rest_button.setOnClickListener{
            count=0
            textView.text = count.toString()
        }

    }





}