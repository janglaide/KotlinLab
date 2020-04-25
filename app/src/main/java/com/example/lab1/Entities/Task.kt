package com.example.lab1.Entities


class Task {
    var id : Int = 0
    var name : String = ""
    constructor(Id: Int, Name :String){
        id = Id
        name = Name
    }
    constructor(Name : String){
        name = Name
    }
}