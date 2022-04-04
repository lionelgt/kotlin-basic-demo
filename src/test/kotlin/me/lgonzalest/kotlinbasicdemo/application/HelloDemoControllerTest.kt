package me.lgonzalest.kotlinbasicdemo.application

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HelloDemoControllerTest {

    private val mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(HelloDemoController()).build()

    @Test
    fun `Check Hello Demo! response`(){
        val mvcResult: MvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/hello")).andReturn()
        Assertions.assertEquals("Hello Demo!", mvcResult.response.contentAsString)
    }

    @Test
    fun `Check Hello someone! response`(){
        val mvcResult: MvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/hello?name=someone")).andReturn()
        Assertions.assertEquals("Hello someone!", mvcResult.response.contentAsString)
    }
}