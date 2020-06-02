package com.example.listview_20200601.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listview_20200601.R
import com.example.listview_20200601.datas.Student

class StudentAdapter(context:Context,resId:Int,list:List<Student>):ArrayAdapter<Student>(context,resId,list) {

    val mContext= context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //convertView 변수에 재사용할 뷰가 담겨서 getView가 실행됨
        var tempRow = convertView

        if (tempRow == null) { // 재사용할 XML(List Item) 이 없는 경우(처음 몇개를 그릴때는 아직 없겠지?)
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }
        val row = tempRow!!

        val nameAndAgeTxt = row.findViewById<TextView>(R.id.nameAndAgeTxt)
        val genderTxt = row.findViewById<TextView>(R.id.genderTxt)

        val data = mList.get(position)
        //nameAndAgeTxt.text=data.name + "(" + (2020-data.birthYear).toString() + ")"
        //nameAndAgeTxt.text=data.name + "(" + data.getKoreanAge(2020).toString() + ")"
        nameAndAgeTxt.text="${data.name}(${data.getKoreanAge(2020)}세)"
        if(data.isMale) {
            genderTxt.text = "남자"
        }
        else{
            genderTxt.text = "여자"
        }

        return row
    }
}