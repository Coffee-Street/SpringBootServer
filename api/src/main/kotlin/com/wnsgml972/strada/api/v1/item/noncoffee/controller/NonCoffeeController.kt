package com.wnsgml972.strada.api.v1.item.noncoffee.controller

import BASE_URL_V1
import com.wnsgml972.strada.api.v1.item.noncoffee.service.NonCoffeeDTO
import com.wnsgml972.strada.api.v1.item.noncoffee.service.NonCoffeeInsertRequest
import com.wnsgml972.strada.api.v1.item.noncoffee.service.NonCoffeeService
import com.wnsgml972.strada.api.v1.item.noncoffee.service.toDto
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import javax.validation.Valid

// junit5를 기반으로 테스트 짤 계획
// mock framework
// domain name: item

@RestController
@RequestMapping(path = [NonCoffeeController.NONCOFFEE_BASE_URL])
@Tag(
    name = "noncoffees",
    description = """메뉴를 위한 API"""
)
class NonCoffeeController @Autowired constructor(
    private var nonCoffeeService: NonCoffeeService
) {

    @GetMapping("/")
    @ApiResponse(responseCode = "200", description = "List all NonCoffees")
    fun selectAll() = nonCoffeeService.selectAll()

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Find NonCoffees from id")
    fun select(@PathVariable("id") id: String) = nonCoffeeService.selectById(id)

    @PostMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Add NonCoffees")
    fun insert(
        @PathVariable id: String,
        @RequestBody @Valid nonCoffeeInsertRequest: NonCoffeeInsertRequest
    ): NonCoffeeDTO =
        nonCoffeeService.insert(NonCoffeeDTO(id, nonCoffeeInsertRequest)).toDto()

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Update coffee")
    fun update(
        @PathVariable id: String,
        @RequestBody @Valid nonCoffeeInsertRequest: NonCoffeeInsertRequest
    ): NonCoffeeDTO =
        nonCoffeeService.insert(NonCoffeeDTO(id, nonCoffeeInsertRequest)).toDto()

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "delete coffee")
    fun delete(@PathVariable id: String) = nonCoffeeService.delete(id)

    companion object : KLogging() {
        private const val ACCOUNT_SERVICE_NAME = "noncoffees/admin"
        const val NONCOFFEE_BASE_URL = "$BASE_URL_V1/$ACCOUNT_SERVICE_NAME"
    }
}
