package com.example.programmaticallymaterialbuttonapp

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var llButtons: LinearLayout
    private lateinit var btnProgrammatically: MaterialButton
    private lateinit var btnStyleButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Assign XML Linear Layout
        llButtons = findViewById(R.id.ll_buttons)

        //Add button programmatically
        addButtonProgrammatically()

        //Add button programmatically with style
        addButtonProgrammaticallyWithStyle()

        //Add button from layout resource
        addButtonLayoutResource()
    }

    private fun addButtonProgrammatically() {
        //Add button programmatically
        btnProgrammatically = MaterialButton(this)
        btnProgrammatically.id = R.id.btn_programmatically
        //Convert DP to Pixel
        val paddingPixels30 = dpToPixels(30F)
        val paddingPixels10 = dpToPixels(10F)
        btnProgrammatically.setPadding(paddingPixels30, paddingPixels10, paddingPixels30,
            paddingPixels10)
//        btnProgrammatically.setPaddingRelative(30, 0, 30, 0)
        btnProgrammatically.background.setTint(resources.getColor(R.color.red))
        btnProgrammatically.text = "Programmatically"
        btnProgrammatically.typeface = Typeface.DEFAULT_BOLD
        //Convert DP to Pixel
        val cornerRadiusPixels = dpToPixels(25F)
        btnProgrammatically.cornerRadius = cornerRadiusPixels
        btnProgrammatically.strokeColor = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.black))
        //Convert DP to Pixel
        val strokePixels = dpToPixels(2F)
        btnProgrammatically.strokeWidth = strokePixels
        val customLayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams
            .WRAP_CONTENT, LinearLayout.LayoutParams
            .WRAP_CONTENT) //LinearLayout.LayoutParams.MATCH_PARENT

        //Convert DP to Pixel
        val marginPixels = dpToPixels(5F)
        customLayoutParams.setMargins(marginPixels, marginPixels, marginPixels, marginPixels)
//        customLayoutParams.weight = 1F
        btnProgrammatically.layoutParams = customLayoutParams

        llButtons.addView(btnProgrammatically)
    }

    private fun addButtonProgrammaticallyWithStyle() {
        //Add button programmatically with style
        btnStyleButton = MaterialButton(this, null, R.attr.myButtonStyle)

        //Layout parameters cannot be added in style because these parameters
        //must be defined after the view is included in its context (parent)
        val customLayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams
            .WRAP_CONTENT, LinearLayout.LayoutParams
            .WRAP_CONTENT) //LinearLayout.LayoutParams.MATCH_PARENT

        //Convert DP to Pixel
        val marginPixels = dpToPixels(5F)
        customLayoutParams.setMargins(marginPixels, marginPixels, marginPixels, marginPixels)
        btnStyleButton.layoutParams = customLayoutParams
        llButtons.addView(btnStyleButton)
    }

    private fun dpToPixels(dpFloat: Float): Int{
        //Convert margin DP to Pixel
        val r = this.resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpFloat,
            r.displayMetrics
        ).toInt()
    }

    private fun addButtonLayoutResource() {
        //Add button from layout resource
        val btnLayout = LayoutInflater.from(llButtons.context).inflate(R.layout.button_custom,
            llButtons,
            false)
        btnLayout.id = View.generateViewId()
        llButtons.addView(btnLayout)
    }
}