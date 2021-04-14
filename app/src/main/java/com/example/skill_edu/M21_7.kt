package com.example.skill_edu

import android.graphics.Color.green
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item2.view.*
import kotlinx.android.synthetic.main.m21.*
import kotlinx.android.synthetic.main.m21_7.*

class M21_7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m21_7)

        val pagerAdapter = ViewPagerAdapter()

        paging1.adapter = pagerAdapter

        val pagerItems = listOf<PagerItem>(
            PagerItem(ContextCompat.getColor(this, R.color.red), "Red"),
            PagerItem(ContextCompat.getColor(this, R.color.green), "Green"),
            PagerItem(ContextCompat.getColor(this, R.color.yellow), "Yellow")
        )
        pagerAdapter.setItems(pagerItems)
    }
}


data class PagerItem(val color: Int, val text: String)

class PagerViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val items = mutableListOf<PagerItem>()

    fun onBind(item: PagerItem) {
        itemView.container2.setBackgroundColor(item.color)
        itemView.textView1.text = item.text
    }
}
class ViewPagerAdapter : RecyclerView.Adapter<PagerViewHolder>() {

    private val items = mutableListOf<PagerItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder = PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item2, parent, false))

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) = holder.onBind(items[position])

    override fun getItemCount(): Int = items.size

    fun setItems(list: List<PagerItem>) {
        items.clear()
        items.addAll(list)
    }

}