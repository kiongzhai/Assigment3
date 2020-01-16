package com.example.assigment2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_compare.*
import androidx.appcompat.app.AppCompatActivity
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_compare.*



/**
 * A simple [Fragment] subclass.
 */
class CompareFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val t = inflater.inflate(R.layout.fragment_compare, container, false)
        val spinner = t.findViewById<Spinner>(R.id.spinner)
        val spinner2 = t.findViewById<Spinner>(R.id.spinner2)
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spinner) {
                    when (position) {
                        0 -> {
                            readSingleData3()
                            imageView2.setImageResource(R.drawable.nvidia)
                        }
                        1 -> {
                            readSingleData2()
                            imageView2.setImageResource(R.drawable.amd)
                        }

                    }
                }

            }
        }
        spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spinner2) {
                    when (position) {
                        0 -> {  readSingleData()
                                imageView3.setImageResource(R.drawable.nvidia)
                        }
                        1 -> {
                            readSingleData4()
                            imageView3.setImageResource(R.drawable.amd)
                        }
                    }
                }
            }
        }
        return t
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun readSingleData(){
        FirebaseDatabase.getInstance().reference
            .child("user")
            .child("2")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    textView20?.text = map["brand"].toString()
                    textView32?.text = map["rank"].toString()
                    textView40?.text = map["price"].toString()
                    textView59?.text = map["cs"].toString()
                    textView55?.text = map["parallax"].toString()
                    textView65?.text = map["overall"].toString()

                }
            })
    }

    fun readSingleData4(){
        FirebaseDatabase.getInstance().reference
            .child("user")
            .child("1")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    textView20?.text = map["brand"].toString()
                    textView32?.text = map["rank"].toString()
                    textView40?.text = map["price"].toString()
                    textView59?.text = map["cs"].toString()
                    textView55?.text = map["parallax"].toString()
                    textView65?.text = map["overall"].toString()

                }
            })
    }

    fun readSingleData3(){
        FirebaseDatabase.getInstance().reference
            .child("user")
            .child("2")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    textView21?.text = map["brand"].toString()
                    textView33?.text = map["rank"].toString()
                    textView39?.text = map["price"].toString()
                    textView58?.text = map["cs"].toString()
                    textView54?.text = map["parallax"].toString()
                    textView64?.text = map["overall"].toString()

                }
            })
    }

    fun readSingleData2(){
        FirebaseDatabase.getInstance().reference
            .child("user")
            .child("1")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    textView21?.text = map["brand"].toString()
                    textView33?.text = map["rank"].toString()
                    textView39?.text = map["price"].toString()
                    textView58?.text = map["cs"].toString()
                    textView54?.text = map["parallax"].toString()
                    textView64?.text = map["overall"].toString()
                }
            })
    }
}








