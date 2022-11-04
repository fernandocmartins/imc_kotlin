package br.com.fernando.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fernando.imcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //variavel para dar binding nos IDs do XML
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //listener do botao para calcular os dados
        binding.btnMakeCalc.setOnClickListener {
            val pesoTxt = binding.edtPeso.text.toString()
            val alturaTxt = binding.edtAltura.text.toString()

            if (pesoTxt.isEmpty() || alturaTxt.isEmpty()){
                binding.txtResultImc.text = getString(R.string.blank)
            } else {
                val imcResult = getImcResult(pesoTxt, alturaTxt)

                binding.txtResultImc.text = imcResult.result.label
            }
        }
    }
}