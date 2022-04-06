package me.lgonzalest.kotlinbasicdemo.application

import me.lgonzalest.kotlinbasicdemo.application.mapper.DemoMapper
import me.lgonzalest.kotlinbasicdemo.domain.model.Demo
import me.lgonzalest.kotlinbasicdemo.application.response.DemoResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/")
class HelloDemoController(var demoMapper: DemoMapper) {

    @GetMapping("/hello")
    fun hello(@RequestParam name: String?): String  =  when (name) {
        null -> "Hello Demo!"
        else -> "Hello $name!"
    }

    @GetMapping("/mapper")
    fun map(@RequestParam message: String?): DemoResponse {
        val msj: String = when (message) {
            null -> "Please enter message to test mapStruct!"
            else -> "$message!"
        }

        val demo = Demo(msj)
        return demoMapper.map(demo)

    }
}