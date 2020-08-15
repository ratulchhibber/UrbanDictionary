package com.example.urbandictionaryandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//viewDidLoad
    //Orientation change - activity gets recreated again

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//loadView
        setContentView(R.layout.activity_main)//this activity we want to reference

        searchButton.setOnClickListener {
            println("Ratul ${textField.text}")
            navigateToSearchResultsForWord(textField.text.toString())
        }
    }

    private fun navigateToSearchResultsForWord(word: String) {
        //let intent = Intent(self, SearchResultsViewController.self)
        val intent = Intent(this, SearchResultsActivity:: class.java)
        intent.putExtra(searchKey, word)
        startActivity(intent)
    }

    companion object {
        const val searchKey = "searchKey"
    }
}
