# USE CASE: 10 All the cities in a country organised by largest population to smallest.

## Goal in Context

As a user, I want to sort a list of all cities in a specific country, organized by population from largest to smallest so that I can easily identify the most populous cities within the country.

## Scope

Company

## Level

Primary Task

## Preconditions

- We know the country. The system has access to a reliable dataset containing information about cities and their populations.

## Success End Condition

A sorted list of all cities within the specified country, organized by population from largest to smallest is produced.

## Failed End Condition

No report is produced.

## Primary Actor

Clerical User

## Trigger

User initiates the process to retrieve the list of cities organized by population within a specific country.

## Main Success Scenario

1. User specifies the country for which they want to retrieve the list of cities.
2. The system retrieves data of all cities within the specified country and their populations.
3. The system sorts the cities based on their population, from largest to smallest.
4. The sorted list of all cities within the specified country along with their populations is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
