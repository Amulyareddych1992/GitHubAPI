**GitHub Repositories Viewer**
This project is an Android application that fetches and displays repositories for a specified GitHub user or organization using the GitHub API. Users can filter repositories by programming language, view detailed information about each repository, and paginate through the list as they scroll.

**Features**
Fetch GitHub Repositories: Displays repositories for a given GitHub user.
Language Filter: Users can filter repositories by programming language.
Repository Details: Displays detailed information for each repository.
Pagination: Loads more repositories as the user scrolls.
Error Handling: Provides error messages for network issues and API failures.

**Technologies Used**
Kotlin: Primary programming language.
Retrofit: For making API requests.
RecyclerView: To display the list of repositories.
Android Architecture Components: To maintain clean and maintainable code.
View Binding: To bind views in activities and RecyclerView.
Gson: For JSON serialization/deserialization.
GitHub API: To retrieve repository data.

**Prerequisites**
Make sure you have the following installed:

1. Android Studio (latest version recommended)
2. Android SDK (API Level 21 or higher)
3. Internet Connection (to make API requests)

**Installation**
Clone the repository to your local machine:

git clone https://github.com/your-username/github-repositories-viewer.git
Open the project in Android Studio.

Sync the project with Gradle files by clicking "Sync Now" if prompted.

Connect an Android device or start an emulator.

**Execution**
Build and run the project:

Click on the Run button or use the shortcut Shift + F10.
The app will launch, and by default, it fetches repositories for the GitHub user google.

To filter repositories by language:

Enter the programming language in the input field and click the Filter button.
Scroll through the list to see more repositories as they load automatically (pagination is implemented).

**Project Structure**
MainActivity.kt: The main activity that handles the display of repositories and user interactions.
RepositoryAdapter.kt: Adapter class for managing the display of repository data in the RecyclerView.
Repository.kt: Data model representing a GitHub repository.
GitHubApiService.kt: Interface for making API calls using Retrofit.
RepositoryDetailActivity.kt: Activity that shows detailed information about a selected repository.
pagination/EndlessRecyclerViewScrollListener.kt: Custom listener for implementing infinite scrolling in the RecyclerView.
AndroidManifest.xml: Application manifest file containing app configuration.

**API Configuration**
The app uses the GitHub REST API. No authentication is required for fetching public repositories. However, if you plan to increase API limits, you can configure personal access tokens and include them in your API requests.

**Error Handling**
Network Error: If the device is offline or if the API request fails, a Toast message displays the error.
Empty or Invalid Response: If no repositories are returned or if the response fails, the app displays an error message.

**Customization**
To change the default GitHub user:
Update the username variable in MainActivity.kt.
Modify the app's design and layout using XML files located in the res/layout directory.


