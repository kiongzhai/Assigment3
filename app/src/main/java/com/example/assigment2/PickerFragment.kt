package com.example.assigment2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import kotlinx.android.synthetic.main.fragment_compare.*
import kotlinx.android.synthetic.main.fragment_picker.*

/**
 * A simple [Fragment] subclass.
 */
class PickerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val z = inflater.inflate(R.layout.fragment_picker, container, false)
        val spinner4 = z.findViewById<Spinner>(R.id.spinner4)
        spinner4?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spinner4) {
                    when (position) {
                        0 -> {
                            textView4.setText("hello")
                        }
                        1 -> {
                            textView4.setText("bye")
                        }

                    }
                }

            }
        }
        return z
    }


}
