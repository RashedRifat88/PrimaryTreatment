package com.egsystem.primarytreatment.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.egsystem.primarytreatment.R
import com.egsystem.primarytreatment.room.FirstAidItemDao
import com.egsystem.primarytreatment.room.FirstAidItemEntity
import com.egsystem.primarytreatment.ui.home.adapter.SubItemAdapter
import com.egsystem.roomkot.FirstAidItemDatabase

class HomeFragment : Fragment() {


    private val texts = arrayOf("Special Noodles","Veg Biryani","Veg Sandwich","Pizza Friday","Pancakes")
    private val desc = arrayOf("non veg","pure veg","pure veg","customizable","pure veg")
    private val img = arrayOf(R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a)


    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val context: Context = requireContext()

        init(root, context)


        var database: FirstAidItemDao = FirstAidItemDatabase.getDatabase(context).getDao()
        val getDataThread = Thread {
            Log.d("tagRifat","All Data: "+ database.getAllData())
        }
        getDataThread.start()

        return root
    }


    private fun init(view: View, context: Context) {

            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = SubItemAdapter(img,texts,desc)
    }


    private fun loadFragment(fragment: Fragment){
//        val context: Context = requireContext()
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl1, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }





//    private fun loadDatabaseAndData() {
//        var database: FirstAidItemDao = FirstAidItemDatabase.getDatabase(context).getDao()
//
//
//        val getDataThread = Thread {
//            Log.d("tagRifat","All Data: "+ database.getAllData())
//        }
//        getDataThread.start()
//    }



}
