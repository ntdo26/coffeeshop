INSERT INTO public.brand(id, name, code) VALUES
    ('b605ded5-e609-437d-bc7c-fbfa31889541', 'TD', 'TD'),
    ('b605ded5-e609-437d-bc7c-fbfa31889542', 'Highlands', 'Highlands'),
    ('b605ded5-e609-437d-bc7c-fbfa31889543', 'Phuc Long', 'PL');

INSERT INTO public.shop(close_time, is_closed, maximum_size_of_queues, number_of_queues, opening_time, id, location, phone_number, tenant, brand_id) VALUES
	(22, false, 20, 1, 7, 'b605ded5-e609-437d-bc7c-fbfa31889531', 'District 1', '+84 354405688', 'TD', 'b605ded5-e609-437d-bc7c-fbfa31889541'),
	(21, false, 20, 1, 7, '5bf7ba7f-add9-4852-9ade-0674ead0c952', 'District 2', '+84 354405689', 'TD', 'b605ded5-e609-437d-bc7c-fbfa31889541'),
	(22, false, 20, 1, 7, '766b5bfe-1e02-451e-af14-8023e561c41b', 'District 4', '+84 354405691', 'Highlands', 'b605ded5-e609-437d-bc7c-fbfa31889542'),
	(21, false, 20, 1, 7, 'aeb790cb-b0e5-490b-b0d1-18bd361939f0', 'District 5', '+84 354405692', 'Highlands', 'b605ded5-e609-437d-bc7c-fbfa31889542'),
	(22, false, 20, 1, 7, 'c6e33bb4-3771-471e-b990-7c2c435f26d1', 'District 7', '+84 354405694', 'PL', 'b605ded5-e609-437d-bc7c-fbfa31889543'),
	(22, false, 20, 1, 7, '542f7824-572d-458e-9659-257f053fc69a', 'District 8', '+84 354405695', 'PL', 'b605ded5-e609-437d-bc7c-fbfa31889543');


