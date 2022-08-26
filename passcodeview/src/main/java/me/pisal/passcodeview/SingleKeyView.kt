package me.pisal.passcodeview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

/**
 * Element of numeric keypad
 */
class SingleKeyView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defAttr: Int = 0,
) : LinearLayout(context, attributeSet, defAttr) {

    /**
     * Must be numeric
     */
    var keyValue: String = ""
        set(value) {
            field = value
            updateTitle()
        }

    init {
        View.inflate(context, R.layout.single_key_view, this)
        val attr = context.obtainStyledAttributes(attributeSet, R.styleable.SingleKeyView, 0, 0)
        keyValue = attr.getString(R.styleable.SingleKeyView_skKey) ?: ""
        attr.recycle()

        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                this@SingleKeyView.performClick()
            }
        }
    }

    private fun updateTitle() {
        findViewById<Button>(R.id.button).apply {
            text = keyValue
        }
    }
}