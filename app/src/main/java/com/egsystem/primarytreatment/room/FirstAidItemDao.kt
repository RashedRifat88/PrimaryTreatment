package com.egsystem.primarytreatment.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FirstAidItemDao {

    @Insert
    fun insertData(data: FirstAidItemEntity)


    @Query("select * from first_aid_item_table order by column_item_name")
    fun getAllData(): List<FirstAidItemEntity>


    @Query("select column_item_name from first_aid_item_table")
    fun getAllItem(): List<String>



}