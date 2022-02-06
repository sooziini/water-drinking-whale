package com.example.water_drinking_whale

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.water_drinking_whale.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()

    }

    private fun setToolbar() {
        binding.homeFragmentToolbar.apply {
            inflateMenu(R.menu.home_fragment_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.homeSetting -> {
                        startActivity(Intent(activity, SettingActivity::class.java))
                        true
                    }
                    else -> false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}