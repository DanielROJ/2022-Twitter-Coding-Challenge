# GitHub Readme for the Code

## Log Extraction

This code provides a solution for log extraction based on a set of rules and constraints. It is a part of the [2022 Twitter Coding Challenge](https://github.com/5j54d93/2022-Twitter-Coding-Challenge/tree/main/1.%20Sign-in%20Sign-out%20Logs).

## Problem Description

The task is to extract specific logs from a given list of logs based on certain conditions. The logs consist of user IDs, timestamps, and types of actions (sign-in or sign-out). The goal is to extract the user IDs of those users who have signed out within a specific time span.

## Solution

The provided code implements a method called `ExtractLogs` that takes a list of logs and a maximum time span as input parameters. It returns a list of user IDs who have signed out within the given time span.

### Algorithm

1. Initialize an empty list called `result` to store the extracted user IDs.
2. Create a `Map` called `organizer` to keep track of sign-in timestamps for each user.
3. Iterate through each log in the input list:
    - Split the log into its components (user ID, timestamp, and action type).
    - If the action type is "sign-in", add the user ID and timestamp to the `organizer` map.
    - If the action type is "sign-out" and the `organizer` map contains the user ID:
        - Get the sign-in timestamp for the user.
        - Calculate the time difference between the sign-in and sign-out timestamps.
        - If the time difference is less than or equal to the maximum time span, add the user ID to the `result` list.
4. Sort the `result` list in ascending order.
5. Convert the `result` list of integers to a list of strings.
6. Return the resulting list of user IDs.

### Usage

To test the code with a sample input, the `main` method is provided. It creates a list of logs and calls the `ExtractLogs` method with a maximum time span of 20. The extracted user IDs are then printed to the console.

You can modify the sample input in the `main` method to test the code with different scenarios.

## Conclusion

This code provides a solution for extracting specific logs based on time constraints. It demonstrates the use of data structures like lists and maps, as well as string manipulation and sorting. Feel free to use and modify this code according to your requirements.

If you have any questions or suggestions, please feel free to reach out.
