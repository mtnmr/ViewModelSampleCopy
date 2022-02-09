package com.example.databindingsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.databindingsample.databinding.FragmentCountBinding

class CountFragment : Fragment(R.layout.fragment_count) {

    private lateinit var binding: FragmentCountBinding

    private val viewModel: CountModel by activityViewModels()
//    private lateinit var viewModel:CountModel
//    private val viewModel :CountModel by lazy { ViewModelProvider.NewInstanceFactory().create(CountModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_count, container, false)
        binding.countModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var counterA = 0

        val count1 = view.findViewById<TextView>(R.id.count1)
        val count2 = view.findViewById<TextView>(R.id.count2)
        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            counterA += 1
            viewModel.countUp()
            count2.text = counterA.toString()
            count1.text = viewModel.modelCount.value.toString()

        }

//        count2.text = counterA.toString()
//        count1.text = viewModel.modelCount.value.toString()
//        val countObserver = Observer<Int> { counter ->
//            // 更新を受け取ったらTextViewを更新
//            binding.count1.text = counter.toString()
//        }
//        // LiveDataを監視し、このアクティビティをLifecycleOwnerおよびオブザーバーとして渡す
//        viewModel.modelCount.observe(viewLifecycleOwner, countObserver)
    }
}




