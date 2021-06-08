package com.example.skill_edu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.AutoTransition
import kotlinx.android.synthetic.main.fragment_main.*

const val transName = "image_trans"

const val transNameText = "text_trans"

const val KEY_IMAGE_INDEX = "image_index"
const val KEY_TEXT_INDEX = "text_index"

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    val secondFragment = SecondFragment()

    init {
        secondFragment.sharedElementEnterTransition = AutoTransition().setDuration(800L)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val texts = arrayOf(t)
        val images = arrayOf(i)

        images[secondFragment.imageIndex].transitionName = transName
        texts[secondFragment.imageIndex].transitionName = transNameText


        images.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                images[secondFragment.imageIndex].transitionName = ""
                texts[secondFragment.imageIndex].transitionName = ""

                imageView.transitionName = transName
                texts[index].transitionName = transNameText
                parentFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .addSharedElement(imageView, transName)
                    .addSharedElement(texts[index], transNameText)
                    .replace((view.parent as ViewGroup).id, secondFragment.apply {
                        imageIndex = index
                        text = texts[index].text.toString()
                    })
                    .addToBackStack("Main")
                    .commit()
            }
        }
    }

}