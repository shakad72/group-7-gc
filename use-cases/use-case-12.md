# USE CASE: 12 The top **N** populated cities in the world where **N** is provided by the user.

## Goal in Context

To provide the user with the option to retrieve the top **N** populated cities in the world, where **N** is specified by the user.

## Scope

The system under consideration is responsible for retrieving and organizing city population data globally.

## Level

Primary Task

## Preconditions

- The system has access to a reliable dataset containing information about cities and their populations.
- The user specifies the value of **N** (number of cities) they want to retrieve.

## Success End Condition

The user receives a list of the top **N** populated cities in the world, organized by population.

## Failed End Condition

The user does not receive the list of cities due to errors in data retrieval or if the dataset is unavailable.

## Primary Actor

User

## Trigger

User provides the value of **N** to retrieve the top **N** populated cities.

## Main Success Scenario

1. User specifies the value of **N**.
2. The system retrieves data of all cities and their populations.
3. The system sorts the cities based on their population, from largest to smallest.
4. The system selects the top **N** cities based on the user-provided value.
5. The sorted list of the top **N** populated cities along with their populations is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
