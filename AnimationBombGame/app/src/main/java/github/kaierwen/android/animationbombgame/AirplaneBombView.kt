package github.kaierwen.android.animationbombgame

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * 飞机爆炸View，带动画效果
 *
 * @author qiaofeng
 * @since 2023-7-14
 */
open class AirplaneBombView : View {

    private val isDebug = true
    private val TAG = AirplaneBombView::class.java.simpleName

    private var icon: Drawable? = null

    // 小飞机图标动画
    private var iconAnimator: ValueAnimator? = null
    private var isAnimatorInit = false

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
        if (isDebug) Log.d(
            TAG,
            "init: width=$width , height=$height , paddingStart=$paddingStart , paddingTop=$paddingTop , paddingEnd=$paddingEnd , paddingBottom=$paddingBottom"
        )
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

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        if (isDebug) Log.d(
            TAG,
            "onLayout: changed=$changed , left=$left , top=$top , right=$right , bottom=$bottom"
        )
        setAnimator()
        iconAnimator?.start()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        if (isDebug) Log.d(TAG, "onSizeChanged: w=$w , h=$h , oldw=$oldw , oldh=$oldh")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paddingStart = paddingStart
        val paddingTop = paddingTop
        val paddingEnd = paddingEnd
        val paddingBottom = paddingBottom

        val contentWidth = width - paddingStart - paddingEnd
        val contentHeight = height - paddingTop - paddingBottom
        if (isDebug) Log.d(
            TAG,
            "onDraw: width=$width , height=$height , paddingStart=$paddingStart , paddingTop=$paddingTop , paddingEnd=$paddingEnd , paddingBottom=$paddingBottom"
        )


//        icon?.let {
//            it.setBounds(
//                paddingLeft, paddingTop,
//                paddingLeft + contentWidth, paddingTop + contentHeight
//            )
//            it.draw(canvas)
//        }
        icon?.let {
            it.setBounds(
                paddingStart, paddingTop,
                200, 200
            )
            it.draw(canvas)
        }
    }

    private fun setAnimator() {
        if (isAnimatorInit) return
        if (isDebug) Log.d(
            TAG,
            "setAnimator: width=$width , height=$height"
        )
        iconAnimator = ValueAnimator.ofInt(0, width)
        iconAnimator?.apply {
            duration = 2000
            addUpdateListener {
                val value = it.animatedValue as Int
                if (isDebug) Log.d(TAG, "setAnimator: animatedValue=$value")
            }
        }
        isAnimatorInit = true
    }
}