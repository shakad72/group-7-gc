# USE CASE: 3 All the countries in a region organised by largest population to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As a user, I want to organize all the countries within a specific region by their population, from largest to smallest, so that I can provide valuable insights into the demographics of that region.

### Scope

Company

### Level

Primary Task

### Preconditions

- We know the Region. The system has access to a reliable dataset containing information about countries and their populations.

### Success End Condition

A sorted list of countries within the specified region, organized by population.

### Failed End Condition

No report is produced.

### Primary Actor

Clerical user.

### Trigger

Clerical user selects a region to organize the countries by population.

## MAIN SUCCESS SCENARIO

1. Clerical user selects a region from the available options.
2. The system retrieves data of all countries within the specified region.
3. The system sorts the countries based on their population, from largest to smallest.
4. The sorted list of countries along with their populations is presented to the user.

## EXTENSIONS

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the Clerical user about the error and terminates the process.

## SUB-VARIATIONS

- None

## SCHEDULE

**DUE DATE**: Release 1.0
