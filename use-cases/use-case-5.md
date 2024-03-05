# USE CASE: 5 The top **N** populated countries in a continent where **N** is provided by me.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a user, I want to retrieve the top **N** populated countries in a specific continent, where **N** is specified by me, so that I can analyze the demographics and population distribution within that continent according to my preferences.

### Scope

Company.

### Level

Primary Task

### Preconditions

- We know the number of countries and continents. The system has access to a reliable dataset containing information about continents, countries and their populations.

### Success End Condition

A report of the top **N** populated countries within the specified continent, organized by population is produced.

### Failed End Condition

No report is produced.

### Primary Actor

Clerical User

### Trigger

I provide the value of **N** and select a continent to retrieve the top **N** populated countries.

## MAIN SUCCESS SCENARIO

1. I specify the value of **N**.
2. I select the continent from the available options.
3. The system retrieves data of all countries within the specified continent and their populations.
4. The system sorts the countries based on their population, from largest to smallest.
5. The system selects the top **N** countries based on my provided value and the continent.
6. The sorted list of the top **N** populated countries within the specified continent along with their populations is presented to me.

## EXTENSIONS

1. **Condition**: Data retrieval error
   - **Action**: The system notifies me about the error and terminates the process.

## SUB-VARIATIONS

- None

## SCHEDULE

**DUE DATE**: Release 1.0
