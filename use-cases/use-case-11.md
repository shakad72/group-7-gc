# USE CASE: 11 All the cities in a district organised by largest population to smallest.

## Goal in Context

To provide the user with a sorted list of all cities in a specific district, organized by population from largest to smallest.

## Scope

The system under consideration is responsible for retrieving and organizing city population data within a specified district.

## Level

Primary Task

## Preconditions

- The system has access to a reliable dataset containing information about cities and their populations.
- The user specifies the district for which they want to retrieve the list of cities.

## Success End Condition

The user receives a sorted list of all cities within the specified district, organized by population from largest to smallest.

## Failed End Condition

The user does not receive the sorted list of cities due to errors in data retrieval or if the dataset is unavailable.

## Primary Actor

User

## Trigger

User initiates the process to retrieve the list of cities organized by population within a specific district.

## Main Success Scenario

1. User specifies the district for which they want to retrieve the list of cities.
2. The system retrieves data of all cities within the specified district and their populations.
3. The system sorts the cities based on their population, from largest to smallest.
4. The sorted list of all cities within the specified district along with their populations is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
