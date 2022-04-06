package me.lgonzalest.kotlinbasicdemo.infrastructure.dao.jpa

import me.lgonzalest.kotlinbasicdemo.infrastructure.dao.entity.DemoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DemoRepositoryJpa : JpaRepository<DemoEntity, Long> {
}