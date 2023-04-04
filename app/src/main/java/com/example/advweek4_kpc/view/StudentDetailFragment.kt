package com.example.advweek4_kpc.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4_kpc.R
import com.example.advweek4_kpc.model.Student
import com.example.advweek4_kpc.viewmodel.DetailViewModel
import com.example.advweek4_kpc.viewmodel.ListViewModel
import com.google.android.material.textfield.TextInputEditText

class StudentDetailFragment : Fragment() {
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.student_list_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailViewModel.fetch()

        observeViewModel()
    }

    fun observeViewModel(){
        detailViewModel.studentLD.observe(viewLifecycleOwner, Observer {
            val txtId = view?.findViewById<TextInputEditText>(R.id.txtIntID)
            val txtName = view?.findViewById<TextInputEditText>(R.id.txtIntName)
            val txtBDate = view?.findViewById<TextInputEditText>(R.id.txtIntBod)
            val txtPhone = view?.findViewById<TextInputEditText>(R.id.txtIntPhone)
            val photo = view?.findViewById<ImageView>(R.id.imageView2)

            txtId?.setText(detailViewModel.studentLD.value?.id)
            txtName?.setText(detailViewModel.studentLD.value?.name)
            txtBDate?.setText(detailViewModel.studentLD.value?.dob)
            txtPhone?.setText(detailViewModel.studentLD.value?.phone)

        })
    }
}