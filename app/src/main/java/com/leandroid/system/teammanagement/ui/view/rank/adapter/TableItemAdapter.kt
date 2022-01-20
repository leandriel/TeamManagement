package com.leandroid.system.teammanagement.ui.view.rank.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandroid.system.teammanagement.databinding.ItemTableRankBinding
import com.leandroid.system.teammanagement.model.TableItem

class TableItemAdapter: RecyclerView.Adapter<TableItemAdapter.TableItemHolder>() {
    private var items : MutableList<TableItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableItemHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTableRankBinding.inflate(layoutInflater, parent, false)
        return TableItemHolder(binding)
    }

    fun setItems(itemsList : MutableList<TableItem>){
        items = itemsList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TableItemHolder, position: Int) {
        holder.render(items[position])
    }

    class TableItemHolder(private val binding: ItemTableRankBinding): RecyclerView.ViewHolder(binding.root) {

        fun render(tableItem: TableItem) {
            with(binding) {
                tvTablePos.text = tableItem.pos.toString()
                tvTableTeam.text = tableItem.team
                tvTablePoint.text = tableItem.points.toString()
                tvTablePlayedMatches.text = tableItem.played.toString()
                tvTableWonMatches.text = tableItem.won.toString()
                tvTableTiedMatches.text = tableItem.tie.toString()
                tvTableLostMatches.text = tableItem.lost.toString()
                tvTableGoalsFavor.text = tableItem.gf.toString()
                tvTableGoalsAgainst.text = tableItem.gc.toString()
                tvTableGoalsDifferences.text = tableItem.dif.toString()
            }
        }
    }







}