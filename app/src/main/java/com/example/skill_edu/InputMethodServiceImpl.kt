package com.example.skill_edu

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.View

@Suppress("DEPRECATION")
class InputMethodServiceImpl: InputMethodService(), KeyboardView.OnKeyboardActionListener {

    override fun onCreateInputView(): View {
        val keyboardView = layoutInflater.inflate(R.layout.custom_keyboard, null) as KeyboardView
        val keyboard = Keyboard(this, R.xml.num_pad)
        keyboardView.keyboard = keyboard
        keyboardView.setOnKeyboardActionListener(this)
        return keyboardView
    }

    override fun onPress(primaryCode: Int) {
    }

    override fun onRelease(primaryCode: Int) {
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        currentInputConnection?.commitText(primaryCode.toString(), 1)
    }

    override fun onText(text: CharSequence?) {
    }

    override fun swipeLeft() {
    }

    override fun swipeRight() {
    }

    override fun swipeDown() {
    }

    override fun swipeUp() {
    }

}