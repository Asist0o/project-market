--liquibase formatted sql
--changeset Savchenko:insert-test-data-ads

insert into size_name(id, name) VALUES (1, 'size1');
insert into size_name(id, name) VALUES (2, 'size2');
insert into size_name(id, name) VALUES (3, 'size3');
insert into size_name(id, name) VALUES (4, 'size4');
insert into size_name(id, name) VALUES (5, 'size5');
insert into size_name(id, name) VALUES (6, 'size6');
insert into size_name(id, name) VALUES (7, 'size7');
insert into size_name(id, name) VALUES (8, 'size8');
insert into size_name(id, name) VALUES (9, 'size9');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(1, 'Женский', 'Обувь', 'Кеды');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(2, 'Мужской', 'Обувь', 'Кросовки');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(3, 'Женский', 'Верхняя одежда', 'Куртка');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(4, 'Мужской', 'Верхняя одежда', 'Пальто');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(5, 'Женский', 'Верх', 'Платье');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(6, 'Мужской', 'Верх', 'Пиджак');

insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (1, 1);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (1, 2);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (1, 3);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (2, 1);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (2, 2);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (2, 3);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (3, 4);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (3, 5);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (3, 6);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (4, 4);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (4, 5);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (4, 6);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (5, 7);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (5, 8);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (5, 9);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (6, 7);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (6, 8);
insert into item_subcategories_sizenames(subcategory_id, sizename_id) VALUES (6, 9);

insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (1, 'Nike кеды', '1', 1000, 'Новая с биркой', 1, 1);
insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (2, 'Adidas кросовки', '2', 1000, 'Новая с биркой', 2, 3);
insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (3, 'Nike куртка', '3', 1000, 'Новая с биркой', 3, 4);
insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (4, 'Adidas пальто', '4', 1000, 'Новая с биркой', 4, 6);
insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (5, 'Nike платье', '5', 1000, 'Новая с биркой', 5, 7);
insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (6, 'Adidas пиджак', '6', 1000, 'Новая с биркой', 6, 9);

insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (1, 'Красивый предмет, дорогой', '2000-01-01 00:00:01', 1, false, 1, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (2, 'Домашняя техника', '2000-01-01 00:00:01', 2, false, 2, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (3, 'Компьютерная техника', '2000-01-01 00:00:01', 3, false, 3, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (4, 'Электоронная техника', '2000-01-01 00:00:01', 4, false, 4, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (5, 'Для мытья посуды', '2000-01-01 00:00:01', 5, false, 5, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (6, 'Длинное описание Длинное описане Длинное описание Длинное описание', '2000-01-01 00:00:01', 6, false, 6, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (7, 'Предмет', '2000-01-01 00:00:01', 6, false, 6, 'На проверке');

insert into advertisement_pictures(advertisement_id, pictures) VALUES (1, 1);
insert into advertisement_pictures(advertisement_id, pictures) VALUES (2, 2);
insert into advertisement_pictures(advertisement_id, pictures) VALUES (3, 3);
insert into advertisement_pictures(advertisement_id, pictures) VALUES (4, 4);
insert into advertisement_pictures(advertisement_id, pictures) VALUES (5, 5);
insert into advertisement_pictures(advertisement_id, pictures) VALUES (6, 6);

insert into advertisement_likes(advertisement_id, likes) VALUES (1, 1);
insert into advertisement_likes(advertisement_id, likes) VALUES (2, 2);
insert into advertisement_likes(advertisement_id, likes) VALUES (3, 3);
insert into advertisement_likes(advertisement_id, likes) VALUES (4, 4);
insert into advertisement_likes(advertisement_id, likes) VALUES (5, 5);
insert into advertisement_likes(advertisement_id, likes) VALUES (6, 6);

