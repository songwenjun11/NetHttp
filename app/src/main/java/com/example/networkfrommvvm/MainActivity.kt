package com.example.networkfrommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    val viewModel by lazy { ViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv).setOnClickListener {
            viewModel.notNetWorkLiveData.observe(this) {
                Toast.makeText(this, "无网络连接", Toast.LENGTH_LONG).show()
            }
            viewModel.getParamsLiveData.observe(this) {
                if (it.equals("null")) {
                    Toast.makeText(this, "错误", Toast.LENGTH_LONG).show()
                    return@observe
                }
                Toast.makeText(this, "成功", Toast.LENGTH_LONG).show()
            }
            viewModel.get()
        }
    }
}