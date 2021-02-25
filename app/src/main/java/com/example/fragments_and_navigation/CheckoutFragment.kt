package com.example.fragments_and_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_checkout.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.list_item.*
import kotlinx.android.synthetic.main.list_item.image


class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product: Product? = null

        val price : TextView = view.findViewById(R.id.price)
        //var name : TextView? = view.findViewById(R.id.name)
//        val id = arguments?.getInt("ID")
//        id?.let {
//            product = products.find { it.id == id }
//        }

        //using safeargs
        arguments?.let{
            val args = CheckoutFragmentArgs.fromBundle(it)
            product = products.find {args.id == it.id }
        }


        product?.let {
            with(it) {
              //  name.text = it.name
                price.text = "Price Rs ${it.price}"
                order_total.text = "Order total is Rs ${it.price}"
                //product_full_description.text = longDescription
                image.setImageResource(imageId)
//
                checkout.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putInt("ID", this.id)
                    findNavController().navigate(R.id.Thanks, bundle)
                    //findNavController().navigate(DetailFragmentDirections.actionDetailToCheckout(this.id))

                }
            }

        }
    }
}




