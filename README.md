# ImgurAPIDemo
It is an native Android App that searches for the top images of the week from the Imgur gallery and display it in a list. It is developed in Java. This app retrieves data from a Imgur API using Retrofit2,and it uses Retrofit2 Gson converter for absorving the JSON response.

# Instruction to run the app
Step 1: Download the zip file or Clone with HTTPS in the Android studio

Step 2: Extract the zip folder

Step 3: Open the extracted project in android studio.

Step 4: Change the sdk.dir path in local.properties to your path.

Step 5: Run the project by cliking on the RUN button in the Android Studio


# Features in the app
1. Allows user to enter text for searching images.

2. Searches for the top images of the week from the Imgur gallery. 

3. Displays the Images in the Grid view with the following details:

      a) image
  
      b) title
  
      c) date of post in local time (DD/MM/YYYY h:mm a)
  
      d) number of additional images in post (if there are multiple)
  
4. Displays the first image from the list, if a search result contains multiple images.

5. Display images sorted in reverse chronological order.

6. Toggle buttons includes below features:

      a) If toggle is enabled, the app should only display results where the sum of “points”,
          “score” and “topic_id” adds up to an even number
      
      b) If the toggle is disabled, the app should display all results

  
 
