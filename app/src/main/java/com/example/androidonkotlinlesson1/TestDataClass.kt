package com.example.androidonkotlinlesson1

// создание экземпляра класса со значением sex по умолчанию
val testDataClass = TestDataClass("Василий", 29)

// создание экземпляра класса с использованием имнованых параметров
val testDataClass2 = TestDataClass(
    age = 20,
    sex = false,
    name = "Алиса"
)

// пример создания функции с возвращаемым значением
fun testFun(name: String, age: Int, sex: Boolean): TestDataClass {
    println("Создан объект класса TestDataClass с параметрами - имя = $name, возраст = $age, пол = $sex")
    return TestDataClass(name, age, sex)
}

// пример переопределения в data class методов copy, toString, equals, hashCode, component
fun main() {
    val testDataClass3 = testFun(testDataClass.name, testDataClass.age, testDataClass.sex)
    val testDataClass3Copy = testDataClass3.copy()
    println(testDataClass3Copy.hashCode() == testDataClass3.hashCode())
    println(testDataClass3Copy.toString())
    println(testDataClass3.component1())

    val person1 = Person.newInstance()
    person1.running(12, 15)
}

data class TestDataClass(val name: String, var age: Int, val sex: Boolean = true)

interface TestInterface {
    fun walking(distance: Int)
    fun running(distance: Int, speed: Int)
    fun sleep(time: Int)
}

class Person : TestInterface {

    companion object{
        fun newInstance(): Person{
            return Person()
        }
    }

    override fun walking(distance: Int) {
        println("Человек прошел $distance км")
    }

    override fun running(distance: Int, speed: Int) {
        println("Человек пробежал $distance км со скоростью $speed км/ч")
    }

    override fun sleep(time: Int) {
        when{
            time < 4 -> println("Человек не выспался :(")
            time in 4..7 -> println("Человек выспался")
            time < 4 -> println("Человек не выспался :(")
        }

    }
}
