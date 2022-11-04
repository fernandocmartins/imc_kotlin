package br.com.fernando.imcapp

internal fun getImcResult(pesoTxt: String, alturaTxt: String): IMCResult {

    //criacao de variaveis
    val peso = pesoTxt.toFloat()
    val altura = alturaTxt.toFloat()
    val imc = peso / (altura * altura)

    //valida se tem campos em branco, se sim retorna o resultado
    if (!verifyBlank(pesoTxt, alturaTxt))
        return IMCResult(Result.BLANK)

    //verificacao dos possivel dados de resultado do IMC
    if (imc < 16){
        return IMCResult(Result.MAGREZA_III)
    } else if (imc < 17){
        return IMCResult(Result.MAGREZA_II)
    } else if (imc < 18.5){
        return IMCResult(Result.MAGREZA_I)
    } else if (imc < 25){
        return IMCResult(Result.OK)
    } else if (imc < 30){
        return IMCResult(Result.SOBREPESO)
    } else if (imc < 35){
        return IMCResult(Result.OBESIDADE_I)
    } else if (imc < 40){
        return IMCResult(Result.OBESIDADE_II)
    } else {
        return IMCResult(Result.OBESIDADE_III)
    }
}
    //metodo para verificar se existem campos em branco
    fun verifyBlank(peso: String, altura: String): Boolean {
        return !(peso.isEmpty() || altura.isEmpty())
    }

// classe para armazenar o ENUM
data class IMCResult(val result: Result)
    enum class Result(val label: String) {
        MAGREZA_III("Magreza Severa"),
        MAGREZA_II("Magreza moderada"),
        MAGREZA_I("Magreza leve"),
        OK("Saudável"),
        SOBREPESO("Sobrepeso"),
        OBESIDADE_I("Obesidade Grau I"),
        OBESIDADE_II("Obesidade Grau II (severa)"),
        OBESIDADE_III("Obesidade Grau III (mórbida)"),
        BLANK("Insira os valores de peso e altura corretamente")
}