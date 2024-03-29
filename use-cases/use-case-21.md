# USE CASE: 21 The top **(N)** populated capital cities in a continent where **(N)** is provided by the user.

## Goal in Context

As a user, I want to retrieve the top **(N)** populated capital cities in a specific continent so that I can have insights into the most populous capital cities in that continent.

## Scope

Company

## Level

Primary Task

## Preconditions

- We know the continent and **(N)**. The system has access to a reliable dataset containing information about capital cities and their populations.

## Success End Condition

A report of the top **(N)** populated capital cities within the specified continent is produced.

## Failed End Condition

No report is produced. 

## Primary Actor

Clerical User

## Trigger

User initiates the process to retrieve the top **(N)** populated capital cities within a specific continent.

## Main Success Scenario

1. User specifies the continent for which they want to retrieve the top **(N)** populated capital cities.
2. The system retrieves data of all capital cities within the specified continent and their populations.
3. The system sorts the capital cities based on their population, from largest to smallest.
4. The system selects the top **(N)** capital cities based on the user-provided value and the continent.
5. The sorted list of the top **(N)** populated capital cities within the specified continent is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
