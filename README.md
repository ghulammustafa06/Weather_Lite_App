
# Weather Lite App

The Weather Lite App is a simple weather application developed in Kotlin for Android devices. It allows users to search for weather information by city name and provides current weather data, including temperature, humidity, wind speed, sunrise, sunset, sea level pressure, and weather conditions. The app also displays an animated weather icon based on the current weather condition.


![IC_Launcher_weather](https://github.com/ghulammustafa06/MLSA-Task/assets/130176095/40a22b1f-bfc5-41fb-81bb-ee8dd09f9696)

## Features

- Search for weather information by city name
- Display current temperature in Celsius
- Show weather conditions (e.g., Sunny, Cloudy, Rainy)
- Provide maximum and minimum temperature for the day
- Display humidity percentage.
- Show wind speed in meters per second
- Display sunrise and sunset times
- Show sea level pressure in hPa
- Display the current day and date
- Animated weather icon based on weather conditions
- User-friendly interface with a search bar



## Technologies Used
- Kotlin
- XML
- Retrofit for API calls
- Gson for JSON parsing
- Lottie for animated weather icons
## Installation

To run the Weather Lite App on your Android device, follow these steps:

1. Clone this repository to your local machine.



```bash
  git clone https://github.com/your-username/weather-lite-app.git

```

2. Open the project in Android Studio.

3. Build and run the app on your Android device or emulator.



## Usage

1. Upon opening the app, you'll see a search bar at the top.

2. Enter the name of a city in the search bar and press Enter or the search button.

3. The app will fetch and display the current weather information for the entered city.

4. You can view details such as temperature, weather conditions, humidity, wind speed, sunrise, sunset, sea level pressure, day, and date.

5. The app also features an animated weather icon that reflects the current weather conditions.
## API Integration

The Weather Lite App uses the OpenWeatherMap API to fetch weather data. Make sure to replace the API key in the code with your own API key to ensure proper functionality.

```bash
  val response = retrofit.getWeatherData(cityName, "YOUR_API_KEY", "metric")

```
## FAQ

#### Question 1

The Weather Lite App is a mobile application developed for Android devices. It provides real-time weather information for cities worldwide. Users can search for weather data by city name and access details such as temperature, humidity, wind speed, and more.

#### 2. How do I install the Weather Lite App on my Android device?

To install the Weather Lite App on your Android device, follow these steps:

 - Clone the project     repository to your computer.
 -  Open the project in Android Studio.
 -  Build and run the app on your Android device or emulator.


#### 3. How do I search for weather information for a specific city?

On the Weather Lite App's main screen, you will find a search bar. Enter the name of the city you want to check the weather for and press Enter or the search button. The app will fetch and display the current weather data for that city.

#### 4. How does the animated weather icon work?

The animated weather icon changes based on the current weather conditions in the selected city. It uses Lottie animations to provide visual representations of weather, such as a sun for clear skies or raindrops for rainy weather.

#### 5. How do I change the API key for the OpenWeatherMap API??

To change the API key used to access weather data, open the project in Android Studio and locate the part of the code where the API key is specified. Replace the existing API key with your own key from the OpenWeatherMap website.
## Credits
- Weather icons provided by [LottieFiles](https://lottiefiles.com/) 

- Weather data powered by [OpenWeatherMap](https://openweathermap.org/)



## License

This project is licensed under the MIT License - see the [LICENSE](https://choosealicense.com/licenses/mit/) file for details.




## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/ghulammustafa06)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ghulammustafa06/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/GhulamM40961281)

