# Brewly — Coffee App
___

## Overview
----------

Brewly is a coffee ordering Android application built using **Kotlin** and **Jetpack Compose**.

This project phase focuses on developing the complete frontend, including the application's user interface, reusable UI components, screen navigation, and basic user interactions.

## Features
-----------

### Welcome Screen
-----------------

- Initial screen of the application.
- Provides entry into the main application flow.

### Home Screen
--------------

- Displays available coffee products.
- Includes coffee categories for filtering/navigation.
- Uses reusable product cards.
- Displays products in a two-column layout.

### Product Details
------------------

- Displays detailed information about a selected coffee.
- Shows product image, name, description, and price.
- Supports coffee size selection.
- Includes favorite interaction.
- Provides an option to add the product to the cart.

### Cart
-------

- Displays the cart interface.
- Includes payment method selection.
- Provides the basic cart ordering flow.

### Favourites
-------------

- Dedicated screen for favourite coffee items.
- Accessible through the bottom navigation.

### Profile
----------

- Dedicated user profile screen.
- Accessible through the bottom navigation.

### Navigation
-------------

- Navigation between application screens is implemented using Jetpack Compose Navigation.
- Bottom navigation is used for the main application sections.
- Separate routes are defined for the application's screens.

### UI Components
----------------

Reusable components were created for commonly used UI elements:

- Bottom Navigation Bar
- Message Dialog
- Product Card
- Category Card
- Size Selection Chip
- Top App Bar
- Bottom App Bar

### Application Icon
--------------------

- Custom Brewly application icon added.
- Adaptive and legacy launcher icons generated using Android Studio Asset Studio.

## Project Structure
-------------------

```text
com.androidlearning.brewly
│
├── domain
│   └── model
│       └── Product
│
├── frontend
│   ├── navigation
│   │   ├── NavGraph
│   │   └── Routes
│   │
│   ├── screens
│   │   ├── cartscreen
│   │   ├── detailsscreen
│   │   ├── favouritescreen
│   │   ├── homescreen
│   │   ├── profilescreen
│   │   └── welcomescreen
│   │
│   ├── theme
│   │   ├── Color
│   │   ├── Theme
│   │   └── Type
│   │
│   └── ui_components
│       ├── AppMessageDialog
│       └── MyBottomNavBar
│
└── MainActivity