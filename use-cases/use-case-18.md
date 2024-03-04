# USE CASE: 18 All the capital cities in a continent organised by largest population to smallest.

## Goal in Context

To provide the user with a sorted list of all capital cities in a specific continent, organized by population from largest to smallest.

## Scope

The system under consideration is responsible for retrieving and organizing capital city population data within a specified continent.

## Level

Primary Task

## Preconditions

- The system has access to a reliable dataset containing information about capital cities and their populations.
- The dataset distinguishes capital cities from other cities.
- Capital cities are correctly identified in the dataset.
- The user specifies the continent for which they want to retrieve the list of capital cities.

## Success End Condition

The user receives a sorted list of all capital cities within the specified continent, organized by population from largest to smallest.

## Failed End Condition

The user does not receive the sorted list of capital cities due to errors in data retrieval or if the dataset is unavailable.

## Primary Actor

User

## Trigger

User initiates the process to retrieve the list of capital cities organized by population within a specific continent.

## Main Success Scenario

1. User specifies the continent for which they want to retrieve the list of capital cities.
2. The system retrieves data of all capital cities within the specified continent and their populations.
3. The system sorts the capital cities based on their population, from largest to smallest.
4. The sorted list of all capital cities within the specified continent along with their populations is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
