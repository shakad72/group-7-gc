Use world;

SELECT country.Name, country.Population
FROM country
WHERE country.continent = 'Europe'
ORDER BY country.Population DESC
LIMIT 14;
