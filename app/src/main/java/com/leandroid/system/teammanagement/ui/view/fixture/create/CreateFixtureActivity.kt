package com.leandroid.system.teammanagement.ui.view.fixture.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.firebase.database.*
import com.leandroid.system.teammanagement.R
import com.leandroid.system.teammanagement.data.network.FirebaseManager
import com.leandroid.system.teammanagement.model.TeamName
import com.leandroid.system.teammanagement.ui.`interface`.IFirebaseLoadDone

class CreateFixtureActivity : AppCompatActivity(), IFirebaseLoadDone {

    override fun onFirebaseLoadSuccess(teamList: List<TeamName>) {
        val teamNameList = getTeamList(teamList)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamNameList)
        val spinnerTeamLocal = findViewById<Spinner>(R.id.spinnerTeamNameLocal)
        spinnerTeamLocal.adapter = adapter
        val spinnerTeamVisite = findViewById<Spinner>(R.id.spinnerTeamNameVisit)
        spinnerTeamVisite.adapter = adapter

    }

    private fun getTeamList(teamList: List<TeamName>):List<String>{
        val result = ArrayList<String>()
        for (team in teamList)
            result.add(team.name!!)
        return result
    }

    override fun onFirebaseLoadFailed(message: String) {
        val f =  FirebaseManager()
    }

    private val teamRef : DatabaseReference = FirebaseDatabase.getInstance().getReference("teams")
    lateinit var iFirebaseLoadDone : IFirebaseLoadDone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_fixture)

        iFirebaseLoadDone = this

        teamRef.addValueEventListener(object: ValueEventListener{
            var teamList: MutableList<TeamName> = ArrayList()
            override fun onDataChange(snapshot: DataSnapshot) {
                for(teamSnapshot in snapshot.children) {
                    teamSnapshot.getValue(TeamName::class.java)?.run {
                        teamList.add(this)
                    }
                }
                iFirebaseLoadDone.onFirebaseLoadSuccess(teamList)
            }

            override fun onCancelled(error: DatabaseError) {
                iFirebaseLoadDone.onFirebaseLoadFailed(error.message) }

        })
    }
}