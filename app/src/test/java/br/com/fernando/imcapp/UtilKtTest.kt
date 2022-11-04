package br.com.fernando.imcapp

import org.junit.Assert.*
import org.junit.Test

class UtilKtTest {

    @Test
    fun `testa o getIMC normal`() {
        //cria variavel e teste se esta funcionando o metodo getIMC
        val result = getImcResult("90", "1.80")
        assertEquals(result.result, Result.SOBREPESO)
    }

    @Test
    fun `teste de campos em branco`() {
        //informando dados em branco
        val peso = ""
        val altura = ""

        // invocando o metodo a ser testador
        val imcResult = getImcResult(peso, altura)

        //verificando o valor
        assertEquals(Result.BLANK, imcResult.result)
    }
}