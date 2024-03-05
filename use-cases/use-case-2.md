# USE CASE: 2 All the countries in a continent organised by largest population to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As a clerical user, I want to retrieve and organize country population data within a specified continent so that I can analyze demographic trends and understand population distributions in that particular continent.

### Scope

Company.

### Level

Primary Task

### Preconditions

- The system has access to a reliable dataset containing information about countries and their populations.
- I have specified the continent for which I want to organize the countries.

### Success End Condition

I receive a sorted list of countries within the specified continent, organized by population.

### Failed End Condition

I do not receive the sorted list due to errors in data retrieval or if the dataset is unavailable.

### Primary Actor

Clerical User

### Trigger

I select a continent to organize the countries by population.

## MAIN SUCCESS SCENARIO

1. I select a continent from the available options.
2. The system retrieves data of all countries within the specified continent.
3. The system sorts the countries based on their population, from largest to smallest.
4. The sorted list of countries along with their populations is presented to me.

## EXTENSIONS

1. **Condition**: Data retrieval error
   - **Action**: The system notifies me about the error and terminates the process.

## SUB-VARIATIONS

- None

## SCHEDULE

**DUE DATE**: Release 1.0
