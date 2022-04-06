package me.lgonzalest.kotlinbasicdemo.infrastructure.dao.entity

import javax.persistence.*

@Entity
@Table(name = "DEMO")
data class DemoEntity(
    @get:Id
    @get:GeneratedValue
    @get:Column(name = "ID")
    open var id: Long,

    @get:Column(name = "MESSAGE")
    open var message: String)