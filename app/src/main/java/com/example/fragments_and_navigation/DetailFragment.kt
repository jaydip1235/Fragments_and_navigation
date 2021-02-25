package com.example.fragments_and_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.list_item.*


class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product: Product? = null

        val price : TextView = view.findViewById(R.id.price)
        var name : TextView = view.findViewById(R.id.name)
//        val id = arguments?.getInt("ID")
//        id?.let {
//            product = products.find { it.id == id }
//        }

        //using safeargs
        arguments?.let{
            val args = DetailFragmentArgs.fromBundle(it)
            product = products.find {args.id == it.id }
        }

        product?.let {
            with(it) {
                name.text = it.name
                price.text = "Price Rs ${it.price}"
                description.text = shortDescription
                product_full_description.text = longDescription
                image.setImageResource(imageId)
//
                buy.setOnClickListener {
//                    val bundle = Bundle()
//                    bundle.putInt("ID", this.id)
//                    findNavController().navigate(R.id.Checkout, bundle)

                    //using safeargs
                    findNavController().navigate(DetailFragmentDirections.actionDetailToCheckout(this.id))

                }
            }

        }
    }
}
