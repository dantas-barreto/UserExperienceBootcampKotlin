package com.dantasbarreto.ux_kotlin

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ContactHelperTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val sharedPreferences = context.getSharedPreferences("com.dantasbarreto.ux_kotlin.PREFERENCES", Context.MODE_PRIVATE)
    private val contactHelper = ContactHelper(sharedPreferences)

    @Test
    fun `Quando chamar o getListContacts() com 2 contatos, deve retornar uma lista de 2 contatos`() {
        // Preparação
        mockListaDoisContatos()

        // Validação
        val list = contactHelper.getListContacts()
        assertEquals(2, list.size)
    }

    @Test
    fun `Quando chamar o método getListContacts() sem contatos, deve retornar uma lista vazia`() {
        // Preparação
        mockListaContatosVazia()

        // Validação
        val list = contactHelper.getListContacts()
        assertEquals(0, list.size)
    }

    private fun mockListaDoisContatos() {
        contactHelper.setListContacts(
            arrayListOf(
                Contact(
                    "João Pedro",
                    "(00) 0000-0000",
                    "img.png"
                ),
                Contact(
                    "Fulano",
                    "(99) 9999-9999",
                    "img.png"
                )
            )
        )
    }

    private fun mockListaContatosVazia() {
        contactHelper.setListContacts(arrayListOf())
    }
}