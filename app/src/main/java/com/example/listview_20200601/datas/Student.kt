package com.example.listview_20200601.datas

class Student(val name:String,val birthYear:Int, val isMale:Boolean) {

    fun getKoreanAge(year:Int):Int{
        //2020 - birthYear +1
        return year - this.birthYear +1
    }

}