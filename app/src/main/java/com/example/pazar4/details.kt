package com.example.pazar4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val facebook_id_textview : TextView = findViewById(R.id.teretana)
        val facebook_first_name_textview : TextView = findViewById(R.id.teretana2)

        val facebookId = intent.getStringExtra("facebook_id")
        val facebookFirstName = intent.getStringExtra("facebook_first_name")
        val facebookMiddleName = intent.getStringExtra("facebook_middle_name")
        val facebookLastName = intent.getStringExtra("facebook_last_name")
        val facebookName = intent.getStringExtra("facebook_name")
        facebook_id_textview.text = facebookId
        facebook_first_name_textview.text = facebookFirstName


    }
}