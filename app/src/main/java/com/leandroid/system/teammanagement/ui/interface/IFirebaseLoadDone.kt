package com.leandroid.system.teammanagement.ui.`interface`

import com.leandroid.system.teammanagement.model.TeamName

interface IFirebaseLoadDone {
    fun onFirebaseLoadSuccess(teamList: List<TeamName>)
    fun onFirebaseLoadFailed(message: String)
}