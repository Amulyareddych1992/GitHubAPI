# GitHub Repositories Viewer

An Android application built using Kotlin that interacts with the GitHub API to fetch and display repositories for a specific user or organization. The app supports filtering repositories by programming language, shows detailed information for selected repositories, implements pagination for loading more repositories, and handles errors gracefully.

## Features

### 1. List of Repositories
- Fetches and displays a list of repositories for a specified GitHub user or organization.
- Shows key information including:
  - Repository name
  - Description
  - Programming language
  - Number of stars
  - Number of forks

### 2. Filtering
- Allows the user to filter repositories based on the programming language (e.g., Kotlin, Java).

### 3. Repository Details
- Displays additional information when a repository is selected, including:
  - Detailed description
  - Owner information
  - Last updated date

### 4. Pagination
- Implements pagination to load more repositories as the user scrolls down the list.

### 5. Error Handling
- Displays appropriate error messages in case of:
  - API rate limits
  - Network failures
  - Other unexpected issues

## API Information

- **Endpoint**: [https://api.github.com/users/{username}/repos](https://api.github.com/users/{username}/repos)
- **Example Request**: [https://api.github.com/users/google/repos](https://api.github.com/users/google/repos)

For further details, refer to the [GitHub API Documentation](https://docs.github.com/en/rest).

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/github-repo-viewer.git
   ```
2. Open the project in Android Studio.
3. Build the project and run the app on an emulator or physical device.

## Usage

1. Enter a GitHub username or organization name to fetch and display the repositories.
2. Use the filter option to filter repositories by programming language.
3. Scroll down to load more repositories (pagination feature).
4. Tap on any repository to view its detailed information.

## App Architecture

### 1. MainActivity.kt
- Handles fetching repositories, filtering by language, and implementing pagination.
- Uses `Retrofit` to make API requests and display data in a `RecyclerView` with `EndlessRecyclerViewScrollListener` for pagination.

### 2. RepositoryAdapter.kt
- Adapter for displaying repository information in a `RecyclerView`.
- Binds repository details like name, description, language, stars, and forks.

### 3. RepositoryDetailActivity.kt
- Displays detailed information for a selected repository.
- Uses an Intent to pass the repository data between activities.

### 4. EndlessRecyclerViewScrollListener.kt
- Helper class for implementing infinite scrolling (pagination) in `RecyclerView`.

### 5. GitHubApiService.kt
- Retrofit service interface for GitHub API requests.
- Defines methods for fetching repositories and configuring the Retrofit instance.

### 6. Repository.kt
- Data model class for representing a GitHub repository, using Gson annotations for JSON parsing.

## Testing

- **Unit Tests**: Validate the logic for fetching and filtering repositories using JUnit.
- **UI Tests**: Validate user interactions like scrolling, repository selection, and error handling using Espresso.

To run tests:
1. Open the `Test` directory in Android Studio.
2. Run the tests using the Android Studio testing framework.

## Dependencies

The app uses the following libraries and frameworks:
- **Retrofit**: For API communication.
- **Gson**: For JSON parsing.
- **Glide**: For image loading.
- **RecyclerView**: For displaying lists.
- **Paging Library**: For implementing pagination.
- **ViewModel and LiveData**: For managing UI-related data and lifecycle.
- **JUnit and Espresso**: For testing.

## Error Handling

- **API Rate Limits**: The app shows an appropriate message when the GitHub API rate limit is reached.
- **Network Failures**: A retry option is provided in case of a network error.
- Error messages are displayed using Toasts or Snackbars.

## Screenshots

Include screenshots here to showcase the app’s features and functionality (optional).

## Contribution

Feel free to contribute by opening a pull request. For major changes, please open an issue first to discuss your proposed modifications.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
