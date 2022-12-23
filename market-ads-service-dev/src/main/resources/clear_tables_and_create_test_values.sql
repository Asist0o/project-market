# delete from advertisement_likes;
# delete from advertisement_pictures;
# delete from advertisement;
# delete from item;
# delete from item_subcategories_sizenames;
# delete from item_subcategory;
# delete from size_name;

insert into size_name(id, name) VALUES (nextval('sizename_id_seq'), 'size1');
insert into size_name(id, name) VALUES (nextval('sizename_id_seq'), 'size2');
insert into size_name(id, name) VALUES (nextval('sizename_id_seq'), 'size3');
insert into size_name(id, name) VALUES (nextval('sizename_id_seq'), 'size4');
insert into size_name(id, name) VALUES (nextval('sizename_id_seq'), 'size5');
insert into size_name(id, name) VALUES (nextval('sizename_id_seq'), 'size6');
insert into size_name(id, name) VALUES (nextval('sizename_id_seq'), 'size7');
insert into size_name(id, name) VALUES (nextval('sizename_id_seq'), 'size8');
insert into size_name(id, name) VALUES (nextval('sizename_id_seq'), 'size9');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(nextval('item_subcategories_id_seq'), 'Женский', 'Обувь', 'Кеды');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(nextval('item_subcategories_id_seq'), 'Мужской', 'Обувь', 'Кросовки');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(nextval('item_subcategories_id_seq'), 'Женский', 'Верхняя одежда', 'Куртка');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(nextval('item_subcategories_id_seq'), 'Мужской', 'Верхняя одежда', 'Пальто');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(nextval('item_subcategories_id_seq'), 'Женский', 'Верх', 'Платье');

insert into item_subcategory(id, gender_type, item_category_name, subcategory_name)
values(nextval('item_subcategories_id_seq'), 'Мужской', 'Верх', 'Пиджак');

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
values (nextval('items_id_seq'), 'Nike кеды', '1', 1000, 'Новая с биркой', 1, 1);
insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (nextval('items_id_seq'), 'Adidas кросовки', '2', 1000, 'Новая с биркой', 2, 3);
insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (nextval('items_id_seq'), 'Nike куртка', '3', 1000, 'Новая с биркой', 3, 4);
insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (nextval('items_id_seq'), 'Adidas пальто', '4', 1000, 'Новая с биркой', 4, 6);
insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (nextval('items_id_seq'), 'Nike платье', '5', 1000, 'Новая с биркой', 5, 7);
insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
values (nextval('items_id_seq'), 'Adidas пиджак', '6', 1000, 'Новая с биркой', 6, 9);

insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (nextval('advertisements_id_seq'), 'Описание1', '2000-01-01 00:00:01', 1, false, 1, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (nextval('advertisements_id_seq'), 'Описание2', '2000-01-01 00:00:01', 2, false, 2, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (nextval('advertisements_id_seq'), 'Описание3', '2000-01-01 00:00:01', 3, false, 3, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (nextval('advertisements_id_seq'), 'Описание4', '2000-01-01 00:00:01', 4, false, 4, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (nextval('advertisements_id_seq'), 'Описание5', '2000-01-01 00:00:01', 5, false, 5, 'На проверке');
insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
VALUES (nextval('advertisements_id_seq'), 'Описание6', '2000-01-01 00:00:01', 6, false, 6, 'На проверке');

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

