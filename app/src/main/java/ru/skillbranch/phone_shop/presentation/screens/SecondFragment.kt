package ru.skillbranch.phone_shop.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import coil.load
import ru.skillbranch.phone_shop.MAIN
import ru.skillbranch.phone_shop.R
import ru.skillbranch.phone_shop.databinding.FragmentSecondBinding
import ru.skillbranch.phone_shop.viewmodel.MainViewModel


class SecondFragment(val domain: MainViewModel = MainViewModel()) : Fragment() {

    lateinit var binding: FragmentSecondBinding


    lateinit var viewModel:MainViewModel


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

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setData()
        clickCategory()

        }

private fun checkErorConnect (status:Boolean){ if(status){
    binding.FLeror.visibility = VISIBLE
}
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
        var indexHotSilers = 1
        checkErorConnect (domain.getDataBestSeller()?.getOrNull(0)?.title==null)

        //title
        viewModel.data.observe(viewLifecycleOwner) {

            binding.tvBSTitle1.text = domain.getDataBestSeller()?.getOrNull(0)?.title
            binding.tvBSTitle2.text = domain.getDataBestSeller()?.getOrNull(1)?.title
            binding.tvBSTitle3.text = domain.getDataBestSeller()?.getOrNull(2)?.title
            binding.tvBSTitle4.text = domain.getDataBestSeller()?.getOrNull(3)?.title

            //image best seilers
            binding.imgBSImage1.load(domain.getDataBestSeller()?.getOrNull(0)?.picture)
            binding.imgBSImage2.load(domain.getDataBestSeller()?.getOrNull(1)?.picture)
            binding.imgBSImage3.load(domain.getDataBestSeller()?.getOrNull(2)?.picture)
            binding.imgBSImage4.load(domain.getDataBestSeller()?.getOrNull(3)?.picture)

            //price without discount "
            binding.tvBSPriceWithoutDiscount1.text =
                domain.getDataBestSeller()?.getOrNull(0)?.price_without_discount.toString()
            binding.tvBSPriceWithoutDiscount2.text =
                domain.getDataBestSeller()?.getOrNull(1)?.price_without_discount.toString()
            binding.tvBSPriceWithoutDiscount3.text =
                domain.getDataBestSeller()?.getOrNull(2)?.price_without_discount.toString()
            binding.tvBSPriceWithoutDiscount4.text =
                domain.getDataBestSeller()?.getOrNull(3)?.price_without_discount.toString()

            //discount price
            binding.tvBSDiscountPrice1.text =
                domain.getDataBestSeller()?.getOrNull(0)?.discount_price.toString()
            binding.tvBSDiscountPrice2.text =
                domain.getDataBestSeller()?.getOrNull(1)?.discount_price.toString()
            binding.tvBSDiscountPrice3.text =
                domain.getDataBestSeller()?.getOrNull(2)?.discount_price.toString()
            binding.tvBSDiscountPrice4.text =
                domain.getDataBestSeller()?.getOrNull(3)?.discount_price.toString()

            //image hot silers
            binding.imgHT.load(domain.getDataHome_store()?.get(0)?.picture)
            binding.tvHTtitle.text = domain.getDataHome_store()?.get(0)?.title
            binding.tvHSsubtitle.text = domain.getDataHome_store()?.get(0)?.subtitle

            binding.TVseeMore.setOnClickListener {
                if (indexHotSilers == 0) {

                    binding.imgHT.load(domain.getDataHome_store()?.get(indexHotSilers)?.picture)
                    binding.tvHTtitle.text = domain.getDataHome_store()?.get(indexHotSilers)?.title
                    binding.tvHSsubtitle.text = domain.getDataHome_store()?.get(indexHotSilers)?.subtitle
                    ++indexHotSilers
                } else if (indexHotSilers == 1) {

                    binding.imgHT.load(domain.getDataHome_store()?.get(indexHotSilers)?.picture)
                    binding.tvHTtitle.isVisible = false
                    binding.tvHTtitle.text = domain.getDataHome_store()?.get(indexHotSilers)?.title
                    binding.tvHSsubtitle.text = domain.getDataHome_store()?.get(indexHotSilers)?.subtitle
                    ++indexHotSilers
                } else if (indexHotSilers == 2) {
                    binding.imgHT.load(domain.getDataHome_store()?.get(indexHotSilers)?.picture)
                    binding.tvHTtitle.isVisible = true
                    binding.tvHTtitle.text = domain.getDataHome_store()?.get(indexHotSilers)?.title
                    binding.tvHSsubtitle.text = domain.getDataHome_store()?.get(indexHotSilers)?.subtitle
                    indexHotSilers = 0
                }
            }

        }
    }}