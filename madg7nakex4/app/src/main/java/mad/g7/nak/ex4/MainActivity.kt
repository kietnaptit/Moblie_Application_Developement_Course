package mad.g7.nak.ex4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var TempFormula = "";
        var TempValue1 = 0.0;
        var TempValue2 = 0.0;
        var TempResult = 0.0;
//        var TempValue1 = 0;
//        var TempValue2 = 0;
//        var TempResult = 0;
        var FormulaSign = "+";
        val inputField = findViewById<TextView>(R.id.inputField)
        val OffButton = findViewById<Button>(R.id.btnOff)
        OffButton.setOnClickListener {
            TempFormula = "";
//            TempValue1 = 0;
//            TempValue2 = 0;
//            TempResult = 0;
            TempValue1 = 0.0;
            TempValue2 = 0.0;
            TempResult = 0.0;
            FormulaSign = "+";
            inputField.text = ""
        }
        val ClsButton = findViewById<Button>(R.id.btnClear)
        ClsButton.setOnClickListener {
            inputField.text = "";
//            TempValue1 = 0;
//            TempValue2 = 0;
//            TempResult = 0;
            TempValue1 = 0.0;
            TempValue2 = 0.0;
            TempResult = 0.0;
        }
        val DivButton = findViewById<Button>(R.id.btnDiv)
        DivButton.setOnClickListener {
            inputField.text = "/"
            if(TempValue1==0.0){
                //TempValue1 = Integer.parseInt(TempFormula);
                TempValue1 = TempFormula.toDouble();
            }
            TempFormula=""
            FormulaSign = "/"
        }
        val MultButton = findViewById<Button>(R.id.btnMult)
        MultButton.setOnClickListener {
            inputField.text = "*"
            if(TempValue1==0.0){
                //TempValue1 = Integer.parseInt(TempFormula);
                TempValue1 = TempFormula.toDouble();
                
            }
            TempFormula=""
            FormulaSign = "*"
        }
        val PlusButton = findViewById<Button>(R.id.btnPlus)
        PlusButton.setOnClickListener {
            inputField.text = "+"
            if(TempValue1==0.0){
                //TempValue1 = Integer.parseInt(TempFormula);
                TempValue1 = TempFormula.toDouble();
            }
            TempFormula=""
            FormulaSign = "+"
        }
        val MinusButton = findViewById<Button>(R.id.btnMinus)
        MinusButton.setOnClickListener {
            inputField.text = "-"
            if(TempValue1==0.0){
                //TempValue1 = Integer.parseInt(TempFormula);
                TempValue1 = TempFormula.toDouble();
            }
            TempFormula=""
            FormulaSign = "-"
        }
        val ClearButton = findViewById<Button>(R.id.btnClear)
        ClearButton.setOnClickListener {
            inputField.text = ""
            TempFormula = ""
            TempValue1 = TempResult;
            TempValue2 = 0.0;
        }
        val BSButton = findViewById<Button>(R.id.btnBS)
        BSButton.setOnClickListener {
            TempFormula = TempFormula.substring(0, TempFormula.length - 1);
            inputField.text = TempFormula
        }
        val EqualButton = findViewById<Button>(R.id.btnEqual)
        EqualButton.setOnClickListener {
            TempResult = 0.0
//            TempValue2 = Integer.parseInt(TempFormula);
            TempValue2 = TempFormula.toDouble()
            if(FormulaSign.equals("+")){
                TempResult = TempValue1 + TempValue2;
            }else if(FormulaSign.equals("-")){
                TempResult = TempValue1 - TempValue2;
            }else if(FormulaSign.equals("*")){
                TempResult = TempValue1 * TempValue2;
            }else if(FormulaSign.equals("/")){
                TempResult = TempValue1 / TempValue2;
            }
            TempValue1 = TempResult;
            TempValue2 = 0.0;
            TempFormula = "";
            var TempResultPrint = TempResult.toString()
            if(TempResultPrint.subSequence(TempResultPrint.length - 2, TempResultPrint.length).equals(".0")){
                inputField.text = TempResultPrint.substring(0,TempResultPrint.length - 2)
            }else{
                inputField.text=TempResultPrint
            }
        }
        val Btn0 = findViewById<Button>(R.id.btn0)
        Btn0.setOnClickListener {
            TempFormula = TempFormula + "0"
            inputField.text = TempFormula
        }
        val Btn1 = findViewById<Button>(R.id.btn1)
        Btn1.setOnClickListener {
            TempFormula = TempFormula + "1"
            inputField.text = TempFormula
        }
        val Btn2 = findViewById<Button>(R.id.btn2)
        Btn2.setOnClickListener {
            TempFormula = TempFormula + "2"
            inputField.text = TempFormula
        }
        val Btn3 = findViewById<Button>(R.id.btn3)
        Btn3.setOnClickListener {
            TempFormula = TempFormula + "3"
            inputField.text = TempFormula
        }
        val Btn4 = findViewById<Button>(R.id.btn4)
        Btn4.setOnClickListener {
            TempFormula = TempFormula + "4"
            inputField.text = TempFormula
        }
        val Btn5 = findViewById<Button>(R.id.btn5)
        Btn5.setOnClickListener {
            TempFormula = TempFormula + "5"
            inputField.text = TempFormula
        }
        val Btn6 = findViewById<Button>(R.id.btn6)
        Btn6.setOnClickListener {
            TempFormula = TempFormula + "6"
            inputField.text = TempFormula
        }
        val Btn7 = findViewById<Button>(R.id.btn7)
        Btn7.setOnClickListener {
            TempFormula = TempFormula + "7"
            inputField.text = TempFormula
        }
        val Btn8 = findViewById<Button>(R.id.btn8)
        Btn8.setOnClickListener {
            TempFormula = TempFormula + "8"
            inputField.text = TempFormula
        }
        val Btn9 = findViewById<Button>(R.id.btn9)
        Btn9.setOnClickListener {
            TempFormula = TempFormula + "9"
            inputField.text = TempFormula
        }
        val SymbolButton = findViewById<Button>(R.id.btnSymbol)
        SymbolButton.setOnClickListener {
            TempFormula = TempFormula + "."
            inputField.text = TempFormula
        }

    }
}