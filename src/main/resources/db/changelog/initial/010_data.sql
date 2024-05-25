insert into AUTHORITIES(AUTHORITY) values ( 'USER' );

insert into USERS(username, personal_account_number, AMOUNT_MONEY, password, enabled, account_type)
VALUES ( 'argen', 111111, 1000.0, '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, 1),
       ('kanat', 222222, 2000.0, '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, 1);


insert into TRANSACTIONS(from_account_id, to_account_id, amount, transaction_time)
VALUES ( 111111,  222222, 500.0, current_timestamp()),
       ( 222222, 111111, 1000.0, current_timestamp());

insert into PROVIDERS(name, ACCOUNT, BALANCE)
VALUES ( 'Мобильная связь', 999999, 1000),
       ('Коммуналка', 888888, 1000),
       ('Интернет и ТВ', 090909, 1000),
       ('Штрафы и налоги', 010101, 1000),
       ('Отопление', 080808, 1000);