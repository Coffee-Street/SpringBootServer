package com.wnsgml972.strada.api.v1.item.bread.controller

import BASE_URL_V1
import com.wnsgml972.strada.api.v1.item.bread.service.BreadDTO
import com.wnsgml972.strada.api.v1.item.bread.service.BreadService

import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping

// junit5를 기반으로 테스트 짤 계획
// mock framework
// domain name: item

@RestController
@RequestMapping(path = [BreadController.ITEM_BASE_URL], produces = ["application/json"])
@Tag(
    name = "item",
    description = """아이템을 위한 API, bread 컨트롤"""
)
class BreadController @Autowired constructor() {

    @Autowired
    private lateinit var breadService: BreadService

    @PostMapping("/Breads")
    @ApiResponse(responseCode = "200", description = "List all Bread")
    fun selectAll() = breadService.selectAll()

    @GetMapping("/bread/{id}")
    @ApiResponse(responseCode = "200", description = "Find Bread")
    fun find(@PathVariable("id") id: String) = breadService.selectById(id)

    @PostMapping("/bread/{id}")
    @ApiResponse(responseCode = "200", description = "Add Bread")
    fun add(@RequestBody breadDTO: BreadDTO): ResponseEntity<Any> {
        breadService.insert(breadDTO)
        return ResponseEntity(HttpStatus.OK)
    }

    @PutMapping("/bread/{id}")
    @ApiResponse(responseCode = "200", description = "Update Bread")
    fun update(@RequestBody breadDTO: BreadDTO): ResponseEntity<Any> {
        breadService.update(breadDTO)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/bread/{id}")
    @ApiResponse(responseCode = "200", description = "Delete Bread")
    fun delete(@RequestBody id: String) = breadService.delete(id)

    companion object : KLogging() {
        private const val ACCOUNT_SERVICE_NAME = "items"
        const val ITEM_BASE_URL = "$BASE_URL_V1/$ACCOUNT_SERVICE_NAME"
    }
}