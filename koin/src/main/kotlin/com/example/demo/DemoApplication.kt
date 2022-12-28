package com.example.demo

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.time.Duration
import java.time.LocalDateTime

const val bin_count = 1000

fun main(args: Array<String>) {
	Thread.sleep(10_000)

	val now = LocalDateTime.now()
	startKoin {
		modules(appModule)
	}
	val userApp = App().userApp
	println("start time " + Duration.between(now, LocalDateTime.now()))

	assert(userApp.userServices.size == bin_count)

	Thread.sleep(10_000)

}

class App: KoinComponent {
	val userApp : UserApp by inject()
}
open class UserService
open class UserApp(val userServices: List<UserService>)


val appModule = module {
	(0 until bin_count).forEach {
		single(named("userService$it")) { UserService() }
	}
	single { UserApp(getAll()) }
}