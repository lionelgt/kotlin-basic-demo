package me.lgonzalest.kotlinbasicdemo.infrastructure.dao.mapper

import me.lgonzalest.kotlinbasicdemo.domain.model.Demo
import me.lgonzalest.kotlinbasicdemo.infrastructure.dao.entity.DemoEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface DemoEntityMapper{

    @Mapping(source = "message", target = "message")
    fun map(demo: Demo): DemoEntity

    @Mapping(source = "message", target = "message")
    fun map(demo: DemoEntity): Demo

}
