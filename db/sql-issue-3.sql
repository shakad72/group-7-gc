Use world;
SELECT country.Name, country.Population
FROM country
WHERE country.region = 'Western Europe'
ORDER BY country.Population DESC;
