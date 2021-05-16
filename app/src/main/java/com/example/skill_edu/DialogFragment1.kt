package com.example.skill_edu

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.*

class DialogFragment1 : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_y.setOnClickListener{
            Toast.makeText(view.context, "Yes", Toast.LENGTH_SHORT).show()
        }

        btn_n.setOnClickListener{
            Toast.makeText(view.context, "No", Toast.LENGTH_SHORT).show()
        }

        btn_other.setOnClickListener{
            Toast.makeText(view.context, "Other", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }
}