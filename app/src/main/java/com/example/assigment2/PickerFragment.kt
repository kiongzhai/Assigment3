package com.example.assigment2


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
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
        val bt = z.findViewById<Button>(R.id.btnCalculate)

        var wattCpu = 0
        var wattMotherboard = 0
        var wattCpuCooler = 0
        var wattGraphicCard = 0
        var wattHarddisk = 0
        var wattPs = 0
        var wattRam = 0

        var selectedCpu = ""
        var selectedMotherboard = ""
        var selectedCpuCooler = ""
        var selectedGraphicCard = ""
        var selectedHarddisk = ""
        var selectedPs = ""
        var selectedRam = ""
        var isNotCompatible = false


        bt?.setOnClickListener {
            isNotCompatible = false
            var totalWatt = wattCpu + wattMotherboard + wattCpuCooler + wattGraphicCard + wattHarddisk + wattPs + wattRam
            tvWatt.setText("Expected Wattage: " + totalWatt.toString() + "W")

            if((selectedCpu.equals("1") && selectedMotherboard.equals("2")) || (selectedCpu.equals("1") && selectedMotherboard.equals("3"))
                || (selectedCpu.equals("1") && selectedRam.equals("1")) || (selectedCpu.equals("1") && selectedRam.equals("3"))
                || (selectedCpu.equals("2") && selectedMotherboard.equals("1")) || (selectedCpu.equals("2") && selectedMotherboard.equals("3"))
                || (selectedCpu.equals("2") && selectedRam.equals("1")) || (selectedCpu.equals("2") && selectedRam.equals("3"))
                || (selectedCpu.equals("3") && selectedMotherboard.equals("1")) || (selectedCpu.equals("3") && selectedMotherboard.equals("2"))
                || (selectedCpu.equals("3") && selectedRam.equals("1")) || (selectedCpu.equals("3") && selectedRam.equals("2"))
                || (selectedCpu.equals("3") && selectedHarddisk.equals("1"))

                || (selectedMotherboard.equals("1") && selectedRam.equals("1")) || (selectedMotherboard.equals("1") && selectedRam.equals("3"))
                || (selectedMotherboard.equals("2") && selectedRam.equals("1")) || (selectedMotherboard.equals("2") && selectedRam.equals("3"))
                || (selectedMotherboard.equals("3") && selectedRam.equals("1")) || (selectedMotherboard.equals("3") && selectedRam.equals("2"))
                || (selectedMotherboard.equals("3") && selectedHarddisk.equals("1"))
                || (selectedGraphicCard.equals("1") && selectedPs.equals("1")) || (selectedGraphicCard.equals("1") && selectedPs.equals("3"))
                || (selectedGraphicCard.equals("2") && selectedPs.equals("2")) ) isNotCompatible = true

            if(isNotCompatible) {
                tvCompatibility.setText("Not Compatible!")
                tvCompatibility.setBackgroundColor(Color.parseColor("#e74960"))
            }else{
                var x = ""
                Log.i(x, "Info about MySimpleAppActivity.");
                tvCompatibility.setText("Compatibality: No Issue")
                tvCompatibility.setBackgroundColor(Color.parseColor("#90ee90"))
            }
        }


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
                            wattCpu = 0
                            selectedCpu = ""
                            ivCpu.setImageResource(R.drawable.def)
                            tvPriceCpu.setText("")

                        }
                        1 -> {
                            selectedCpu = "1"
                            getCpu1()
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("CPU")
                                .child("cpu1")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattCpu = (map["watt"].toString()).toInt()
                                    }
                                })
                            ivCpu.setImageResource(R.drawable.cpu1)
                        }
                        2 -> {
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("CPU")
                                .child("cpu2")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattCpu = (map["watt"].toString()).toInt()
                                    }
                                })




                            selectedCpu = "2"
                            getCpu2()
                            ivCpu.setImageResource(R.drawable.cpu2)
                        }
                        3 -> {
                            selectedCpu = "3"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("CPU")
                                .child("cpu3")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattCpu = (map["watt"].toString()).toInt()
                                    }
                                })
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
                            selectedMotherboard = ""
                            wattMotherboard = 0
                            ivMotherboard.setImageResource(R.drawable.def)
                            tvPriceMotherboard.setText("")

                        }
                        1 -> {
                            selectedMotherboard = "1"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("Motherboard")
                                .child("motherboard1")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattMotherboard = (map["watt"].toString()).toInt()
                                    }
                                })
                            getMotherboard1()
                            ivMotherboard.setImageResource(R.drawable.motherboard1)
                        }
                        2 -> {
                            selectedMotherboard = "2"
                            getMotherboard2()
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("Motherboard")
                                .child("motherboard2")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattMotherboard = (map["watt"].toString()).toInt()
                                    }
                                })
                            ivMotherboard.setImageResource(R.drawable.motherboard2)
                        }
                        3 -> {
                            getMotherboard3()
                            selectedMotherboard = "3"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("Motherboard")
                                .child("motherboard3")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattMotherboard = (map["watt"].toString()).toInt()
                                    }
                                })
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
                            wattRam = 0
                            selectedRam = ""
                            ivRam.setImageResource(R.drawable.def)
                            tvPriceRam.setText("")

                        }
                        1 -> {
                            getRam1()
                            selectedRam = "1"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("Ram")
                                .child("ram1")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattRam = (map["watt"].toString()).toInt()
                                    }
                                })
                            ivRam.setImageResource(R.drawable.ram1)
                        }
                        2 -> {
                            getRam2()
                            selectedRam = "2"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("Ram")
                                .child("ram2")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattRam = (map["watt"].toString()).toInt()
                                    }
                                })
                            ivRam.setImageResource(R.drawable.ram2)
                        }
                        3 -> {
                            getRam3()
                            selectedRam = "3"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("Ram")
                                .child("ram3")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattRam = (map["watt"].toString()).toInt()
                                    }
                                })
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
                            selectedHarddisk = ""
                            wattHarddisk = 0
                            ivHarddisk.setImageResource(R.drawable.def)
                            tvPriceHarddisk.setText("")

                        }
                        1 -> {
                            getHarddisk1()
                            selectedHarddisk = "1"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("Harddisk")
                                .child("harddisk1")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattHarddisk = (map["watt"].toString()).toInt()
                                    }
                                })
                            ivHarddisk.setImageResource(R.drawable.harddisk1)
                        }
                        2 -> {
                            getHarddisk2()
                            selectedHarddisk = "2"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("Harddisk")
                                .child("harddisk2")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattHarddisk = (map["watt"].toString()).toInt()
                                    }
                                })
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
                            wattPs = 0
                            selectedPs = ""
                            ivPowerSupply.setImageResource(R.drawable.def)
                            tvPricePowerSupply.setText("")

                        }
                        1 -> {
                            getPs1()
                            selectedPs = "1"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("PowerSupply")
                                .child("powerSupply1")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattPs = (map["watt"].toString()).toInt()
                                    }
                                })
                            ivPowerSupply.setImageResource(R.drawable.ps1)
                        }
                        2 -> {
                            getPs2()
                            selectedPs = "2"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("PowerSupply")
                                .child("powerSupply2")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattPs = (map["watt"].toString()).toInt()
                                    }
                                })
                            ivPowerSupply.setImageResource(R.drawable.ps2)
                        }
                        3 -> {
                            getPs3()
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("PowerSupply")
                                .child("powerSupply3")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattPs = (map["watt"].toString()).toInt()
                                    }
                                })
                            selectedPs = "3"
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
                            selectedGraphicCard = ""
                            wattGraphicCard = 0
                            ivGraphicCard.setImageResource(R.drawable.def)
                            tvPriceGraphicCard.setText("")

                        }
                        1 -> {
                            getGpu1()
                            selectedGraphicCard = "1"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("GraphicCard")
                                .child("graphicCard1")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattGraphicCard = (map["watt"].toString()).toInt()
                                    }
                                })
                            ivGraphicCard.setImageResource(R.drawable.gpu1)
                        }
                        2 -> {
                            selectedGraphicCard = "2"
                            getGpu2()
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("GraphicCard")
                                .child("graphicCard2")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattGraphicCard = (map["watt"].toString()).toInt()
                                    }
                                })
                            ivGraphicCard.setImageResource(R.drawable.gpu2)
                        }
                        3 -> {
                            getGpu3()
                            selectedGraphicCard = "3"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("GraphicCard")
                                .child("graphicCard3")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattGraphicCard = (map["watt"].toString()).toInt()
                                    }
                                })
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
                            wattCpuCooler = 0
                            selectedCpuCooler = ""
                            ivCpuCooler.setImageResource(R.drawable.def)
                            tvPriceCpuCooler.setText("")

                        }
                        1 -> {
                            getCpuCooler1()
                            selectedCpuCooler = "1"
                            FirebaseDatabase.getInstance().reference
                                .child("Items")
                                .child("CpuCooler")
                                .child("cpuCooler1")
                                .addListenerForSingleValueEvent(object : ValueEventListener {
                                    override fun onCancelled(p0: DatabaseError) {

                                    }
                                    override fun onDataChange(p0: DataSnapshot) {
                                        var map = p0.value as Map<String,Any>
                                        wattCpuCooler = (map["watt"].toString()).toInt()
                                    }
                                })
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
