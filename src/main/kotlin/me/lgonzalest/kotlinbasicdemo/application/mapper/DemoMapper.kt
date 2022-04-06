package me.lgonzalest.kotlinbasicdemo.application.mapper

import me.lgonzalest.kotlinbasicdemo.domain.model.Demo
import me.lgonzalest.kotlinbasicdemo.application.response.DemoResponse
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface DemoMapper{

    @Mapping(source = "message", target = "description")
    fun map(demo: Demo): DemoResponse

}
