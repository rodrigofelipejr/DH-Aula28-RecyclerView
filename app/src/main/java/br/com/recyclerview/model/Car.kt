package br.com.recyclerview.model

class Car(val code: Int, var brand: String, var model : String) {
    override fun toString(): String {
        return "Car (code: $code, brand: $brand, model: $model)"
    }
}