package me.lgonzalest.kotlinbasicdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinBasicDemoApplication

fun main(args: Array<String>) {
	runApplication<KotlinBasicDemoApplication>(*args)
}
