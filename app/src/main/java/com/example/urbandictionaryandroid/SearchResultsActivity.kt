package com.example.urbandictionaryandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search_result.*

class SearchResultsActivity : AppCompatActivity() {

    private val networking = NetworkingService()
    private val dataSource = TableViewDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

       // tableView
        tableView.layoutManager = LinearLayoutManager(this)
        tableView.adapter = dataSource

        val term = intent.getStringExtra(MainActivity.searchKey)
        supportActionBar?.title = term
        getSearchResultsForTerm(term)
    }

    private fun getSearchResultsForTerm(term: String) {
        networking.defineTerm(term).observe(this, Observer { terms ->
            terms.forEach { println(it) }
            dataSource.update(terms)
        })
    }
}