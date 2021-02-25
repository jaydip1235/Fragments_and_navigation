package com.example.fragments_and_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //findViewById can be replaced with the widget id directly


        val genlist = generateList(4)
        val productList = view.findViewById<RecyclerView>(R.id.product_list)



        productList.adapter = ProductAdapter(genlist)

//        product?.let{
//            val bundle = Bundle()
//            bundle.putInt("ID", it.id)
//            findNavController().navigate(R.id.Detail, bundle)
//        }






        productList.layoutManager = LinearLayoutManager(activity)


//        val productList = view.findViewById<RecyclerView>(R.id.product_list).apply {
//
//
//            layoutManager = LinearLayoutManager(activity)
//
//            adapter = ProductAdapter{
//
//                val bundle = Bundle()
//                bundle.putInt("ID", it.id)
//                findNavController().navigate(R.id.Detail, bundle)
//
//                //findNavController().navigate(R.id.action_home_to_detail, bundle)
//            }
//            setHasFixedSize(true)
//        }
//        (productList.adapter as ProductAdapter).submitList(products)
    }
    fun generateList(size:Int) : List<Product>{
        val list = ArrayList<Product>()

        for(i in 0 until size){
            val imageId : Int = products[i].imageId
            val id : Int = products[i].id
            val name : String = products[i].name
            val price : Int = products[i].price
            val shortDescription : String = products[i].shortDescription
            val longDescription  : String = products[i].longDescription

            val item = Product(id, name, price, imageId, shortDescription, longDescription)
            list.add(item)
        }
        return list
    }
}

