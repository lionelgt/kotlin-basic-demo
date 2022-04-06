package me.lgonzalest.kotlinbasicdemo.application.controller

import me.lgonzalest.kotlinbasicdemo.application.mapper.DemoMapper
import me.lgonzalest.kotlinbasicdemo.application.response.DemoResponse
import me.lgonzalest.kotlinbasicdemo.domain.model.Demo
import me.lgonzalest.kotlinbasicdemo.domain.repository.DemoRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/demo")
class DemoController(var demoMapper: DemoMapper,
                     var demoRepository: DemoRepository) {

    @GetMapping("/save")
    fun save(@RequestParam message: String?): DemoResponse {
        val msj: String = when (message) {
            null -> "Please enter message to save!"
            else -> "$message!"
        }

        val demo = demoRepository.save(Demo(msj))
        return demoMapper.map(demo)
    }
}