# USE CASE: 6 The top **N** populated countries in a region where **N** is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

To provide the user with the option to retrieve the top **N** populated countries in a specific region, where **N** is specified by the user.

### Scope

The system under consideration is the component responsible for retrieving and organizing country population data within a specified region.

### Level

Primary Task

### Preconditions

- The system has access to a reliable dataset containing information about countries and their populations.
- The user specifies the value of **N** (number of countries) they want to retrieve.
- The user specifies the region for which they want to retrieve the top **N** populated countries.

### Success End Condition

The user receives a list of the top **N** populated countries within the specified region, organized by population.

### Failed End Condition

The user does not receive the list of countries due to errors in data retrieval or if the dataset is unavailable.

### Primary Actor

User

### Trigger

User provides the value of **N** and selects a region to retrieve the top **N** populated countries.

## MAIN SUCCESS SCENARIO

1. User specifies the value of **N**.
2. User selects the region from the available options.
3. The system retrieves data of all countries within the specified region and their populations.
4. The system sorts the countries based on their population, from largest to smallest.
5. The system selects the top **N** countries based on the user-provided value and the region.
6. The sorted list of the top **N** populated countries within the specified region along with their populations is presented to the user.

## EXTENSIONS

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## SUB-VARIATIONS

- None

## SCHEDULE

**DUE DATE**: Release 1.0
