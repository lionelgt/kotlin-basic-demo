package me.lgonzalest.kotlinbasicdemo.infrastructure.repository

import me.lgonzalest.kotlinbasicdemo.domain.model.Demo
import me.lgonzalest.kotlinbasicdemo.domain.repository.DemoRepository
import me.lgonzalest.kotlinbasicdemo.infrastructure.dao.entity.DemoEntity
import me.lgonzalest.kotlinbasicdemo.infrastructure.dao.jpa.DemoRepositoryJpa
import me.lgonzalest.kotlinbasicdemo.infrastructure.dao.mapper.DemoEntityMapper
import org.springframework.stereotype.Repository

@Repository
class DemoRepositoryImpl(var demoRepositoryJpa: DemoRepositoryJpa, var demoEntityMapper: DemoEntityMapper) : DemoRepository {
    override fun save(demo: Demo): Demo {
        var demoEntity: DemoEntity = demoEntityMapper.map(demo)
        demoEntity =  demoRepositoryJpa.save(demoEntity)
        return demoEntityMapper.map(demoEntity)
    }
}