package com.example.assigment2

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_compare.*
import android.content.Intent
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.firebase.firestore.FirebaseFirestore
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.FirebaseError
import com.google.firebase.database.*
import com.google.firebase.FirebaseApp
import kotlinx.android.synthetic.main.activity_main.*
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_compare.*
import com.google.firebase.database.*




class SpinnerActivity : AppCompatActivity(){
    private lateinit var database: DatabaseReference
    lateinit var option : Spinner
    lateinit var option2 : Spinner
    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_compare)


        option = findViewById(R.id.spinner) as Spinner
        option2 = findViewById(R.id.spinner2) as Spinner
        result = findViewById(R.id.textView33) as TextView

        var options = arrayOf("RTX 2060", "RTX 2070", "RTX 2080")
        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        option2.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{


            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spinner) {
                    when(position){
                        0 -> readSingleData()
                        1 -> textView21.setText("AMD")
                        2 -> textView21.setText("OTHERS")
                    }
                }
            }
        }

    }

    fun readSingleData(){
        FirebaseDatabase.getInstance().reference
            .child("user")
            .child("1")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    textView21.text = map["age"].toString()
                }

            })
    }
}