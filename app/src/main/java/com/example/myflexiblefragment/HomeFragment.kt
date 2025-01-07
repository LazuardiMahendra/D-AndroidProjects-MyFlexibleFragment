package com.example.myflexiblefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myflexiblefragment.R.id.btn_detail_category
import com.example.myflexiblefragment.R.id.frame_layout


class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory: Button = view.findViewById(btn_detail_category)
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == btn_detail_category) {
            val categoryFragment = CategoryFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(
                    frame_layout, categoryFragment, CategoryFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
                Log.d("TAG", "CATEGORY TRANSACTION")
            }
        }

    }

}

