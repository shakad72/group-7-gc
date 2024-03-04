# USE CASE: 19 All the capital cities in a region organised by largest to smallest.

## Goal in Context

As a user, I want a sorted list of all capital cities in a specific region, organized by population from largest to smallest so that I can gain insights into the demographic landscape of capital cities within that particular region.

## Scope

Company

## Level

Primary Task

## Preconditions

- We know the region. The system has access to a reliable dataset containing information about capital cities and their populations.

## Success End Condition

A report with a sorted list of all capital cities within the specified region, organized by population from largest to smallest is produced.

## Failed End Condition

No report is produced. 

## Primary Actor

Clerical User

## Trigger

User initiates the process to retrieve the list of capital cities organized by population within a specific region.

## Main Success Scenario

1. User specifies the region for which they want to retrieve the list of capital cities.
2. The system retrieves data of all capital cities within the specified region and their populations.
3. The system sorts the capital cities based on their population, from largest to smallest.
4. The sorted list of all capital cities within the specified region along with their populations is presented to the user.

## Extensions

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## Sub-variations

- None

## Schedule

**DUE DATE**: Release 1.0
