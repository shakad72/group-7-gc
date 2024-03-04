# USE CASE: 14 The top **(N)** populated cities in a region where **(N)** is provided by the user.

## Goal in Context

As a user, I want the option to retrieve the top **(N)** populated cities in a specific region, where **(N)** is specified, so that I can obtain a list of the most populous cities within that region. 

## Scope

Company

## Level

Primary Task

## Preconditions

- We know the region for the top **(N)** populated cities. The system has access to a reliable dataset containing information about cities and their populations.

## Success End Condition

A list of the top **(N)** populated cities within the specified region, organized by population is produced.

## Failed End Condition

No report is produced.

## Primary Actor

Clerical User

## Trigger

User provides the value of **(N)** and selects a region to retrieve the top **(N)** populated cities.

## Main Success Scenario

1. User specifies the value of **(N)**.
2. User selects the region from the available options.
3. The system retrieves data of all cities within the specified region and their populations.
4. The system sorts the cities based on their population, from largest to smallest.
5. The system selects the top **(N)** cities based on the user-provided value and the region.
6. The sorted list of the top **(N)** populated cities within the specified region along with their populations is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
