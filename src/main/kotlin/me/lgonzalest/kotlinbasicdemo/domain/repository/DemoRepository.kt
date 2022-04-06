package me.lgonzalest.kotlinbasicdemo.domain.repository

import me.lgonzalest.kotlinbasicdemo.domain.model.Demo

interface DemoRepository {
    fun save(demo: Demo): Demo
}