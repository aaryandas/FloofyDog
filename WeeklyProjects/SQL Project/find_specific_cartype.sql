#5 Find all dealerships that have a specific car type
select * 
from dealerships
join inventory on dealerships.dealership_id = inventory.dealership_id
join vehicles on inventory.VIN = vehicles.VIN
where vehicles.vehicleType = 'Supercar';
