package com.leandroid.system.teammanagement.ui.view.rank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandroid.system.teammanagement.data.repository.rank.RankRepository
import com.leandroid.system.teammanagement.model.TableItem

class RankViewModel constructor(private val repository: RankRepository = RankRepository()): ViewModel() {

    val tableItems: LiveData<MutableList<TableItem>>
    get() = _tableItems
    private val _tableItems = MutableLiveData<MutableList<TableItem>>()

    init {
        getTableItems()
    }

    private fun getTableItems(){
        val items = repository.tableItemsMock()
        _tableItems.value = items
    }
}