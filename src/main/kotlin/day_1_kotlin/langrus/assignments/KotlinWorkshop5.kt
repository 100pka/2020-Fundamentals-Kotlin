package day_1_kotlin.langrus.assignments

// Workshop #5 - inheritance, abstract, interface

// Не исправляй! Дано:
// Объявляем контракт, представляющий некое свойство транспорта.
interface Driveable {
    fun drive()
}

// Объявляем класс пассажирского транспорта вцелом.
// Придадим такому транспорту свойство перемещаться под управлением водителя.
abstract class Transport(protected var passengersCount: Int): Driveable

// Создадим реальный транспорт: "Велосипед". Он может управляться водителем и перевозит одного пассажира.
class Bicycle: Transport(1) {
    override fun drive() {
        println("Ride a bicycle.")
    }
}



/* Рабочая зона */

// TODO 1: Создай свой интерфейс - контракт, который бы также подошел по смыслу классу транспорт.
//  См. ниже.
// ? Имена классов и файлов Котлин принято называть с заглавной буквы, в формате "camelCase".
// Например: "SomeLongClassName"
interface Controllable {
    fun turnLeft()
    fun turnRight()
}

// TODO 2: Создай свои собственные классы, например "Bus" и "Car".
//  Эти классы не будут полностью написаны с нуля, они должны расширять общий класс "Transport",
//  и дополнительно реализовывать придуманный тобой интерфейс.
// ? Класс может наследовать только один класс, но реализовывать несколько интерфейсов, например:
// class Kitty(): Cat, Cuteable, Sleepable, Furryable {}
class Bus (passengersCount: Int): Transport(passengersCount), Controllable {

    override fun drive() {
        println("Bus starts moving")
    }

    override fun turnLeft() {
        println("Bus turning left")
    }

    override fun turnRight() {
        println("Bus turning right")
    }
}

class Car (passengersCount: Int): Transport(passengersCount), Controllable {

    override fun drive() {
        println("Car starts moving")
    }

    override fun turnLeft() {
        println("Car turning left")
    }

    override fun turnRight() {
        println("Car turning right")
    }
}

// TODO 3: Протестируй работоспособность твоего транспорта.
object VehiclesTest {

    // Запусти исполнение main() функции, для выполнения кода.
    @JvmStatic
    fun main(args: Array<String>) {
        testBus()
        testCar()
        testBicycle()
    }

    private fun testBus() {
        println("Testing how bus drives...")
        val bus = Bus(10)
        bus.drive()
        bus.turnLeft()
        bus.turnRight()

    }

    private fun testCar() {
        println("Testing how car drives...")
        val car = Car(2)
        car.drive()
        car.turnLeft()
        car.turnRight()

    }

    private fun testBicycle() {
        println("\nTesting how bicycle drives...")
        val bicycle = Bicycle()
        bicycle.drive()
    }



    /* Бонусные задания */

    // TODO 4: Протестируй агрегаты автобуса, как независимые компоненты.
    //  Т.е. каждый набор независимых свойств - отдельно, чтобы в тестируемой сущности были скрыты все свойства,
    //  не принадлежащие к данному набору.
    private fun testBusParts() {
        val bus = Bus(10)
        println("Testing bus's feature 1...")
        val driveable: Driveable = bus
        driveable.drive()
        println("Testing bus's feature 2...")
        val controllable: Controllable = bus
        controllable.turnLeft()
    }
}