import data.*


fun main() {

    val dog1: Animal = Dog(id = 0, name = "Swift", furColor = FurColor.BLACK)
    val dog2: Dog = Dog(id = 1, name = "Stu", furColor = FurColor.PATCHED)
    var cat1: Animal = Cat(id = 3, name = "Tuno", eyesColor = EyesColor.GREEN)
    var cat2: Cat = Cat(id = 2, name = "Tula", eyesColor = EyesColor.YELLOWISH)
    var animal1: Animal = Dog(0,"Swift", FurColor.BLACK);
    var animal2: Animal = Cat(3, "Tuno", EyesColor.GREEN);

    // inheritance and polymorphism allow us to do the following sort of re-assignation
    cat1 = dog2
    // obviously, the reverse does not apply
//    cat2 = dog1

    // --- collections ---
    val dogList: List<Dog> = listOf()
    var animalList: List<Animal> = dogList   //This assignation is not valid in Java (not covariant)

    val dogMutableList: MutableList<Dog> = mutableListOf()
//    var animalMutableList: MutableList<Animal> = dogMutableList   //This assignation fails as in Java (invariant)

    // --- parametrized classes ---
    var cage1: CovariantCage<Dog> = CovariantCage(dog2)
    var cage2: CovariantCage<Animal> = cage1

//    var cage3: ContravariantCage<Bird> = ContravariantCage(animal1)
//    var cage4: ContravariantCage<Animal> = cage3
    
    println("Done!")

}