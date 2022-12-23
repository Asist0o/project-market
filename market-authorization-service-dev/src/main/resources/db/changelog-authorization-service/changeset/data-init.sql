--liquibase formatted sql
--changeset Savchenko:insert-test-data
insert into role (authority)
values ('ROLE_ADMIN'),
       ('ROLE_USER');
insert into account(name, last_name, email, password_hash, role)
VALUES ('admin', 'admin', 'admin@mail.com', '$2a$12$JS.gIjOtq/KZxeZkMaMNV.U4Dw4C2vTF1j.ZuXojc4Zq9fknrBxFq',
        'ROLE_ADMIN'),
       ('user', 'user', 'user@mail.com', '$2a$12$lKFhZB0j6pZH7SGHpI0LWeUq7ANJMn0npor.fviBWJnMXp728l0Zq', 'ROLE_USER');
