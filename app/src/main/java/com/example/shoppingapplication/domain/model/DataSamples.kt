package com.example.shoppingapplication.domain.model

val categoriesHardCoded = listOf(
    Category(id = 1, name = "Electronics", description = "All electronic items","https://ecelectronics.com/wp-content/uploads/2020/04/Modern-Electronics-EC-.jpg"),
    Category(id = 2, name = "Books", description = "Read and grow your knowledge","https://images.inc.com/uploaded_files/image/1920x1080/getty_655998316_2000149920009280219_363765.jpg"),
    Category(id = 3, name = "Clothing", description = "Latest trends in fashion","https://www.greenqueen.com.hk/wp-content/uploads/2021/07/Rental-Fashion-Causes-More-Emissions-Than-Throwing-Clothes-Away.jpg")
)

val shoppingItemsHardCoded = listOf(
    ShoppingItem(
        id = 101,
        name = "Laptop",
        price = 999.99,
        quantity = 10,
        categoryId = 1,
        "https://www.cnet.com/a/img/hub/2015/06/03/6eb4cb42-3ac0-46f6-8e7b-d4f01dcba56a/apple-macbook-pro-15-inch-2015-07.jpg"
    ),
    ShoppingItem(
        id = 102,
        name = "Mouse",
        price = 9.99,
        quantity = 15,
        categoryId = 1,
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/3-Tasten-Maus_Microsoft.jpg/440px-3-Tasten-Maus_Microsoft.jpg"
    ),
    ShoppingItem(
        id = 201,
        name = "The Lean Startup",
        price = 24.99,
        quantity = 8,
        categoryId = 2,
        "https://media.shortform.com/covers/png/the-lean-startup-cover@8x.png"
    ),
    ShoppingItem(
        id = 301,
        name = "Denim Jeans",
        price = 29.99,
        quantity = 2,
        categoryId = 3,
        "https://cdn.optipic.io/site-2219/images/jeans/dkblheavydenim.jpg"
    )
)

val cartItemsHardCoded = mutableListOf(
    CartItem(id = 1, shoppingItemId = 101, quantity = 1),
    CartItem(id = 2, shoppingItemId = 102, quantity = 2),
    CartItem(id = 3, shoppingItemId = 301, quantity = 1)
)

val userHardCoded = User(
    userName = "@waleed_hamam",
    fullName = "Alwaleed Hamam",
    location = "Atlanta",
    joinDate = "Joined March 2023",
    description = "CEO System D, Because your satisfaction is everything & Standing out from the rest, and that’s what we want you to be as well.",
    websiteUrl = "www.alwaleed.com",
    email = "Hello@alwaleed.com",
    phoneNumber = "+1-517-218-9200"
)


val purchaseHistoryHardCoded = listOf(
    PurchaseHistory(
        transactionId = 1001,
        items = listOf(shoppingItemsHardCoded[0], shoppingItemsHardCoded[2]),
        purchaseDate = "2023-04-01",
    ),
    PurchaseHistory(
        transactionId = 1002,
        items = listOf(shoppingItemsHardCoded[1], shoppingItemsHardCoded[3]),
        purchaseDate = "2023-04-15",
    )
)
