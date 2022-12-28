package com.example.demo

import org.kodein.di.*
import java.time.Duration
import java.time.LocalDateTime

const val bin_count = 100

fun main(args: Array<String>) {
	Thread.sleep(10_000)

	val now = LocalDateTime.now()
	val kodein = DI {
		import(appModule)
	}
	val userApp:UserApp = kodein.direct.instance()
	println("start time " + Duration.between(now, LocalDateTime.now()))

	assert(userApp.userServices.size == bin_count)

	Thread.sleep(10_000)

}

open class UserService
open class UserApp(val userServices: Set<UserService>)


val appModule = DI.Module(name = "test") {
	bindSet<UserService>()
	(0 until bin_count).forEach {
		addInBindSet { singleton { UserService() } }
	}
	bindSingleton { UserApp(instance()) }
}