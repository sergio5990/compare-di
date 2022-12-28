package com.example.demo

import org.springframework.beans.factory.getBean
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import java.time.Duration
import java.time.LocalDateTime

const val bin_count = 1000

fun main(args: Array<String>) {
	Thread.sleep(10_000)

	val now = LocalDateTime.now()
	val context = GenericApplicationContext()
	beans.initialize(context)
	context.refresh()
	println("start time " + Duration.between(now, LocalDateTime.now()))

	val userApp = context.getBean<UserApp>()
	assert(userApp.userServices.size == bin_count)

	Thread.sleep(10_000)

}

open class UserService
open class UserApp(val userServices: List<UserService>)

val beans = beans {
	(0 until bin_count).forEach {
		bean<UserService>(name = "userService$it")
	}
	bean<UserApp>()
}
