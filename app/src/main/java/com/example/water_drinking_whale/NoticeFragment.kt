package com.example.water_drinking_whale


import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.water_drinking_whale.databinding.FragmentNoticeBinding
import java.util.*


class NoticeFragment : Fragment() {

    private var _binding: FragmentNoticeBinding? = null
    private val binding get() = _binding!!

    private var ampm: String? = null
    private var adapter = NoticeAdapter()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoticeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 코드 작성

        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.noticeRecyclerView.layoutManager = layoutManager

        binding.addNoticeBtn.setOnClickListener {

            var calendar = Calendar.getInstance()
            var hour = calendar.get(Calendar.HOUR)
            var minute = calendar.get(Calendar.MINUTE)

            var listener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                adapter.items.add(Time(timeSet(hour), minute, AM_PM(hour)))
                binding.noticeRecyclerView.adapter = adapter

            }
            var picker = TimePickerDialog(context, listener,hour, minute, true)
            picker.show()


        }

        binding.removeNoticeBtn!!.setOnClickListener {

        }


    }

    //24시간 단위 12시간 단위로 변경
    private fun timeSet(hour:Int):Int{
        var hour = hour
        if (hour>12){
            hour -= 12
        }
        return hour
    }

    //오전 오후 결정
    private fun AM_PM(hour:Int):String{
        ampm = if (hour>=12) {
            "오후"
        }
        else{
            "오전"
        }
        return ampm!!
    }

    companion object {
        const val REQUEST_CODE1 = 1000
        const val REQUEST_CODE2 = 1001
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}