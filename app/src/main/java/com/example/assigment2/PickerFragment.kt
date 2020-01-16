package com.example.assigment2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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
        val spnCpu = z.findViewById<Spinner>(R.id.spnCpu)
        val spnMotherboard = z.findViewById<Spinner>(R.id.spnMotherboard)
        val spnRam = z.findViewById<Spinner>(R.id.spnRam)
        val spnHarddisk = z.findViewById<Spinner>(R.id.spnHarddisk)
        val spnPowerSupply = z.findViewById<Spinner>(R.id.spnPowerSupply)
        val spnGraphicCard = z.findViewById<Spinner>(R.id.spnGraphicCard)
        val spnCpuCooler = z.findViewById<Spinner>(R.id.spnCpuCooler)

        spnCpu?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spnCpu) {
                    when (position) {
                        0 -> {

                        }
                        1 -> {
                            getCpu1()
                            ivCpu.setImageResource(R.drawable.cpu1)
                        }
                        2 -> {
                            getCpu2()
                            ivCpu.setImageResource(R.drawable.cpu2)
                        }
                        3 -> {
                            getCpu3()
                            ivCpu.setImageResource(R.drawable.cpu3)
                        }

                    }
                }

            }
        }

        spnMotherboard?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spnMotherboard) {
                    when (position) {
                        0 -> {

                        }
                        1 -> {
                            getMotherboard1()
                            ivMotherboard.setImageResource(R.drawable.motherboard1)
                        }
                        2 -> {
                            getMotherboard2()
                            ivMotherboard.setImageResource(R.drawable.motherboard2)
                        }
                        3 -> {
                            getMotherboard3()
                            ivMotherboard.setImageResource(R.drawable.motherboard3)
                        }

                    }
                }

            }
        }

        spnRam?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spnRam) {
                    when (position) {
                        0 -> {

                        }
                        1 -> {
                            getRam1()
                            ivRam.setImageResource(R.drawable.ram1)
                        }
                        2 -> {
                            getRam2()
                            ivRam.setImageResource(R.drawable.ram2)
                        }
                        3 -> {
                            getRam3()
                            ivRam.setImageResource(R.drawable.ram3)
                        }

                    }
                }

            }
        }

        spnHarddisk?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spnHarddisk) {
                    when (position) {
                        0 -> {

                        }
                        1 -> {
                            getHarddisk1()
                            ivHarddisk.setImageResource(R.drawable.harddisk1)
                        }
                        2 -> {
                            getHarddisk2()
                            ivHarddisk.setImageResource(R.drawable.harddisk2)
                        }

                    }
                }

            }
        }

        spnPowerSupply?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spnPowerSupply) {
                    when (position) {
                        0 -> {

                        }
                        1 -> {
                            getPs1()
                            ivPowerSupply.setImageResource(R.drawable.ps1)
                        }
                        2 -> {
                            getPs2()
                            ivPowerSupply.setImageResource(R.drawable.ps2)
                        }
                        3 -> {
                            getPs3()
                            ivPowerSupply.setImageResource(R.drawable.ps3)
                        }

                    }
                }

            }
        }

        spnGraphicCard?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spnGraphicCard) {
                    when (position) {
                        0 -> {

                        }
                        1 -> {
                            getGpu1()
                            ivGraphicCard.setImageResource(R.drawable.gpu1)
                        }
                        2 -> {
                            getGpu2()
                            ivGraphicCard.setImageResource(R.drawable.gpu2)
                        }
                        3 -> {
                            getGpu3()
                            ivGraphicCard.setImageResource(R.drawable.gpu3)
                        }

                    }
                }

            }
        }

        spnCpuCooler?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getId() == R.id.spnCpuCooler) {
                    when (position) {
                        0 -> {

                        }
                        1 -> {
                            getCpuCooler1()
                            ivCpuCooler.setImageResource(R.drawable.cooler1)
                        }


                    }
                }

            }
        }

        return z
    }

    fun getHarddisk1(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("Harddisk")
            .child("harddisk1")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceHarddisk.text = map["price"].toString()
                }
            })
    }

    fun getHarddisk2(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("Harddisk")
            .child("harddisk2")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceHarddisk.text = map["price"].toString()
                }
            })
    }

    fun getPs1(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("PowerSupply")
            .child("powerSupply1")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPricePowerSupply.text = map["price"].toString()
                }
            })
    }

    fun getPs2(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("PowerSupply")
            .child("powerSupply2")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPricePowerSupply.text = map["price"].toString()
                }
            })
    }

    fun getPs3(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("PowerSupply")
            .child("powerSupply3")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPricePowerSupply.text = map["price"].toString()
                }
            })
    }

    fun gerHarddisk1(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("Harddisk")
            .child("harddisk1")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceHarddisk.text = map["price"].toString()
                }
            })
    }

    fun gerHarddisk2(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("Harddisk")
            .child("harddisk2")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceHarddisk.text = map["price"].toString()
                }
            })
    }

    fun getRam1(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("Ram")
            .child("ram1")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceRam.text = map["price"].toString()
                }
            })
    }

    fun getRam2(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("Ram")
            .child("ram2")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceRam.text = map["price"].toString()
                }
            })
    }

    fun getRam3(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("Ram")
            .child("ram3")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceRam.text = map["price"].toString()
                }
            })
    }

    fun getGpu1(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("GraphicCard")
            .child("graphicCard1")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceGraphicCard.text = map["price"].toString()
                }
            })
    }

    fun getGpu2(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("GraphicCard")
            .child("graphicCard2")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceGraphicCard.text = map["price"].toString()
                }
            })
    }

    fun getGpu3(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("GraphicCard")
            .child("graphicCard3")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceGraphicCard.text = map["price"].toString()
                }
            })
    }

    fun getCpuCooler1(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("CpuCooler")
            .child("cpuCooler1")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceCpuCooler.text = map["price"].toString()
                }
            })
    }

    fun getMotherboard1(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("Motherboard")
            .child("motherboard1")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceMotherboard.text = map["price"].toString()
                }
            })
    }

    fun getMotherboard2(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("Motherboard")
            .child("motherboard2")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceMotherboard.text = map["price"].toString()
                }
            })
    }

    fun getMotherboard3(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("Motherboard")
            .child("motherboard3")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceMotherboard.text = map["price"].toString()
                }
            })
    }



    fun getCpu1(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("CPU")
            .child("cpu1")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceCpu.text = map["price"].toString()
                }
            })
    }

    fun getCpu2(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("CPU")
            .child("cpu2")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceCpu.text = map["price"].toString()
                }
            })
    }

    fun getCpu3(){
        FirebaseDatabase.getInstance().reference
            .child("Items")
            .child("CPU")
            .child("cpu3")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }
                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String,Any>
                    tvPriceCpu.text = map["price"].toString()
                }
            })
    }


}
