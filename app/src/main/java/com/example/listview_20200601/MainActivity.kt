package com.example.listview_20200601

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview_20200601.BaseActivity as BaseActivity1

class MainActivity : BaseActivity1() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
    }
}
