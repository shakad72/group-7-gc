# USE CASE: 18 All the capital cities in a continent organised by largest population to smallest.

## Goal in Context

As a user, I want a sorted list of all capital cities in a specific continent, organized by population from largest to smallest so that I can analyze the demographic landscape of capital cities within that continent.

## Scope

Company

## Level

Primary Task

## Preconditions

- We know the continent. The system has access to a reliable dataset containing information about capital cities and their populations.
- The dataset distinguishes capital cities from other cities.
- Capital cities are correctly identified in the dataset.

## Success End Condition

A report with a sorted list of all capital cities within the specified continent, organized by population from largest to smallest is produced.

## Failed End Condition

No report is produced. 

## Primary Actor

Clerical User

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
