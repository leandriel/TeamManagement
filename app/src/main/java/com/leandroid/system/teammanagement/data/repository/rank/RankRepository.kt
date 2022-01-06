package com.leandroid.system.teammanagement.data.repository.rank

import com.leandroid.system.teammanagement.model.TableItem

class RankRepository {

     fun tableItemsMock() = mutableListOf(
        TableItem(1,"ESTRELLA DEL SUR",5,1,2,0,3,1,2,5),
        TableItem(2,"CRUZ DEL SUR",5,1,2,0,3,2,2,5),
        TableItem(3,"SAN CAYETANO",5,1,2,0,3,1,2,5),
        TableItem(4,"ARCO IRIS",5,1,2,0,3,1,2,5)
    )
}