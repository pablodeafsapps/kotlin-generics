package data

import kotlin.reflect.KClass

open class Animal(open val id: Int, open val name: String)

data class Dog(override val id: Int, override val name: String, val furColor: FurColor) : Animal(id, name)

data class Cat(override val id: Int, override val name: String, val eyesColor: EyesColor) : Animal(id, name)

abstract class Bird(override val id: Int, override val name: String, open val featherColor: FeatherColor) :
    Animal(id, name)

data class Canary(
    override val id: Int,
    override val name: String,
    override val featherColor: FeatherColor,
    val tweetPitch: Int
) : Bird(id, name, featherColor)

data class Eagle(
    override val id: Int,
    override val name: String,
    override val featherColor: FeatherColor,
    val maxSpeed: Float
) : Bird(id, name, featherColor)

data class Penguin(
    override val id: Int,
    override val name: String,
    override val featherColor: FeatherColor,
    val age: Int
) : Bird(id, name, featherColor)

enum class FurColor {
    WHITE, BLACK, BROWN, SPOTTED, PATCHED
}

enum class EyesColor {
    BLUE, GREEN, BROWN, YELLOWISH
}

enum class FeatherColor {
    YELLOW, RED, GREEN, WHITE
}

class InvariantCage<T : Animal>(private val t: T?) {

    fun getId(): Int? = t?.id

    fun getName(): String? = t?.name

    fun getContentType() : T? = t?.let { t } ?: run { null }

    fun printAnimalInfo(): String = "Animal ${t?.id} is called ${t?.name}"

}

class CovariantCage<out T : Animal>(private val t: T?) {

    fun getId(): Int? = t?.id

    fun getName(): String? = t?.name

    fun getContentType() : T? = t?.let { t } ?: run { null }

    fun printAnimalInfo(): String = "Animal ${t?.id} is called ${t?.name}"

}

class ContravariantCage<in T : Bird>(private var t: T?) {

    fun getId(): Int? = t?.id

    fun getName(): String? = t?.name

//    fun getContentType() : T? = t?.let { t } ?: run { null }

    fun setContentType(t: T) { this.t = t }

    fun printAnimalInfo(): String = "Animal ${t?.id} is called ${t?.name}"

}
