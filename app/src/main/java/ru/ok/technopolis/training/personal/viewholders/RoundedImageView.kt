package ru.ok.technopolis.training.personal.viewholders

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory

class RoundedImageView : androidx.appcompat.widget.AppCompatImageView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
        val radius = 0.2f
        val bitmap = (drawable as BitmapDrawable).bitmap
        val resourceId = RoundedBitmapDrawableFactory.create(resources, bitmap)
        resourceId.cornerRadius = bitmap.width * radius
        super.setImageDrawable(resourceId)
    }
}