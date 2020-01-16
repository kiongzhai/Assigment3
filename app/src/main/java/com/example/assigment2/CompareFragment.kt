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

    val types = arrayOf("simple User", "Admin")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val t = inflater.inflate(R.layout.fragment_compare, container, false)
        val spinner = t.findViewById<Spinner>(R.id.spinner)
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("erreur")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spinner) {
                    when (position) {
                        0 -> textView21.setText("OTHERS")
                        1 -> textView21.setText("OTHERS")
                        2 -> textView21.setText("OTHERS")
                    }
                }
            }
        }
        return t
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}








