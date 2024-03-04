# USE CASE: 6 The top **(N)**  populated countries in a region where **(N)**  is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a user, I want to retrieve the top **(N)**  populated countries in a specific region, where **(N)**  is specified, so that I can gain insights into the most populous countries within that region and understand the demographic trends and distributions according to my preferences.

### Scope

company.

### Level

Primary Task

### Preconditions

We know the **(N)**  of populated countries and the region. The system has access to a reliable dataset containing information about countries and their populations.

### Success End Condition

A report with a list of the top **(N)**  populated countries within the specified region, organized by population is produced.

### Failed End Condition

No report is produced.

### Primary Actor

Clerical User

### Trigger

I provide the value of **(N)**  and select a region to retrieve the top **(N)**  populated countries.

## MAIN SUCCESS SCENARIO

1. User specifies the value of **(N)**.
2. User selects the region from the available options.
3. The system retrieves data of all countries within the specified region and their populations.
4. The system sorts the countries based on their population, from largest to smallest.
5. The system selects the top **(N)**  countries based on the user-provided value and the region.
6. The sorted list of the top **(N)**  populated countries within the specified region along with their populations is presented to the user.

## EXTENSIONS

1. **Condition**: Data retrieval error
   - **Action**: The system notifies the user about the error and terminates the process.

## SUB-VARIATIONS

- None

## SCHEDULE

**DUE DATE**: Release 1.0
