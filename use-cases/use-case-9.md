# USE CASE: 9 All the cities in a region organised by largest population to smallest.

## Goal in Context

As a user, I want to sort a list of all cities in a specific region, organized by population from largest to smallest so that I can analyze the demographic landscape and identify the most populous cities within that particular region.

## Scope

Company

## Level

Primary Task

## Preconditions

- We know the region. The system has access to a reliable dataset containing information about cities and their populations.

## Success End Condition

A sorted list of all cities within the specified region, organized by population from largest to smallest is produced.

## Failed End Condition

No report is produced.

## Primary Actor

Clerical User

## Trigger

User initiates the process to retrieve the list of cities organized by population within a specific region.

## Main Success Scenario

1. User specifies the region for which they want to retrieve the list of cities.
2. The system retrieves data of all cities within the specified region and their populations.
3. The system sorts the cities based on their population, from largest to smallest.
4. The sorted list of all cities within the specified region along with their populations is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
