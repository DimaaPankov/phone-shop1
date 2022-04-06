package ru.skillbranch.phone_shop.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import coil.load
import ru.skillbranch.phone_shop.R
import ru.skillbranch.phone_shop.databinding.FragmentSecondBinding

import ru.skillbranch.phone_shop.ViewModel.OverviewViewModel


//
class SecondFragment : Fragment() {
lateinit var binding: FragmentSecondBinding

  lateinit var viewModel:OverviewViewModel
    var i = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(OverviewViewModel::class.java)

        setData()
        clickCategory()

        }


    private fun clickCategory(){

        binding.imgCricle1.setOnClickListener{
            binding.imgCricle1.setImageResource(R.drawable.img_orange_circle)
            binding.imgCricle2.setImageResource(R.drawable.img8)
            binding.imgCricle3.setImageResource(R.drawable.img8)
            binding.imgCricle4.setImageResource(R.drawable.img8)
        }
        binding.imgCricle2.setOnClickListener{
            binding.imgCricle1.setImageResource(R.drawable.img8)
            binding.imgCricle2.setImageResource(R.drawable.img_orange_circle)
            binding.imgCricle3.setImageResource(R.drawable.img8)
            binding.imgCricle4.setImageResource(R.drawable.img8)
        }
        binding.imgCricle3.setOnClickListener{
            binding.imgCricle1.setImageResource(R.drawable.img8)
            binding.imgCricle2.setImageResource(R.drawable.img8)
            binding.imgCricle3.setImageResource(R.drawable.img_orange_circle)
            binding.imgCricle4.setImageResource(R.drawable.img8)
        }
        binding.imgCricle4.setOnClickListener{
            binding.imgCricle1.setImageResource(R.drawable.img8)
            binding.imgCricle2.setImageResource(R.drawable.img8)
            binding.imgCricle3.setImageResource(R.drawable.img8)
            binding.imgCricle4.setImageResource(R.drawable.img_orange_circle)
        }

    }

    private fun setData() {
        //title
        viewModel.photos.observe(viewLifecycleOwner) { jsonData ->
            binding.tvBSTitle1.text = jsonData.bestSeller.getOrNull(0)?.title
            binding.tvBSTitle2.text = jsonData.bestSeller.getOrNull(1)?.title
            binding.tvBSTitle3.text = jsonData.bestSeller.getOrNull(2)?.title
            binding.tvBSTitle4.text = jsonData.bestSeller.getOrNull(3)?.title

            //image best seilers
            binding.imgBSImage1.load(jsonData.bestSeller.getOrNull(0)?.picture)
            binding.imgBSImage2.load(jsonData.bestSeller.getOrNull(1)?.picture)
            binding.imgBSImage3.load(jsonData.bestSeller.getOrNull(2)?.picture)
            binding.imgBSImage4.load(jsonData.bestSeller.getOrNull(3)?.picture)

            //price without discount "
            binding.tvBSPriceWithoutDiscount1.text =
                jsonData.bestSeller.getOrNull(0)?.price_without_discount.toString()
            binding.tvBSPriceWithoutDiscount2.text =
                jsonData.bestSeller.getOrNull(1)?.price_without_discount.toString()
            binding.tvBSPriceWithoutDiscount3.text =
                jsonData.bestSeller.getOrNull(2)?.price_without_discount.toString()
            binding.tvBSPriceWithoutDiscount4.text =
                jsonData.bestSeller.getOrNull(3)?.price_without_discount.toString()

            //discount price
            binding.tvBSDiscountPrice1.text =
                jsonData.bestSeller.getOrNull(0)?.discount_price.toString()
            binding.tvBSDiscountPrice2.text =
                jsonData.bestSeller.getOrNull(1)?.discount_price.toString()
            binding.tvBSDiscountPrice3.text =
                jsonData.bestSeller.getOrNull(2)?.discount_price.toString()
            binding.tvBSDiscountPrice4.text =
                jsonData.bestSeller.getOrNull(3)?.discount_price.toString()

            //image hot silers
            binding.imgHT.load(jsonData.home_store.get(0).picture)
            binding.tvHTtitle.text = jsonData.home_store.get(0).title
            binding.tvHSsubtitle.text = jsonData.home_store.get(0).subtitle

            binding.TVseeMore.setOnClickListener {
                if (i == 0) {

                    binding.imgHT.load(jsonData.home_store.get(i).picture)
                    binding.tvHTtitle.text = jsonData.home_store.get(i).title
                    binding.tvHSsubtitle.text = jsonData.home_store.get(i).subtitle
                    ++i
                } else if (i == 1) {

                    binding.imgHT.load(jsonData.home_store.get(i).picture)
                    binding.tvHTtitle.isVisible = false
                    binding.tvHTtitle.text = jsonData.home_store.get(i).title
                    binding.tvHSsubtitle.text = jsonData.home_store.get(i).subtitle
                    ++i
                } else if (i == 2) {
                    binding.imgHT.load(jsonData.home_store.get(i).picture)
                    binding.tvHTtitle.isVisible = true
                    binding.tvHTtitle.text = jsonData.home_store.get(i).title
                    binding.tvHSsubtitle.text = jsonData.home_store.get(i).subtitle
                    i = 0
                }
            }

        }
    }}