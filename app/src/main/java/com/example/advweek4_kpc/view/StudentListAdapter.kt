package com.example.advweek4_kpc.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4_kpc.R
import com.example.advweek4_kpc.model.Student

class StudentListAdapter(val studentList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(){
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val infalter = LayoutInflater.from(parent.context)
        val view = infalter.inflate(R.layout.student_list_item, parent, false)

        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtID).text = studentList[position].id
        holder.view.findViewById<TextView>(R.id.txtName).text = studentList[position].name

        holder.view.findViewById<Button>(R.id.btnDetail).setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateStudentList(newStudentList: ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}