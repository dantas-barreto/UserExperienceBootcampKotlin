package com.dantasbarreto.ux_kotlin

import android.content.SharedPreferences

class ContactHelper(private val sharedPreferences: SharedPreferences) {
    fun getListContacts(): List<Contact> {
        return arrayListOf()
    }

    fun setListContacts(list: List<Contact>) {

    }
}