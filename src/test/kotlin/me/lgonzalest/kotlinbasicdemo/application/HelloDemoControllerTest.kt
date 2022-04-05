package me.lgonzalest.kotlinbasicdemo.application

import me.lgonzalest.kotlinbasicdemo.application.mapper.DemoMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mapstruct.factory.Mappers
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HelloDemoControllerTest {
    private val demoMapper: DemoMapper = Mappers.getMapper(DemoMapper::class.java)
    private val mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(HelloDemoController(demoMapper)).build()

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

    @Test
    fun `Check mapper default description response`(){
        mockMvc.perform(MockMvcRequestBuilders.get("/api/mapper"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Please enter message to test mapStruct!"))
    }

    @Test
    fun `Check mapper example! description response`(){
       mockMvc.perform(MockMvcRequestBuilders.get("/api/mapper?message=mapper example"))
           .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("mapper example!"))
    }
}