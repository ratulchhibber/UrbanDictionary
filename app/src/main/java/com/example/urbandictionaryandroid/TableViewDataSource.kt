package com.example.urbandictionaryandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//Adapter
class TableViewDataSource: RecyclerView.Adapter<TermCell>() {

    var terms = emptyList<Term>()

    //dequeueReUseIdentifier
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermCell {
        val termView = LayoutInflater.from(parent.context).inflate(R.layout.term_cell, parent, false)
        return TermCell(termView)
    }

    //numberOfRows
    override fun getItemCount(): Int = terms.size

    //cellForRowAt indexPath
    override fun onBindViewHolder(holder: TermCell, position: Int) {
        val term = terms[position]
        holder.wordLabel.text = term.word
        holder.definitionLabel.text = term.htmlDefinition
        holder.term = term
    }

    //reloadData
    fun update(terms: List<Term>) {
        this.terms = terms
        notifyDataSetChanged()
    }


}