package com.wnsgml972.strada.api.v1.item.bread.controller

import BASE_URL_V1
import com.wnsgml972.strada.api.v1.item.bread.service.BreadDTO
import com.wnsgml972.strada.api.v1.item.bread.service.BreadInsertRequest
import com.wnsgml972.strada.api.v1.item.bread.service.BreadService
import com.wnsgml972.strada.api.v1.item.bread.service.toDto
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import javax.validation.Valid

@RestController
@RequestMapping(path = [BreadController.BREAD_BASE_URL])
@Tag(
    name = "breads",
    description = """아이템을 위한 API, bread 컨트롤"""
)
class BreadController @Autowired constructor(
    private var breadService: BreadService
) {

    @GetMapping("/")
    @ApiResponse(responseCode = "200", description = "List all Bread")
    fun selectAll() = breadService.selectAll()

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Find Bread")
    fun select(@PathVariable("id") id: String) = breadService.selectById(id)

    @PostMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Add Bread")
    fun insert(@PathVariable id: String, @RequestBody @Valid breadInsertRequest: BreadInsertRequest): BreadDTO =
        breadService.insert(BreadDTO(id, breadInsertRequest)).toDto()

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Update Bread")
    fun update(@PathVariable id: String, @RequestBody @Valid breadInsertRequest: BreadInsertRequest): BreadDTO =
        breadService.update(BreadDTO(id, breadInsertRequest)).toDto()

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Delete Bread")
    fun delete(@PathVariable id: String) = breadService.delete(id)

    companion object : KLogging() {
        private const val ACCOUNT_SERVICE_NAME = "breads/admin"
        const val BREAD_BASE_URL = "$BASE_URL_V1/$ACCOUNT_SERVICE_NAME"
    }
}
