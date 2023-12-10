select * from vehicles;

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`,
`yearMade`,
`make`,
`model`,
`color`,
`vehicleType`,
`odometer`,
`price`,
`sold`)
VALUES
('AB912345678901234',
'2020',
'Toyota',
'Yaris',
'Blue',
'Compact',
'30000',
'15000',
1);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`,
`yearMade`,
`make`,
`model`,
`color`,
`vehicleType`,
`odometer`,
`price`,
`sold`)
VALUES
('GHI90123406789012',
'2021',
'Ford',
'Explorer',
'Black',
'Compact',
'30000',
'15000',
1);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`,
`model`, 
`color`, 
`vehicleType`, 
`odometer`, 
`price`, 
`sold`)
VALUES
('JKL34567890629456', 
'2022', 
'Lamborghini', 
'Huracan', 
'Red', 
'Supercar', 
'5000', 
'250000', 
0);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`, 
`color`, 
`vehicleType`,
`odometer`, 
`price`, 
`sold`)
VALUES
('MNO76901234567890', 
'2018', 
'Chevrolet', 
'Silverado', 
'White', 
'Truck', 
'60000', 
'25000', 
1);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`, 
`color`, 
`vehicleType`, 
`odometer`, 
`price`,
`sold`)
VALUES
('PQR12349878901234', 
'2017', 
'Volkswagen', 
'Golf', 
'Yellow', 
'Compact', 
'35000', 
'18000', 
0);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`, 
`color`, 
`vehicleType`,
`odometer`, 
`price`, 
`sold`)
VALUES
('STU56789012345678', 
'2020', 
'Nissan', 
'Altima', 
'Gray', 
'Sedan', 
'32000', 
'22000', 
1);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`, 
`color`, 
`vehicleType`,
`odometer`, 
`price`, 
`sold`)
VALUES
('VWX90129456789012', 
'2019', 
'Subaru', 
'Outback', 
'Green', 
'SUV', 
'38000', 
'28000', 
0);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`, 
`color`, 
`vehicleType`, 
`odometer`, 
`price`, 
`sold`)
VALUES
('YZ012345678901234', 
'2021', 
'Ferrari', 
'488 GTB', 
'Blue', 
'Supercar', 
'8000', 
'300000', 
1);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`, 
`color`, 
`vehicleType`, 
`odometer`, 
`price`, 
`sold`)
VALUES
('DEF56799012345978', 
'2022', 
'GMC', 
'Sierra', 
'Black', 
'Truck', 
'15000', 
'35000', 
0);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`, 
`color`, 
`vehicleType`, 
`odometer`, 
`price`, 
`sold`)
VALUES
('DEF56789012349678', 
'2018', 
'Ford', 
'Fiesta', 
'Red', 
'Compact', 
'45000', 
'14000', 
1);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`,
`make`, 
`model`, 
`color`,
`vehicleType`,
`odometer`, 
`price`,
`sold`)
VALUES
('GHI90123459489012', 
'2020', 
'Hyundai', 
'Sonata', 
'Silver', 
'Sedan', 
'28000', 
'19000',
0);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`,
`color`,
`vehicleType`, 
`odometer`, 
`price`, 
`sold`)
VALUES
('JKL34567890193456', 
'2019', 
'Jeep', 
'Grand Cherokee', 
'Blue', 
'SUV', 
'37000', 
'27000', 
1);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`, 
`color`, 
`vehicleType`, 
`odometer`, 
`price`, 
`sold`)
VALUES
('MNO78909234567890', 
'2022', 
'McLaren', 
'720S', 
'Orange', 
'Supercar', 
'3000', 
'280000', 
0);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`,
`color`, 
`vehicleType`,
`odometer`, 
`price`, 
`sold`)
VALUES
('PQR12345679901234', 
'2017', 
'Ram', 
'1500', 
'White', 
'Truck', 
'55000', 
'26000', 
1);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`, 
`color`,
`vehicleType`, 
`odometer`,
`price`, 
`sold`)
VALUES
('PQR17345678901934', 
'2017', 
'Ram', 
'1500', 
'White', 
'Truck', 
'55000', 
'26000', 
1);

INSERT INTO `cardealershipdatabase`.`vehicles`
(`VIN`, 
`yearMade`, 
`make`, 
`model`, 
`color`, 
`vehicleType`,
`odometer`, 
`price`, 
`sold`)
VALUES
('STU56789012345978', 
'2016', 
'Chevrolet', 
'Spark',
'Purple', 
'Compact', 
'50000', 
'13000', 
0);

INSERT INTO inventory 
(dealership_id,
VIN) 
VALUES 
(1, 
'JKL34567890129456');

INSERT INTO Sales_Contracts 
(dealership_id, 
customerDate, 
customerName, 
customerEmail, 
VIN, 
totalPrice, 
monthlyPayment, 
salesTaxAmount, 
recordingFee, 
processingFee, 
totalAmount, 
isFinance, 
interestRate)
VALUES 
(1, 
'2023-01-15', 
'John Doe', 
'john.doe@email.com', 
'JKL34567890129456', 
250000, 
2000, 
1500, 
100, 
200, 
18700, 
1, 
3.5);
