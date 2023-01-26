package com.kampusmerdeka.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Images>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(

            R.drawable.descendants_of_the_sun,
            R.drawable.vincenzo,
            R.drawable.goblin,
            R.drawable.start_up,
            R.drawable.itsok_to_notbeok

        )

        heading = arrayOf(

            "Descendants of the Sun\n2016 ‧ Drama ‧ 1 season",
            "Vincenzo\n2021 ‧ Kejahatan ‧ 1 season",
            "Guardian: The Lonely and Great God\n2016 ‧ Drama ‧ 1 season",
            "Start-Up\n2020 ‧ Roman ‧ 1 season",
            "It's Okay to Not Be Okay\n2020 ‧ Komedi ‧ 1 season"

        )

        newRecyclerView = findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Images>()
        getUserData()

    }

    private  fun getUserData() {

        for (i in imageId.indices){

            val imgs = Images(imageId[i],heading[i])
            newArrayList.add(imgs)

        }

        newRecyclerView.adapter = MyAdapter(newArrayList)

    }
}