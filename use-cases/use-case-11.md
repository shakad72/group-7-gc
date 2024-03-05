# USE CASE: 11 All the cities in a district organised by largest population to smallest.

## Goal in Context

As a user, I want to sort a list of all cities in a specific district, organized by population from largest to smallest so that I can identify the most populous cities within the district.

## Scope

Company

## Level

Primary Task

## Preconditions

- We know the district. The system has access to a reliable dataset containing information about cities and their populations.

## Success End Condition

A sorted list of all cities within the specified district, organized by population from largest to smallest is produced.

## Failed End Condition

No report is produced.

## Primary Actor

Clerical User

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
