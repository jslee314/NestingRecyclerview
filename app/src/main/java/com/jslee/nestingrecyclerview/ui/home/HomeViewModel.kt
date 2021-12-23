package com.jslee.nestingrecyclerview.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jslee.nestingrecyclerview.data.MenuData

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val secondListOfFist: ArrayList<String> = arrayListOf(
        "PC에서 인증서 가져오기", "PC로 인증서 내보내", "", "")

    val secondListOfThird: ArrayList<String> = arrayListOf(
        "인증서 발급/재발급", "인증서 갱신", "인증서 폐지")

    val fistList : ArrayList<MenuData> = arrayListOf(MenuData(
        "인증서 이동",secondListOfFist), MenuData("인증서 신청",secondListOfFist),
        MenuData("인증서 발급",secondListOfFist), MenuData("인증서 관리",secondListOfFist), MenuData("인증서 이용 안내", secondListOfFist))







}