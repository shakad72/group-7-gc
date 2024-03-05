Use world;
SELECT country.name, country.Population
FROM Country
WHERE country.Continent = 'Europe'
ORDER BY Country.Population DESC;
