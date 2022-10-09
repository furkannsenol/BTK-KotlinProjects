package furkan.senol.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

private var number1: Int? = null
private var number2: Int? = null
private var resultTotal: Double? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun mySub(view: View) {
        number1 = editText.text.toString().toIntOrNull()
        number2 = editText2.text.toString().toIntOrNull()

        if (emptyController(number1, number2)) {
            resultText.text = "Error"
        } else {
            resultTotal = (number1!! * number2!!).toDouble()
            resultText.text = resultTotal.toString()
        }
    }

    fun myDiv(view: View) {
        number1 = editText.text.toString().toIntOrNull()
        number2 = editText2.text.toString().toIntOrNull()

        if (emptyController(number1, number2)) {
            resultText.text = "Error"
        } else {
            resultTotal = (number1!! / number2!!).toDouble()
            resultText.text = resultTotal.toString()
        }
    }

    fun myMultiply(view: View) {
        number1 = editText.text.toString().toIntOrNull()
        number2 = editText2.text.toString().toIntOrNull()

        if (emptyController(number1, number2)) {
            resultText.text = "Error"
        } else {
            resultTotal = (number1!! - number2!!).toDouble()
            resultText.text = resultTotal.toString()
        }
    }

    fun mySum(view: View) {
        number1 = editText.text.toString().toIntOrNull()
        number2 = editText2.text.toString().toIntOrNull()

        if (emptyController(number1, number2)) {
            resultText.text = "Error"
        } else {
            resultTotal = (number1!! + number2!!).toDouble()
            resultText.text = resultTotal.toString()
        }
    }

    fun emptyController(a: Int?, b: Int?): Boolean {
        if (a == null || b == null)
            return true
        else
            return false
    }
}
