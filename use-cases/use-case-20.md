# USE CASE: 20 The top **N** populated capital cities in the world where **N** is provided by the user.

## Goal in Context

To provide the user with the option to retrieve the top **N** populated capital cities in the world, where **N** is specified by the user.

## Scope

The system under consideration is responsible for retrieving and organizing capital city population data globally.

## Level

Primary Task

## Preconditions

- The system has access to a reliable dataset containing information about capital cities and their populations.
- Capital cities are correctly identified in the dataset.

## Success End Condition

The user receives a list of the top **N** populated capital cities in the world, organized by population.

## Failed End Condition

The user does not receive the list of capital cities due to errors in data retrieval or if the dataset is unavailable.

## Primary Actor

User

## Trigger

User provides the value of **N** to specify the number of top populated capital cities they want to retrieve.

## Main Success Scenario

1. User specifies the value of **N**.
2. The system retrieves data of all capital cities and their populations.
3. The system sorts the capital cities based on their population, from largest to smallest.
4. The system selects the top **N** capital cities based on the user-provided value.
5. The sorted list of the top **N** populated capital cities in the world along with their populations is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
