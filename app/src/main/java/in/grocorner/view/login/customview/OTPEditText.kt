package `in`.grocorner.view.login.customview

import `in`.grocorner.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.ActionMode
import androidx.appcompat.widget.AppCompatEditText

class OtpEditText : AppCompatEditText {
    private var mSpace = 24f //24 dp by default, space between the lines
    private var mNumChars = 5f
    private var mLineSpacing = 8f //8dp by default, height of the text from our lines
    private val mMaxLength = 5
    private var mLineStroke = 2f
    private var mLinesPaint: Paint? = null
    private var mClickListener: OnClickListener? = null

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        val multi = context.resources.displayMetrics.density
        mLineStroke *= multi
        mLinesPaint = Paint(paint).apply {
            strokeWidth = mLineStroke
            color = resources.getColor(R.color.black)
        }
        setBackgroundResource(0)
        mSpace *= multi //convert to pixels for our density
        mLineSpacing *= multi //convert to pixels for our density
        mNumChars = mMaxLength.toFloat()
        super.setOnClickListener { v -> // When tapped, move cursor to end of text.
            setSelection(text?.length ?: 0)
            mClickListener?.onClick(v)
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        mClickListener = l
    }

    override fun setCustomSelectionActionModeCallback(actionModeCallback: ActionMode.Callback) {
        throw RuntimeException("setCustomSelectionActionModeCallback() not supported.")
    }

    override fun onDraw(canvas: Canvas) {
        val availableWidth = width - paddingRight - paddingLeft
        val mCharSize: Float
        mCharSize = if (mSpace < 0) {
            availableWidth / (mNumChars * 2 - 1)
        } else {
            (availableWidth - mSpace * (mNumChars - 1)) / mNumChars
        }
        var startX = paddingLeft
        val bottom = height - paddingBottom

        //Text Width
        val text = text
        val textLength = text?.length ?: 0
        val textWidths = FloatArray(textLength)
        paint.getTextWidths(getText(), 0, textLength, textWidths)
        var i = 0
        while (i < mNumChars) {
            val fillPaint = Paint()
            val strokePaint = Paint()
            val left = startX.toFloat()
            val right = startX + mCharSize
            fillPaint.style = Paint.Style.FILL
            fillPaint.color = Color.WHITE

            // stroke
            strokePaint.style = Paint.Style.STROKE
            strokePaint.color = Color.GRAY
            strokePaint.strokeWidth = 2F
            canvas.drawRect(left, 0f, right, bottom.toFloat(), fillPaint)
            canvas.drawRect(left, 0f, right, bottom.toFloat(), strokePaint)
            if (getText()!!.length > i) {
                val middle = startX + mCharSize / 2
                canvas.drawText(text.toString(), i, i + 1, middle - textWidths[0] / 2, bottom - mLineSpacing, paint)
            }
            if (mSpace < 0) {
                startX += (mCharSize * 2).toInt()
            } else {
                startX += (mCharSize + mSpace.toInt()).toInt()
            }
            i++
        }
    }
}