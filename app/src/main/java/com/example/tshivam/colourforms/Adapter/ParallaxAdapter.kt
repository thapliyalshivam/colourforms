package com.example.tshivam.colourforms.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tshivam.colourforms.R
import kotlinx.android.synthetic.main.carousel_card.view.*


public class ParallaxAdapter(val context: Context) : RecyclerView.Adapter<ViewHoldercard>(){

    var myList: MutableList<String> = mutableListOf<String>("dsf","sdfs","sdfdsfsd")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldercard {
        return ViewHoldercard(LayoutInflater.from(context).inflate(R.layout.carousel_card, parent, false))
    }

    override fun getItemCount(): Int =myList.size

//
//    public fun setdata() {
//items.push
//    }

    override fun onBindViewHolder(vv: ViewHoldercard, p1: Int) {
        vv?.large?.text = myList.get(p1)
        vv?.mini?.text = "yoyo"
    }
}



class ViewHoldercard(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

    var large = view.card_jumbo_large
    var mini = view.card_jumbo_mini
    // Holds the TextView that will add each animal to
}