
package com.htk.practicemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.htk.practicemvvm.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var numberViewModel : NumberViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // 뷰 모델 프로바이더를 통해 뷰모델 가져오기
        // 라이프사이클을 가지고 있는 녀석을 넣어줄 즉 자기 자신
        // 우리가 가져오고 싶은 뷰모델 클래스를 넣어서 뷰모델을 가져오기
        numberViewModel = ViewModelProvider(this).get(NumberViewModel::class.java)

        binding.vm = numberViewModel

        binding.lifecycleOwner = this




    }


}