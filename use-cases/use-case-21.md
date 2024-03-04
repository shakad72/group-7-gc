# USE CASE: 21 The top **N** populated capital cities in a continent where **N** is provided by the user.

## Goal in Context

As a user, I want to retrieve the top **N** populated capital cities in a specific continent so that I can have insights into the most populous capital cities in that continent.

## Scope

The system under consideration is responsible for retrieving and organizing population data of capital cities within a specified continent.

## Level

Primary Task

## Preconditions

- The system has access to a reliable dataset containing information about capital cities and their populations.
- The user specifies the continent for which they want to retrieve the top **N** populated capital cities.

## Success End Condition

The user receives a sorted list of the top **N** populated capital cities within the specified continent.

## Failed End Condition

The user does not receive the sorted list of capital cities due to errors in data retrieval or if the dataset is unavailable.

## Primary Actor

User

## Trigger

User initiates the process to retrieve the top **N** populated capital cities within a specific continent.

## Main Success Scenario

1. User specifies the continent for which they want to retrieve the top **N** populated capital cities.
2. The system retrieves data of all capital cities within the specified continent and their populations.
3. The system sorts the capital cities based on their population, from largest to smallest.
4. The system selects the top **N** capital cities based on the user-provided value and the continent.
5. The sorted list of the top **N** populated capital cities within the specified continent is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
