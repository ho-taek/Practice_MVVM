
package com.htk.practicemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.htk.practicemvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var numberViewModel : NumberViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뷰 모델 프로바이더를 통해 뷰모델 가져오기
        // 라이프사이클을 가지고 있는 녀석을 넣어줄 즉 자기 자신
        // 우리가 가져오고 싶은 뷰모델 클래스를 넣어서 뷰모델을 가져오기
        numberViewModel = ViewModelProvider(this).get(NumberViewModel::class.java)


        // 뷰모델이 가지고 있는 값의 변경사항을 관찰할 수 있는 라이브 데이터를 옵저빙함.
        numberViewModel.currentValue.observe(this, Observer {
        binding.tvNum.text = it.toString()
        })

        //버튼 클릭시 PLUS, MINUS
        binding.btnMinus.setOnClickListener(this)
        binding.btnPlus.setOnClickListener (this)

    }

    override fun onClick(v: View?) {
        val userInput : Int = binding.etUserInput.text.toString().toInt()
        when(v){
            binding.btnPlus ->
                numberViewModel.updateValue(actionType = ActionType.PLUS, userInput)

            binding.btnMinus ->
                numberViewModel.updateValue(actionType = ActionType.MINUS, userInput)
        }
    }
}