INSERT INTO public.drink(name, price, id, discount_by_percent, is_out_of_stock, tenant, minutes_for_preparing, shop_id) VALUES
	('Espresso', '30000', 'aeb790cb-b0e5-490b-b0d1-18bd36193901', 0, false, 'TD', 5, 'b605ded5-e609-437d-bc7c-fbfa31889531'),
	('Mocha', '50000', 'aeb790cb-b0e5-490b-b0d1-18bd36193902', 10, false, 'TD', 10, 'b605ded5-e609-437d-bc7c-fbfa31889531'),
	('Macchiato', '40000', 'aeb790cb-b0e5-490b-b0d1-18bd36193903', 20, false, 'TD', 10, 'b605ded5-e609-437d-bc7c-fbfa31889531'),
	('Coffee Latte', '60000', 'aeb790cb-b0e5-490b-b0d1-18bd36193904', 0, false, 'TD', 15, 'b605ded5-e609-437d-bc7c-fbfa31889531'),
	('Coca Cola', '50000', 'aeb790cb-b0e5-490b-b0d1-18bd36193905', 0, false, 'TD', 5, 'b605ded5-e609-437d-bc7c-fbfa31889531'),
	('Mocha', '40000', 'aeb790cb-b0e5-490b-b0d1-18bd36193906', 0, false, 'TD', 5, '5bf7ba7f-add9-4852-9ade-0674ead0c952'),
    ('Macchiato', '45000', 'aeb790cb-b0e5-490b-b0d1-18bd36193907', 0, false, 'TD', 6, '5bf7ba7f-add9-4852-9ade-0674ead0c952'),
    ('Spirit', '45000', 'aeb790cb-b0e5-490b-b0d1-18bd36193908', 0, false, 'TD', 7, '5bf7ba7f-add9-4852-9ade-0674ead0c952'),
    ('Orange', '45000', 'aeb790cb-b0e5-490b-b0d1-18bd36193909', 0, false, 'TD', 8, '5bf7ba7f-add9-4852-9ade-0674ead0c952'),
    ('Tomato', '45000', 'aeb790cb-b0e5-490b-b0d1-18bd36193910', 0, false, 'TD', 9, '5bf7ba7f-add9-4852-9ade-0674ead0c952'),


	('Mocha', '40000', 'aeb790cb-b0e5-490b-b0d1-18bd36193911', 0, false, 'Highlands', 5, '766b5bfe-1e02-451e-af14-8023e561c41b'),
	('Macchiato', '45000', 'aeb790cb-b0e5-490b-b0d1-18bd36193912', 0, false, 'Highlands', 5, '766b5bfe-1e02-451e-af14-8023e561c41b'),
	('Spirit', '45000', 'aeb790cb-b0e5-490b-b0d1-18bd36193913', 0, false, 'Highlands', 5, '766b5bfe-1e02-451e-af14-8023e561c41b'),
	('Orange', '45000', 'aeb790cb-b0e5-490b-b0d1-18bd36193914', 0, false, 'Highlands', 5, '766b5bfe-1e02-451e-af14-8023e561c41b'),
	('Tomato', '45000', 'aeb790cb-b0e5-490b-b0d1-18bd36193915', 0, false, 'Highlands', 5, '766b5bfe-1e02-451e-af14-8023e561c41b'),
    ('Espresso', '30000', 'aeb790cb-b0e5-490b-b0d1-18bd36193916', 0, false, 'Highlands', 5, 'aeb790cb-b0e5-490b-b0d1-18bd361939f0'),
    ('Mocha', '50000', 'aeb790cb-b0e5-490b-b0d1-18bd36193917', 10, false, 'Highlands', 10, 'aeb790cb-b0e5-490b-b0d1-18bd361939f0'),
    ('Macchiato', '40000', 'aeb790cb-b0e5-490b-b0d1-18bd36193918', 20, false, 'Highlands', 10, 'aeb790cb-b0e5-490b-b0d1-18bd361939f0'),
    ('Coffee Latte', '60000', 'aeb790cb-b0e5-490b-b0d1-18bd36193919', 0, false, 'Highlands', 15, 'aeb790cb-b0e5-490b-b0d1-18bd361939f0'),
    ('Coca Cola', '50000', 'aeb790cb-b0e5-490b-b0d1-18bd36193920', 0, false, 'Highlands', 5, 'aeb790cb-b0e5-490b-b0d1-18bd361939f0'),

	('Iced Coffee', '50000', 'aeb790cb-b0e5-490b-b0d1-18bd36193921', 0, false, 'PL',5, 'c6e33bb4-3771-471e-b990-7c2c435f26d1'),
	('Hot Coffee', '30000', 'aeb790cb-b0e5-490b-b0d1-18bd36193922', 0, false,'PL', 5, 'c6e33bb4-3771-471e-b990-7c2c435f26d1'),
    ('Pepsi', '50000', 'aeb790cb-b0e5-490b-b0d1-18bd36193923', 0, false, 'PL',5, 'c6e33bb4-3771-471e-b990-7c2c435f26d1'),
    ('Mango', '30000', 'aeb790cb-b0e5-490b-b0d1-18bd36193924', 0, false,'PL', 5, 'c6e33bb4-3771-471e-b990-7c2c435f26d1'),
    ('Coca Cola', '30000', 'aeb790cb-b0e5-490b-b0d1-18bd36193925', 0, false,'PL', 5, 'c6e33bb4-3771-471e-b990-7c2c435f26d1'),
    ('Espresso', '30000', 'aeb790cb-b0e5-490b-b0d1-18bd36193926', 0, false, 'PL', 5, '542f7824-572d-458e-9659-257f053fc69a'),
    ('Mocha', '50000', 'aeb790cb-b0e5-490b-b0d1-18bd36193927', 10, false, 'PL', 10, '542f7824-572d-458e-9659-257f053fc69a'),
    ('Macchiato', '40000', 'aeb790cb-b0e5-490b-b0d1-18bd36193928', 20, false, 'PL', 10, '542f7824-572d-458e-9659-257f053fc69a'),
    ('Coffee Latte', '60000', 'aeb790cb-b0e5-490b-b0d1-18bd36193929', 0, false, 'PL', 15, '542f7824-572d-458e-9659-257f053fc69a'),
    ('Coca Cola', '50000', 'aeb790cb-b0e5-490b-b0d1-18bd36193930', 0, false, 'PL', 5, '542f7824-572d-458e-9659-257f053fc69a');


INSERT INTO public.user_information(user_id, tenant, id, user_name) VALUES
    ('e6826fca-49d8-4725-abf1-dc22b101b1f2', 'TD', uuid_generate_v4(), 'Do'),
    ('cd594625-007f-4be0-a52c-5cf8f09e3d39', 'TD', uuid_generate_v4(), 'Hue'),
    ('0b1bf2d5-4d74-41e9-ad33-0d606b35639c', 'TD', uuid_generate_v4(), 'Dung'),
    ('9a5cf910-0d39-4678-aad2-65e83a20c587', 'TD', uuid_generate_v4(), 'Rajiv'),
    ('e6826fca-49d8-4725-abf1-dc22b101b1f2', 'Highlands', uuid_generate_v4(), 'Do'),
    ('cd594625-007f-4be0-a52c-5cf8f09e3d39', 'Highlands', uuid_generate_v4(), 'Hue'),
    ('0b1bf2d5-4d74-41e9-ad33-0d606b35639c', 'Highlands', uuid_generate_v4(), 'Dung'),
    ('9a5cf910-0d39-4678-aad2-65e83a20c587', 'Highlands', uuid_generate_v4(), 'Rajiv'),
    ('e6826fca-49d8-4725-abf1-dc22b101b1f2', 'PL', uuid_generate_v4(), 'Do'),
    ('cd594625-007f-4be0-a52c-5cf8f09e3d39', 'PL', uuid_generate_v4(), 'Hue'),
    ('0b1bf2d5-4d74-41e9-ad33-0d606b35639c', 'PL', uuid_generate_v4(), 'Dung'),
    ('9a5cf910-0d39-4678-aad2-65e83a20c587', 'PL', uuid_generate_v4(), 'Rajiv');