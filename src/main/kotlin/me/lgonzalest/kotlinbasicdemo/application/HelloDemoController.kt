package me.lgonzalest.kotlinbasicdemo.application

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/")
class HelloDemoController {

    @GetMapping("/hello")
    fun hello(@RequestParam name: String?): String  =  when (name) {
        null -> "Hello Demo!"
        else -> "Hello $name!"
    }
}