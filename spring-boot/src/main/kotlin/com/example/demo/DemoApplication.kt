package com.example.demo

import org.springframework.beans.factory.getBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans

@SpringBootApplication
class DemoApplication

const val bin_count = 1000

fun main(args: Array<String>) {
	Thread.sleep(10_000)
	val context = runApplication<DemoApplication>(*args){
		addInitializers(beans)
	}
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
