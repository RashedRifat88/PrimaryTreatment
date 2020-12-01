package com.egsystem.primarytreatment.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "first_aid_item_table")
data class FirstAidItemEntity(


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "column_id")
    var id: Int,

    @ColumnInfo(name = "column_item_name")
    var item_name: String,

    @ColumnInfo(name = "column_sub_item_name")
    var sub_item_name: String,


    @ColumnInfo(name = "column_micro_item_name")
    var micro_item_name: String,


    @ColumnInfo(name = "column_item_img_url")
    var item_img_url: String,

    @ColumnInfo(name = "column_sub_item_img_url")
    var sub_item_img_url: String,


    @ColumnInfo(name = "column_micro_item_img_url")
    var micro_item_img_url: String,


    @ColumnInfo(name = "column_micro_item_details")
    var micro_item_details: String


)