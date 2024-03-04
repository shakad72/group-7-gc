# USE CASE: The top N populated cities in a continent where N is provided by the user.

## Goal in Context

To provide the user with the option to retrieve the top N populated cities in a specific continent, where N is specified by the user.

## Scope

The system under consideration is responsible for retrieving and organizing city population data within a specified continent.

## Level

Primary Task

## Preconditions

- The system has access to a reliable dataset containing information about cities and their populations.
- The user specifies the value of N (number of cities) they want to retrieve.
- The user specifies the continent for which they want to retrieve the top N populated cities.

## Success End Condition

The user receives a list of the top N populated cities within the specified continent, organized by population.

## Failed End Condition

The user does not receive the list of cities due to errors in data retrieval or if the dataset is unavailable.

## Primary Actor

User

## Trigger

User provides the value of N and selects a continent to retrieve the top N populated cities.

## Main Success Scenario

1. User specifies the value of N.
2. User selects the continent from the available options.
3. The system retrieves data of all cities within the specified continent and their populations.
4. The system sorts the cities based on their population, from largest to smallest.
5. The system selects the top N cities based on the user-provided value and the continent.
6. The sorted list of the top N populated cities within the specified continent along with their populations is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
