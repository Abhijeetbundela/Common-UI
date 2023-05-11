package com.example.commonui.activities.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.commonui.R


class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this)[PageViewModel::class.java].apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val imageView: ImageView = root.findViewById(R.id.imageView)
        val titleView: TextView = root.findViewById(R.id.textView)
        val subtitleView: TextView = root.findViewById(R.id.textView2)
        val button: Button = root.findViewById(R.id.button)
        button.setOnClickListener {

        }
        pageViewModel.text.observe(viewLifecycleOwner, Observer<Int> {
            var tempInt = R.drawable.img1
            var title = "Request Ride"
            var subTitle = "Request a Ride get picked up by a  nearby driver"

            when (it) {
                0 -> {
                    tempInt = R.drawable.img1
                    title = "Request Ride"
                    subTitle = "Request a Ride get picked up by a  nearby driver"
                    button.visibility = View.GONE
                }
                1 -> {
                    tempInt = R.drawable.img2
                    title = "Confirm Your Driver"
                    subTitle = "Huge drivers network helps you find ,safe and cheap ride"
                    button.visibility = View.GONE
                }
                2 -> {
                    tempInt = R.drawable.img3
                    title = "Track you ride"
                    subTitle =
                        "Know you driver in advance and be able to view current location in real time on the map"
                    button.visibility = View.VISIBLE

                }
            }
            val drawable = ContextCompat.getDrawable(requireContext(), tempInt)
            imageView.setImageDrawable(drawable)
            titleView.text = title
            subtitleView.text = subTitle

        })
        return root
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}