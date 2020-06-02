package com.example.listview_20200601

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listview_20200601.adapters.StudentAdapter
import com.example.listview_20200601.datas.Student
import kotlinx.android.synthetic.main.activity_main.*
import com.example.listview_20200601.BaseActivity as BaseActivity1

class MainActivity : BaseActivity1() {

    val students = ArrayList<Student>()
    lateinit var studentAdapter:StudentAdapter //선언만 우선 하고 형은 나중에 알려주겠어
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        studentListView.setOnItemClickListener { parent, view, position, id ->
            //Toast.makeText(mContext,"${psition}번 줄 클락",Toast.LENGTH_SHORT).show()
            Toast.makeText(mContext,"${students.get(position).name}",Toast.LENGTH_SHORT).show()
        }

        studentListView.setOnItemLongClickListener { parent, view, position, id ->

            //Toast.makeText(mContext,"${students.get(position).name}",Toast.LENGTH_SHORT).show()
            //Toast.makeText(mContext,"${students[position].name}을 오래누름",Toast.LENGTH_SHORT).show()

            val alert = AlertDialog.Builder(mContext)
            alert.setTitle("삭제확인")
            alert.setMessage("정말 이 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->

                students.removeAt(position)
                studentAdapter.notifyDataSetChanged()
            })

            alert.setNegativeButton("취소",null)
            alert.show()
            return@setOnItemLongClickListener true //롱클릭 이벤트만 실행
            //return@setOnItemLongClickListener false //모든 클릭이벤트를 실행시킴

        }
    }

    override fun setValues() {
        students.add(Student("조경진",1988,false))
        students.add(Student("김미영",2010,false))
        students.add(Student("김성우",1982,true))
        students.add(Student("김형근",1998,true))

        studentAdapter = StudentAdapter(mContext,R.layout.student_list_item,students)
        studentListView.adapter = studentAdapter
    }
}
