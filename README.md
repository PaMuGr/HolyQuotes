# 📖 QuoteApp - Bible Verses

A beautiful Android app built with Jetpack Compose that displays inspirational Bible verses with swipe gestures and favorites functionality.

<p align="center">
  <img src="app/src/main/java/com/example/quoteapp/assets/images/logo.png" width="150">
</p>

## :ledger: Index

- [About](#beginner-about)
- [Usage](#zap-usage)
    - [Installation](#electric_plug-installation)
- [Development](#wrench-development)
    - [Pre-Requisites](#notebook-pre-requisites)
    - [Development Environment](#nut_and_bolt-development-environment)
    - [File Structure](#file_folder-file-structure)
    - [Build](#hammer-build)
    - [Deployment](#rocket-deployment)
- [Community](#cherry_blossom-community)
    - [Contribution](#fire-contribution)
    - [Guideline](#exclamation-guideline)
- [FAQ](#question-faq)
- [Resources](#page_facing_up-resources)
- [Gallery](#camera-gallery)
- [Credit/Acknowledgment](#star2-creditacknowledgment)

##  :beginner: About
**QuoteApp** is a Android application designed to provide daily inspiration through Bible verses. Built with **Jetpack Compose** and **Material Design 3**, it offers a seamless user experience with intuitive swipe gestures, favorites management, and social sharing capabilities.

## :zap: Usage
The app is simple and intuitive to use:

1. **Swipe Navigation**: Swipe left/right to browse through different Bible verses
2. **Favorites**: Tap the heart icon to add/remove verses from favorites
3. **Sharing**: Use the share icon to share verses with others
4. **Tabs**: Switch between "Versículos" and "Favoritos" tabs

###  :electric_plug: Installation
- Coming soon

##  :wrench: Development
We welcome contributions from the developer community!
See [Development Environment](#nut_and_bolt-development-environment)!

### :notebook: Pre-Requisites
- **Android Studio** (Arctic Fox or later)
- **Android SDK** (API 21+)
- **Java 17** or higher
- **Git** for version control

###  :nut_and_bolt: Development Environment
1.  Clone the repository


        git clone https://github.com/YOUR_USERNAME/QuoteApp.git
        cd QuoteApp

2.  Open in Android Studio

-   Open Android Studio
-   Select “Open an existing project”
-   Navigate to the cloned QuoteApp folder

3.  Sync and Build
-   Android Studio will automatically sync Gradle files
-   Build the project (Build → Make Project)

###  :file_folder: File Structure
Add a file structure here with the basic details about files, below is an example.

```
QuoteApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/quoteapp/
│   │   │   ├── data/              # Data sources and static data
│   │   │   │   └── QuotesData.kt
│   │   │   ├── model/             # Data models
│   │   │   │   └── Quote.kt
│   │   │   ├── repository/        # Data handling logic
│   │   │   │   └── QuoteRepository.kt
│   │   │   ├── ui/               # UI components
│   │   │   │   ├── main/         # Main screen components
│   │   │   │   │   ├── MainActivity.kt
│   │   │   │   │   ├── HelloApp.kt
│   │   │   │   │   ├── AppLayout.kt
│   │   │   │   │   ├── QuotesScreen.kt
│   │   │   │   │   ├── FavoritesScreen.kt
│   │   │   │   │   ├── QuoteComponents.kt
│   │   │   │   │   └── Preview.kt
│   │   │   │   └── theme/        # Theme and styling
│   │   │   │       ├── Color.kt
│   │   │   │       ├── Theme.kt
│   │   │   │       └── Type.kt
│   │   │   └── utils/            # Utility functions
│   │   │       ├── ShareUtils.kt
│   │   │       └── Constants.kt
│   │   ├── res/                  # Resources
│   │   │   ├── values/
│   │   │   ├── layout/
│   │   │   └── drawable/
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
└── README.md
```

| No | File/Folder     | Details                                 |
|----|------------------|-----------------------------------------|
| 1  | `ui/main/`       | Main application screens and components |
| 2  | `data/`          | Static data and data sources            |
| 3  | `repository/`    | Data handling and business logic        |
| 4  | `model/`         | Data models and structures              |
| 5  | `ui/theme/`      | App theme, colors, and typography       |

###  :hammer: Build
    ./gradlew assembleDebug

### :rocket: Deployment
    ./gradlew assembleRelease

###  :fire: Contribution

Your contributions are always welcome and appreciated. Following are the things you can do to contribute to this project.

1. **Report a bug** <br>
   If you think you have encountered a bug, and I should know about it, feel free to report it and I will take care of it.

2. **Request a feature** <br>
   You can also request for a feature

3. **Create a pull request** <br>
   It can't get better then this, your pull request will be appreciated

### :exclamation: Guideline
- Follow Kotlin coding conventions
- Use meaningful variable names
- Write clean, readable code 
- Add comments for complex logic
- Test on multiple screen sizes
- Follow Material Design 3 guidelines

##  :page_facing_up: Resources

- **Jetpack Compose Documentation**  
  https://developer.android.com/compose

- **Material Design 3**  
  https://m3.material.io/

- **Kotlin Documentation**  
  https://kotlinlang.org/docs/home.html

- **Android Studio Course**  
  https://developer.android.com/studio/intro?hl=es-419

- **Kotlin Course**  
  https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1?hl=es-419#codelab-https://developer.android.com/codelabs/basic-android-kotlin-compose-before-you-begin

##  :camera: Gallery
Coming Soon

## :star2: Credit/Acknowledgment
https://github.com/PaMuGr