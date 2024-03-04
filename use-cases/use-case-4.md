# USE CASE: 4 The top **N** populated countries in the world where **N** is provided by me.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a user, I want the option to retrieve the top **N** populated countries in the world, where **N** is specified by me, so that I can gain insights into the most populous countries according to my preferences.

### Scope

Company.

### Level

Primary Task

### Preconditions

- The system has access to a reliable dataset containing information about countries and their populations.
- I specify the value of **N** *(number of countries)* I want to retrieve.

### Success End Condition

I receive a list of the top **N** populated countries in the world, organized by population.

### Failed End Condition

No report is produced.

### Primary Actor

Clerical User

### Trigger

I provide the value of N to retrieve the top **N** populated countries.

## MAIN SUCCESS SCENARIO

1. I specify the value of **N**.
2. The system retrieves data of all countries and their populations.
3. The system sorts the countries based on their population, from largest to smallest.
4. The system selects the top **N** countries based on the user-provided value.
5. The sorted list of the top **N** populated countries along with their populations is presented to me.

## EXTENSIONS

1. **Condition**: Data retrieval error
   - **Action**: The system notifies me about the error and terminates the process.

## SUB-VARIATIONS

- None

## SCHEDULE

**DUE DATE**: Release 1.0
