package com.example.pazar4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.pazar4.Models.Oglas
import com.facebook.FacebookSdk
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {

    val reference = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FacebookSdk.sdkInitialize(getApplicationContext());

        val loginBtn : Button = findViewById(R.id.loginBtn)
        val uploadBtn : Button = findViewById(R.id.btnUpload)
        val showBtn : Button = findViewById(R.id.showBtn)

        showBtn.setOnClickListener(){
            reference.collection("Oglasi").get().addOnSuccessListener { querySnapshot ->
                querySnapshot.forEach {
                    document -> Toast.makeText(this,document.get("name").toString(),Toast.LENGTH_LONG).show()
                }
            }
        }

        uploadBtn.setOnClickListener(){
            val oglas = Oglas(1,"okdsae", Calendar.getInstance().time,"kikoski","kur","dsalkdsahfskkfsdasdsadasfsa")
            val database = FirebaseFirestore.getInstance()
            database.collection("Oglasi").add(oglas)
           // val myRef = database.getReference("message")

            //myRef.setValue("Hello, World!")
        }

        loginBtn.setOnClickListener(){
            val intent = Intent(this, LoginActivity :: class.java)
            startActivity(intent)
        }
    }
}