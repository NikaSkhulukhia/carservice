INSERT INTO mydb.Users (first_name, last_name, id_number, phone, email, address, member_since) VALUES ('Jane', 'Doe', '0987654321', '0987654321', 'janedoe@email.com', '456 Park Ave', '2022-01-01');
INSERT INTO mydb.Users (first_name, last_name, id_number, phone, email, address, member_since) VALUES ('Mike', 'Smith', '2345678901', '2345678901', 'mikesmith@email.com', '789 Elm St', '2022-02-01');
INSERT INTO mydb.Users (first_name, last_name, id_number, phone, email, address, member_since) VALUES ('Sara', 'Johnson', '3456789012', '3456789012', 'sarajohnson@email.com', '111 Oak St', '2022-03-01');

INSERT INTO mydb.Car_brands (name, country_of_origin) VALUES ('Ford', 'USA');
INSERT INTO mydb.Car_brands (name, country_of_origin) VALUES ('Mercedes-Benz', 'Germany');
INSERT INTO mydb.Car_brands (name, country_of_origin) VALUES ('Hyundai', 'South Korea');

INSERT INTO mydb.Brand_models (name, car_brand_id, fuel_type, transmission) VALUES ('Mustang', 1, 'Gasoline', 'Manual');
INSERT INTO mydb.Brand_models (name, car_brand_id, fuel_type, transmission) VALUES ('C-Class', 2, 'Diesel', 'Automatic');
INSERT INTO mydb.Brand_models (name, car_brand_id, fuel_type, transmission) VALUES ('Sonata', 3, 'Gasoline', 'Automatic');

INSERT INTO mydb.Cars (year, user_id, car_brand_id, brand_model_id, license_plate, current_mileage, color) VALUES ('2022-04-01', 3, 1, 1, 'GHI789', '50000', 'Green');
INSERT INTO mydb.Cars (year, user_id, car_brand_id, brand_model_id, license_plate, current_mileage, color) VALUES ('2022-05-01', 2, 2, 2, 'JKL101', '100000', 'Silver');
INSERT INTO mydb.Cars (year, user_id, car_brand_id, brand_model_id, license_plate, current_mileage, color) VALUES ('2022-06-01', 1, 3, 3, 'MNO112', '150000', 'Black');

INSERT INTO mydb.Car_part_categories (name) VALUES ('Engine');
INSERT INTO mydb.Car_part_categories (name) VALUES ('Suspension');
INSERT INTO mydb.Car_part_categories (name) VALUES ('Brakes');

INSERT INTO mydb.Shops (name, address) VALUES ('Auto Shop 1', '123 Main St');
INSERT INTO mydb.Shops (name, address) VALUES ('Auto Shop 2', '456 Park Ave');
INSERT INTO mydb.Shops (name, address) VALUES ('Auto Shop 3', '789 Elm St');

INSERT INTO mydb.Car_parts (name, serial_number, price, car_part_category_id, shop_id) VALUES ('Engine 1', 'A1B2C3', 1000, 1, 1);
INSERT INTO mydb.Car_parts (name, serial_number, price, car_part_category_id, shop_id) VALUES ('Suspension 1', 'D4E5F6', 500, 2, 2);
INSERT INTO mydb.Car_parts (name, serial_number, price, car_part_category_id, shop_id) VALUES ('Brakes 1', 'G7H8I9', 250, 3, 3);

INSERT INTO mydb.Service_stations (name, address) VALUES ('Service Station 1', '123 Main St');
INSERT INTO mydb.Service_stations (name, address) VALUES ('Service Station 2', '456 Park Ave');
INSERT INTO mydb.Service_stations (name, address) VALUES ('Service Station 3', '789 Elm St');

INSERT INTO mydb.Shop_orders (user_id, shop_id, car_parts_id, date, order_status) VALUES (1, 1, 1, '2022-07-01 12:00:00', 'pending');
INSERT INTO mydb.Shop_orders (user_id, shop_id, car_parts_id, date, order_status) VALUES (2, 2, 2, '2022-08-01 12:00:00', 'shipped');
INSERT INTO mydb.Shop_orders (user_id, shop_id, car_parts_id, date, order_status) VALUES (3, 3, 3, '2022-09-01 12:00:00', 'completed');

INSERT INTO mydb.Car_services (name, price) VALUES ('Oil change', 50);
INSERT INTO mydb.Car_services (name, price) VALUES ('Tire rotation', 100);
INSERT INTO mydb.Car_services (name, price) VALUES ('Brake pads replacement', 250);

INSERT INTO mydb.Service_orders (service_station_id, car_id, car_services_id, date, user_id, service_status) VALUES (1, 1, 1, '2022-07-01 12:00:00', 1, 'pending');
INSERT INTO mydb.Service_orders (service_station_id, car_id, car_services_id, date, user_id, service_status) VALUES (2, 2, 2, '2022-08-01 12:00:00', 2, 'in progress');
INSERT INTO mydb.Service_orders (service_station_id, car_id, car_services_id, date, user_id, service_status) VALUES (3, 3, 3, '2022-09-01 12:00:00', 3, 'completed');

INSERT INTO mydb.Models_parts_compatibility (brand_model_id, car_part_id) VALUES (1, 1);
INSERT INTO mydb.Models_parts_compatibility (brand_model_id, car_part_id) VALUES (2, 2);
INSERT INTO mydb.Models_parts_compatibility (brand_model_id, car_part_id) VALUES (3, 3);