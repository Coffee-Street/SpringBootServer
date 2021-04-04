package com.wnsgml972.strada.api.v1.item.coffee.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.Immutable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.FetchType
import javax.persistence.CascadeType
@Entity
@DynamicInsert
@DynamicUpdate
@Immutable
class Coffee(

    @Id
    @Column(unique = true, length = 15)
    val id: String = "",

    @Column(length = 128)
    val url: String = "",

    @Column
    val price: Int = 0,

    @Column(length = 255)
    val description: String = "",

    @Column(length = 20)
    val category: String = "",

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "coffee", cascade = [CascadeType.ALL, CascadeType.PERSIST])
    @JsonBackReference(value = "beanCoffeesReference")
    var beanCoffees: List<BeanCoffee>? = null
)