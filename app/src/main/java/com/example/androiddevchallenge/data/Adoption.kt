package com.example.androiddevchallenge.data

import java.io.Serializable

data class Adoption(
    var dog: Dog,
    var postedDate: String,
    var location: String,
    var distance: String,
    var postedBy: User,
    var type: String
) : Serializable

data class Dog(
    var name: String,
    var nickName: String,
    var gender: String,
    var height: String,
    var weight: String,
    var age: String,
    var image: String = "https://unsplash.com/photos/Sg3XwuEpybU/download?force=true"
) : Serializable

data class User(
    var name: String,
    var contact: String
) : Serializable

data class Breed(
    var name: String,
    var description: String,
    var count: String,
    var image: String = "https://unsplash.com/photos/Sg3XwuEpybU/download?force=true"
) : Serializable


object AdoptionData {
    val breedList =
        listOf(
            Breed("All", "No idea about bread","100 Dogs","https://unsplash.com/photos/O67BfLHl4C0/download?force=true"),
            Breed("Hound","For Hunting","20 Dogs"),
            Breed("Sporting","Energetic and trainable","20 Dogs","https://unsplash.com/photos/a01Y4ijMFRA/download?force=true"),
            Breed("Toy","For the love of kids","20 Dogs","https://unsplash.com/photos/r3PsLM9oXuU/download?force=true"),
            Breed("Working","For helping out","20 Dogs","https://unsplash.com/photos/PUY5xUszd3Y/download?force=true"),
            Breed("Herding","For helping out","20 Dogs","https://unsplash.com/photos/0nk6XZp7_1E/download?force=true")
        )

    val adoptionsAvailable: List<Adoption> = listOf(
        Adoption(
            Dog(
                "Beagle",
                "Charlie",
                "Male",
                "14 Inches",
                "30 Pounds",
                "3 Months",
                image = "https://unsplash.com/photos/7vhqnO-sT88/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "Central Park, Fremont",
            "2 Km away",
            User("John Doe", "+1212345678"),
            "hound"
        ),
        Adoption(
            Dog(
                "Bloodhound",
                "Charlie",
                "Male",
                "23 Inches",
                "90 Pounds",
                "2 Years",
                image = "https://unsplash.com/photos/qy0BHykaq0E/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "San Jose, California",
            "12 Km away",
            User("Doe John", "+1212345678"),
            "hound"
        ),
        Adoption(
            Dog(
                "Coonhound",
                "Charlie",
                "Male",
                "23 Inches",
                "90 Pounds",
                "1 Year 2 Months",
                image = "https://unsplash.com/photos/tUCvnMOvXFQ/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "San Jose, California",
            "4 Km away",
            User("Doe John", "+1212345678"),
            "hound"
        ),
        Adoption(
            Dog(
                "Coonhound",
                "Charlie",
                "Female",
                "20 Inches",
                "78 Pounds",
                "1 Year 8 Months",
                image = "https://unsplash.com/photos/-DueXI-0AO0/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "San Jose, California",
            "2 Km away",
            User("Armanda Wilcox", "+1212345678"),
            "hound"
        ),
        Adoption(
            Dog(
                "Beagle",
                "Charlie",
                "Female",
                "16 Inches",
                "42 Pounds",
                "9 Months",
                image = "https://unsplash.com/photos/5PVXkqt2s9k/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "Central Park, Fremont",
            "10 Km away",
            User("Motu Pierre", "+1212345678"),
            "hound"
        ),
        Adoption(
            Dog(
                "Boobul",
                "Charlie",
                "Female",
                "2 Feet 3 Inches",
                "78 Pounds",
                "1 Year 8 Months",
                image = "https://unsplash.com/photos/YQkr2e4hrdM/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "San Jose, California",
            "10 Km away",
            User("Armanda Wilcox", "+1212345678"),
            "hound"
        ),
        Adoption(
            Dog(
                "Coonhound",
                "Charlie",
                "Female",
                "20 Inches",
                "78 Pounds",
                "1 Year 8 Months",
                image = "https://unsplash.com/photos/mHydPkINoIE/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "San Jose, California",
            "10 Km away",
            User("Armanda Wilcox", "+1212345678"),
            "hound"
        ),
        Adoption(
            Dog(
                "Coonhound",
                "Charlie",
                "Female",
                "20 Inches",
                "78 Pounds",
                "1 Year 8 Months",
                image = "https://unsplash.com/photos/0wyjE0FzVm4/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "San Jose, California",
            "10 Km away",
            User("Armanda Wilcox", "+1212345678"),
            "hound"
        ),
        Adoption(
            Dog(
                "Coonhound",
                "Charlie",
                "Female",
                "20 Inches",
                "78 Pounds",
                "1 Year 8 Months",
                image = "https://unsplash.com/photos/bCVQTXrJHUw/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "San Jose, California",
            "10 Km away",
            User("Armanda Wilcox", "+1212345678"),
            "hound"
        ),
        Adoption(
            Dog(
                "Coonhound",
                "Charlie",
                "Female",
                "20 Inches",
                "78 Pounds",
                "1 Year 8 Months",
                image = "https://unsplash.com/photos/IPFguInafKc/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "San Jose, California",
            "10 Km away",
            User("Armanda Wilcox", "+1212345678"),
            "hound"
        ),
        Adoption(
            Dog(
                "Coonhound",
                "Charlie",
                "Female",
                "20 Inches",
                "78 Pounds",
                "1 Year 8 Months",
                image = "https://unsplash.com/photos/Q7RNfpD4t10/download?force=true"
            ),
            "Sunday, 28 February 2021",
            "San Jose, California",
            "22 Km away",
            User("Armanda Wilcox", "+1212345678"),
            "hound"
        )
    )
}
