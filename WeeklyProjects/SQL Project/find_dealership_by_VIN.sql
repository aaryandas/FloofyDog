#4 Find the dealership where a specific car is located, by VIN
select *
from dealerships
join inventory on dealerships.dealership_id = inventory.dealership_id
where inventory.VIN = 'JKL34567890129456';