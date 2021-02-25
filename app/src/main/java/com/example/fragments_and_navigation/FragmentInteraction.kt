package com.example.fragments_and_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class FragmentInteraction : AppCompatActivity() , BlankFragment.OnMessageClickListener {

    var showFragmentMessage : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment = BlankFragment()

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_container, fragment, "BlankFragment")
        fragmentTransaction.commit()

        showFragmentMessage = findViewById(R.id.show_fragment_message)
        showFragmentMessage!!.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.main_container) as BlankFragment
            fragment.showFragmentMessage()
        }
    }


    override fun onMessageClick() {
        showActivityMessage()
    }

    fun showActivityMessage(){
        Toast.makeText(this, "This message is from Activity", Toast.LENGTH_SHORT).show()
    }
}
