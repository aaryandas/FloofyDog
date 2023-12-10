#2 Find all vehicles for a specific dealership
select Vehicles.*
from vehicles
join inventory on vehicles.VIN = inventory.vin
where inventory.dealership_id = 1;