package br.com.recyclerview.model

class Student(val code: Int, var name: String, var note : Double) {
    override fun toString(): String {
        return "Student (code: $code, name: $name, note: $note)"
    }
}