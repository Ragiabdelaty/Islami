package com.example.islami

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.databinding.FragmentAhadithBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Serializable


class AhadithFragment : Fragment() {

    lateinit var binding4: FragmentAhadithBinding

    var myHadeths_array = mutableListOf<HadethsM>()

    lateinit var hadeths: customhadethsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding4 = FragmentAhadithBinding.inflate(layoutInflater, container, false)
        return binding4.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        read_Ahadiths()

        initRecycleV()

    }

    private fun initRecycleV() {
        hadeths = customhadethsAdapter(myHadeths_array)
        hadeths.myReferenceinterface = object : customhadethsAdapter.myLisnter {
            override fun onClick(hadeths: HadethsM, index: Int) {

                var intent = Intent(activity, Ahadethdetails::class.java)

                intent.putExtra("key",hadeths)


                startActivity(intent)

            }


        }


        binding4.recycle.adapter = hadeths

    }


    fun read_Ahadiths() {
        try {
            var inputstream = requireActivity().assets.open("ahadeeth.txt")
            val Reader = BufferedReader(InputStreamReader(inputstream))
            var hadethsfilecontent: String = Reader.readText()

            var hadethList: List<String> = hadethsfilecontent.split("#")


            for (onehadeth: String in hadethList) {

                var onehadethwithoutspace = onehadeth.trim()


                var singlehadethslines: MutableList<String> =
                    onehadethwithoutspace.split("\n").toMutableList()


                var hadethstitle = singlehadethslines[0]


                singlehadethslines.removeAt(0)
                var content = singlehadethslines.joinToString(separator = " ") {
                    return@joinToString it

                }

                myHadeths_array.add(HadethsM(title = hadethstitle, content = content))

            }

            inputstream.close()


        } catch (e: Exception) {


        }


    }



    data class HadethsM(var title: String, var content: String):Serializable
}
