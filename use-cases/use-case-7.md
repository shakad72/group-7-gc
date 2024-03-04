# USE CASE: 7 All the cities in the world organised by largest population to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

To provide the user with a sorted list of all cities in the world, organized by population from largest to smallest.

### Scope

The system under consideration is responsible for retrieving and organizing city population data globally.

### Level

Primary Task

### Preconditions

- The system has access to a reliable dataset containing information about cities and their populations.

### Success End Condition

The user receives a sorted list of all cities in the world, organized by population from largest to smallest.

### Failed End Condition

The user does not receive the sorted list of cities due to errors in data retrieval or if the dataset is unavailable.

### Primary Actor

User

### Trigger

User initiates the process to retrieve the list of cities organized by population.

## MAIN SUCCESS SCENARIO

1. User initiates the process to retrieve the list of cities.
2. The system retrieves data of all cities and their populations.
3. The system sorts the cities based on their population, from largest to smallest.
4. The sorted list of all cities along with their populations is presented to the user.

## EXTENSIONS

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## SUB-VARIATIONS

- None

## SCHEDULE

**DUE DATE**: Release 1.0
