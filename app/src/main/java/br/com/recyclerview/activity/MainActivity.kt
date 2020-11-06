package br.com.recyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.recyclerview.R
import br.com.recyclerview.adapter.AdapterStudent
import br.com.recyclerview.model.Student

class MainActivity : AppCompatActivity(), AdapterStudent.onClickStudentListeners {
    private var listStudents = getAllStudents()
    private lateinit var adapterStudent: AdapterStudent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterStudent = AdapterStudent(listStudents, this)

        val recyclerViewStudent = findViewById<RecyclerView>(R.id.recyclerViewStudent)
        recyclerViewStudent.adapter = adapterStudent
        recyclerViewStudent.layoutManager = LinearLayoutManager(this)
        recyclerViewStudent.setHasFixedSize(true)
    }

    private fun getAllStudents(): ArrayList<Student> {
        val studentA = Student(99, "Rodrigo", 7.0)
        val studentB = Student(98, "Matheus", 7.0)
        val studentC = Student(97, "Lucas", 7.0)

        return arrayListOf(studentA, studentB, studentC)
    }

    override fun onClickStudent(position: Int) {
        val student: Student = listStudents.get(position)
        student.name = "Pedro"
        adapterStudent.notifyItemChanged(position)

        Toast.makeText(this, student.name, Toast.LENGTH_SHORT).show()
    }
}