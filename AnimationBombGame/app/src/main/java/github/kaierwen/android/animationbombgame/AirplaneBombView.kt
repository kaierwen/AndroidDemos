package github.kaierwen.android.animationbombgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View

/**
 * 飞机爆炸View，带动画效果
 *
 * @author qiaofeng
 * @since 2023-7-14
 */
class AirplaneBombView : View {

    var icon: Drawable? = null

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.AirplaneBombView, defStyle, 0
        )
        if (a.hasValue(R.styleable.AirplaneBombView_abv_icon)) {
            icon = a.getDrawable(
                R.styleable.AirplaneBombView_abv_icon
            )
            icon?.callback = this
        }
        a.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paddingLeft = paddingStart
        val paddingTop = paddingTop
        val paddingRight = paddingEnd
        val paddingBottom = paddingBottom

        val contentWidth = width - paddingLeft - paddingRight
        val contentHeight = height - paddingTop - paddingBottom

        icon?.let {
            it.setBounds(
                paddingLeft, paddingTop,
                paddingLeft + contentWidth, paddingTop + contentHeight
            )
            it.draw(canvas)
        }
    }
}