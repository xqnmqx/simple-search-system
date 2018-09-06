package ru.rti

import org.hibernate.search.annotations.Field
import org.hibernate.search.annotations.Indexed
import org.hibernate.search.annotations.Store
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
@Indexed
internal data class User(
        @Id
        val id: Long,
        @Field
        val name: String,
        @Field(store = Store.NO)
        val role: String)
