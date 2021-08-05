package com.htk.practicemvvm

import android.content.ContentValues.TAG
import android.sax.Element
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType {
    PLUS, MINUS
}

//데이터의 변경
// 뷰모델은 데이터의 변경사항을 알려주는 라이브 데이터를 가지고 있음
class NumberViewModel : ViewModel() {

    // Mutable 라이브 데이터 - 수정 가능한 데이터
    // 라이브 데이터 - 값이 변경 안됨

    // 내부에서 설정하는 자료형은 뮤터블로
    // 변경가능하도록 설정
    private val _currentValue = MutableLiveData<Int>()

    val currentValue: LiveData<Int>
        get() = _currentValue

    //초기값 설정
    init {
        Log.d(TAG, "myNumberViewModel - 생성자 호출")
        _currentValue.value = 0
    }

    fun plusValue() {
        _currentValue.value = _currentValue.value?.plus(1)
    }

    fun minusValue() {
        _currentValue.value = _currentValue.value?.minus(1)
    }
}
