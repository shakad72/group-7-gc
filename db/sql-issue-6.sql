Use world;

SELECT country.Name, Country.Population
FROM country
WHERE Country.region = 'Western Europe'
ORDER BY Country.Population DESC
LIMIT 10;
