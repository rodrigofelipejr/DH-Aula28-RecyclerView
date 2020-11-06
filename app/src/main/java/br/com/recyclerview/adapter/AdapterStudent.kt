package br.com.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.recyclerview.R
import br.com.recyclerview.model.Student

class AdapterStudent(
    private val listStudents: ArrayList<Student>,
    private val listener: onClickStudentListeners
) :
    RecyclerView.Adapter<AdapterStudent.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student: Student = listStudents.get(position)
        holder.nameStudent.text = student.name
    }

    override fun getItemCount() = listStudents.size

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val nameStudent: TextView = itemView.findViewById(R.id.text_name_student)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onClickStudent(position)
            }
        }
    }

    interface onClickStudentListeners {
        fun onClickStudent(position: Int)
    }
}