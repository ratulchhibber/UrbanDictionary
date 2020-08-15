package com.example.urbandictionaryandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_word_definition.*
import kotlinx.android.synthetic.main.term_cell.*
import kotlinx.android.synthetic.main.term_cell.definition

class WordDefinitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_definition)

        val term = intent.getSerializableExtra(TermCell.termKey) as? Term
        term?.let {
            supportActionBar?.title = it.word

            definition.text = it.htmlDefinition
            likesLabel.text = "Likes: ${it.likes}"
            disLikesLabel.text = "Dislikes: ${it.dislikes}"
        }
    }
}
